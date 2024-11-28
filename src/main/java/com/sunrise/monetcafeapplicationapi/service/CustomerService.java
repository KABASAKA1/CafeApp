package com.sunrise.monetcafeapplicationapi.service;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOCustomerIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOSepetIU;
import com.sunrise.monetcafeapplicationapi.dto.mapper.CustomerMapper;
import com.sunrise.monetcafeapplicationapi.dto.mapper.SepetMapper;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOBildirimGecmisi;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOCustomer;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOSepet;
import com.sunrise.monetcafeapplicationapi.exception.ResourceNotFoundException;
import com.sunrise.monetcafeapplicationapi.model.Customer;
import com.sunrise.monetcafeapplicationapi.model.CustomerKupon;
import com.sunrise.monetcafeapplicationapi.model.Sepet;
import com.sunrise.monetcafeapplicationapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final SepetMapper sepetMapper;
    private final BildirimGecmisiService bildirimGecmisiService;

    public DTOCustomer createCustomer(DTOCustomerIU request){
        return Optional.ofNullable(request)
                .map(dtoCustomerIU -> {
                    Customer customer = customerMapper.customerToENTITY(dtoCustomerIU);
                    Sepet sepet = new Sepet();
                    CustomerKupon customerKupon = new CustomerKupon();
                    customer.setSepet(sepet);
                    customer.setCustomerKupon(customerKupon);
                    return customerMapper.customerToDTO(customerRepository.save(customer));
                })
                .orElseThrow(()->new ResourceNotFoundException("Customer was not created"));
    }

    public DTOCustomer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::customerToDTO)
                .orElseThrow(()->new ResourceNotFoundException("Customer not found for this id:"+id));
    }

    public DTOSepet getSepetByCustomerId(Long id) {
        return customerRepository.findById(id)
                .map(Customer::getSepet)
                .map(sepetMapper::sepetToDTO)
                .orElseThrow(()->new ResourceNotFoundException("Customer not found for this id:"+id));

    }

    public DTOCustomer updateCustomerById(Long id , DTOCustomerIU request){
        return customerRepository.findById(id)
                .map(customer -> {
                    customerMapper.updateCustomerFromDTO(request , customer);
                    return customerMapper.customerToDTO(customerRepository.save(customer));
                })
                .orElseThrow(()->new ResourceNotFoundException("Customer not found for this id:"+id));
    }

    public DTOSepet updateSepetByCustomerId(Long id , DTOSepetIU request){
        return customerRepository.findById(id)
                .map(customer -> {
                    Sepet sepet = customer.getSepet();
                    if (isRequestEmpty(request)){
                        sepet.getSepettekiProducts().clear();
                        return customerRepository.save(customer).getSepet();
                    }else {
                        sepetMapper.updateSepetFromDTO(request, sepet);
                        return customerRepository.save(customer).getSepet();
                    }
                })
                .map(sepetMapper::sepetToDTO)
                .orElseThrow(()->new ResourceNotFoundException("Customer not found for this id:"+id));
    }

    private boolean isRequestEmpty(DTOSepetIU request) {
        // Örnek: Sepet içeriğini kontrol et
        return request == null || (request.getSepettekiProducts() == null || request.getSepettekiProducts().isEmpty());
    }



    public DTOBildirimGecmisi getBildirimGecmisi(){
        return bildirimGecmisiService.getBildirimGecmisi();
    }

}
