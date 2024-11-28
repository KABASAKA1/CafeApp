package com.sunrise.monetcafeapplicationapi.service;

import com.sunrise.monetcafeapplicationapi.dto.mapper.OrderMapper;
import com.sunrise.monetcafeapplicationapi.enums.Category;
import com.sunrise.monetcafeapplicationapi.enums.MainCategory;
import com.sunrise.monetcafeapplicationapi.exception.ResourceNotFoundException;
import com.sunrise.monetcafeapplicationapi.model.*;
import com.sunrise.monetcafeapplicationapi.repository.CustomerRepository;
import com.sunrise.monetcafeapplicationapi.repository.HavuzRepository;
import com.sunrise.monetcafeapplicationapi.repository.KuponParameterRepository;
import com.sunrise.monetcafeapplicationapi.repository.SepetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerRepository customerRepository;
    private final HavuzRepository havuzRepository;
    private final SepetRepository sepetRepository;
    private final KuponParameterRepository kuponParameterRepository;
    private final OrderMapper orderMapper;

    protected boolean orderPlace(Long customerId){
        return customerRepository.findById(customerId)
                .map(this::processCustomerKupon)
                .map(Customer::getSepet)
                .map(this::updateHavuz)
                .orElseThrow(() -> new ResourceNotFoundException("Order place process was failed for this customer id :: " + customerId));
    }

    private Customer processCustomerKupon(Customer customer){
        CustomerKupon customerKupon = customer.getCustomerKupon();
        customer.getSepet().getSepettekiProducts().forEach(product -> {
            Category category = product.getProduct().getCategory();
            Integer adet = product.getAdet();
            if (category.getMainCategory()== MainCategory.KAHVE){
                customerKupon.setKahveCekirdek(customerKupon.getKahveCekirdek() + adet);
            } else if (category.getMainCategory() == MainCategory.TATLI) {
                customerKupon.setTatliDilim(customerKupon.getTatliDilim() + adet);
            }
        });
        KuponParameter kuponParameter = kuponParameterRepository.findAll().stream().findFirst()
                        .orElseThrow(()-> new ResourceNotFoundException("Kupon parameter not found , You must create one !!!"));
        customerKupon.setKuponKahve(customerKupon.getKuponKahve() + customerKupon.getKahveCekirdek() % kuponParameter.getKahveParameter());
        customerKupon.setKuponTatli(customerKupon.getKuponTatli() + customerKupon.getTatliDilim() % kuponParameter.getTatliParameter());

        return customer;
    }
    private boolean updateHavuz(Sepet sepet){
        return havuzRepository.findAll().stream().findFirst()
                .map(havuz -> {
                    if (sepet.getSepettekiProducts().isEmpty())
                        return false;
                    List<HavuzdakiProduct> request = orderMapper.listToOrderPlace(sepet.getSepettekiProducts());
                    havuz.getHavuzdakiProducts().addAll(request);
                    havuzRepository.save(havuz);
                    sepet.getSepettekiProducts().clear();
                    sepetRepository.save(sepet);
                    return true;
                })
                .orElseGet(() -> {
                    if (sepet.getSepettekiProducts().isEmpty())
                        return false;
                    Havuz havuz = new Havuz();
                    havuz.getHavuzdakiProducts().addAll(orderMapper.listToOrderPlace(sepet.getSepettekiProducts()));
                    havuzRepository.save(havuz);
                    sepet.getSepettekiProducts().clear();
                    sepetRepository.save(sepet);
                    return true;
                });
    }


    protected boolean orderUsingKupon(Long customerId){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        Sepet sepet = customer.getSepet();
        sepet.getSepettekiKuponProducts().forEach(product -> {
            Category category = product.getProduct().getCategory();
            Integer adet = product.getAdet();
            if (category.getMainCategory()== MainCategory.KAHVE){
                customer.getCustomerKupon().setKahveCekirdek(customer.getCustomerKupon().getKahveCekirdek() - adet);
            } else if (category.getMainCategory() == MainCategory.TATLI) {
                customer.getCustomerKupon().setTatliDilim(customer.getCustomerKupon().getTatliDilim() - adet);
            }
        });
        List<SepettekiKuponProduct> sepettekiKuponProducts = sepet.getSepettekiKuponProducts();
        List<HavuzdakiKuponProduct> havuzdakiKuponProducts = orderMapper.listToUsingKupon(sepettekiKuponProducts);

        return havuzRepository.findAll().stream().findFirst()
                .map(havuz -> {
                    if (sepet.getSepettekiKampanyas().isEmpty())
                        return false;
                    havuz.getHavuzdakiKuponProducts().addAll(havuzdakiKuponProducts);
                    havuzRepository.save(havuz);
                    sepet.getSepettekiKampanyas().clear();
                    sepetRepository.save(sepet);
                    return true;
                })
                .orElseGet(() -> {
                    if (sepet.getSepettekiKampanyas().isEmpty())
                        return false;
                    Havuz havuz = new Havuz();
                    havuz.getHavuzdakiKuponProducts().addAll(havuzdakiKuponProducts);
                    havuzRepository.save(havuz);
                    sepet.getSepettekiKampanyas().clear();
                    sepetRepository.save(sepet);
                    return true;
                });
    }

    protected boolean orderUsingKampanya(Long customerId){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        Sepet sepet = customer.getSepet();
        List<SepettekiKampanya> sepettekiKampanyas = sepet.getSepettekiKampanyas();
        List<HavuzdakiKampanya> havuzdakiKampanyas = orderMapper.listToUsingKampanya(sepettekiKampanyas);

        return havuzRepository.findAll().stream().findFirst()
                .map(havuz -> {
                    if (sepet.getSepettekiKampanyas().isEmpty())
                        return false;
                    havuz.getHavuzdakiKampanyas().addAll(havuzdakiKampanyas);
                    havuzRepository.save(havuz);
                    sepet.getSepettekiKampanyas().clear();
                    sepetRepository.save(sepet);
                    return true;
                })
                .orElseGet(() -> {
                    if (sepet.getSepettekiKampanyas().isEmpty())
                        return false;
                    Havuz havuz = new Havuz();
                    havuz.getHavuzdakiKampanyas().addAll(havuzdakiKampanyas);
                    havuzRepository.save(havuz);
                    sepet.getSepettekiKampanyas().clear();
                    sepetRepository.save(sepet);
                    return true;
                });
    }

}
