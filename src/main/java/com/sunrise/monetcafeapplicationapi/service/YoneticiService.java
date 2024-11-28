package com.sunrise.monetcafeapplicationapi.service;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOBildirimIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOKuponParameterIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOYoneticiIU;
import com.sunrise.monetcafeapplicationapi.dto.mapper.YoneticiMapper;
import com.sunrise.monetcafeapplicationapi.dto.outward.*;
import com.sunrise.monetcafeapplicationapi.exception.ResourceNotFoundException;
import com.sunrise.monetcafeapplicationapi.model.Yonetici;
import com.sunrise.monetcafeapplicationapi.repository.YoneticiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class YoneticiService {
    private final YoneticiRepository yoneticiRepository;
    private final YoneticiMapper yoneticiMapper;
    private final HavuzService havuzService;
    private final BildirimGecmisiService bildirimGecmisiService;
    private final OrderService orderService;
    private final CustomerService customerService;


    public DTOYonetici createYonetici(DTOYoneticiIU request){
        return Optional.ofNullable(request)
                .map(dtoYoneticiIU -> {
                    Yonetici yonetici = yoneticiMapper.yoneticiToENTITY(dtoYoneticiIU);
                    yoneticiMapper.updateYoneticiFromDTO(dtoYoneticiIU , yonetici);
                    return yoneticiMapper.yoneticiToDTO(yoneticiRepository.save(yonetici));
                })
                .orElseThrow(()-> new IllegalArgumentException("Request body cannot be null"));
    }

    public DTOYonetici getYoneticiById(Long id){
        return yoneticiRepository.findById(id)
                .map(yoneticiMapper::yoneticiToDTO)
                .orElseThrow(()-> new ResourceNotFoundException("Yonetici not found for this id:"+id));
    }

    public DTOYonetici updateYoneticiById(Long id , DTOYoneticiIU request){
        if (request == null)
            throw new IllegalArgumentException("Request body cannot be null");
        return yoneticiRepository.findById(id)
                .map(yonetici -> {
                    yoneticiMapper.updateYoneticiFromDTO(request , yonetici);
                    return yoneticiMapper.yoneticiToDTO(yoneticiRepository.save(yonetici));
                })
                .orElseThrow(()-> new ResourceNotFoundException("Yonetici not found for this id:"+id));
    }

    public void deleteYoneticiById(Long id){
        Yonetici yonetici = yoneticiRepository.findById(id)
                .map(yonetici1 -> {
                    yoneticiRepository.delete(yonetici1);
                    return yonetici1;
                })
                .orElseThrow(()-> new ResourceNotFoundException("Yonetici not found for this id:"+id));
    }




    public DTOBildirimGecmisi createBildirim(DTOBildirimIU request){
        return bildirimGecmisiService.createBildirim(request);
    }
    public DTOBildirimGecmisi getBildirimGecmisi(){
        return bildirimGecmisiService.getBildirimGecmisi();
    }
    public DTOBildirimGecmisi updateBildirim(Long id , DTOBildirimIU request){
        return bildirimGecmisiService.updateBildirim(id , request);
    }
    public DTOBildirimGecmisi deleteBildirim(Long id){
        return bildirimGecmisiService.deleteBildirim(id);
    }




    public DTOSepet getSepetByCustomerId(Long customerId){
        return customerService.getSepetByCustomerId(customerId);
    }




    public String ProcessCustomerOrder(Long customerId){
        return orderPlace(customerId)+orderUsingKampanya(customerId)+orderUsingKupon(customerId);
    }

    private String orderPlace(Long customerId){
        if (orderService.orderPlace(customerId)){
            return "Order successful\n";
        }else {
            return "Order failed\n";
        }
    }
    private String orderUsingKupon(Long customerId){
        if (orderService.orderUsingKupon(customerId)){
            return "Kupon order successful\n";
        }else {
            return "Kupon order failed\n";
        }
    }
    private String orderUsingKampanya(Long customerId){
        if (orderService.orderUsingKampanya(customerId)){
            return "Kampanya order successful\n";
        }else {
            return "Kampanya order failed\n";
        }
    }





    public DTOHavuz getAllHavuz(){
        return havuzService.getAllHavuz();
    }
    public List<DTOHavuzdakiKampanya> getHavuzdakiKampanyas() {
        return havuzService.getHavuzdakiKampanyas();
    }
    public List<DTOHavuzdakiProduct> getHavuzdakiProducts(){
        return havuzService.getHavuzdakiProducts();
    }
    public List<DTOHavuzdakiKuponProduct> getHavuzdakiKuponProducts(){
        return havuzService.getHavuzdakiKuponProducts();
    }




    public DTOKuponParameter getKuponParameter(){
        return havuzService.getKuponParameter();
    }
    public DTOKuponParameter updateKuponParameter(DTOKuponParameterIU request){
        return havuzService.updateKuponParameter(request);
    }
    public DTOKuponParameter createKuponParameter(DTOKuponParameterIU request){
        return havuzService.createKuponParameter(request);
    }


}
