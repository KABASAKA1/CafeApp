package com.sunrise.monetcafeapplicationapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.AutocationRequest;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.CreateUserRequst;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.CreateUserResponse;
import com.sunrise.monetcafeapplicationapi.dto.inward.*;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOBildirimGecmisi;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOCustomer;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOSepet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = com.sunrise.monetcafeapplicationapi.starter.MonetCafeApplicationApiApplication.class)
class RestCustomerControllerTest {
    @Autowired
    private RestCustomerController restCustomerController;
    @Autowired
    private ObjectMapper objectMapper;


    private String token;
    private Long customerId;

    @Test
    void createCustomer() throws JsonProcessingException {
        DTOCustomerIU dtoCustomerIU = new DTOCustomerIU();
        dtoCustomerIU.setName("serkan");    //---
        dtoCustomerIU.setPhoneNumber("423252141");  //----

        DTOUserIU dtoUserIU = new DTOUserIU();
        dtoUserIU.setPhoneNumber(dtoCustomerIU.getPhoneNumber());   //---
        dtoUserIU.setPassword("123");   //---

        CreateUserRequst<DTOCustomerIU> request = new CreateUserRequst<>();
        request.setUser(dtoUserIU);
        request.setRequest(dtoCustomerIU);

        ResponseEntity<CreateUserResponse<DTOCustomer>> customer = restCustomerController.createCustomer(request);
        token = Objects.requireNonNull(customer.getBody()).getToken();   //token alınır !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        customerId = customer.getBody().getResponse().getId();  //customerId alınır !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
        System.out.println(response);
    }

    @Test
    void getCustomerById() throws JsonProcessingException {
        AutocationRequest<Long> request= new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOCustomer> customer = restCustomerController.getCustomerById(customerId, request); //!!!!!!!!!!!!!!!!!!!!!
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
        System.out.println(response);
    }

    @Test
    void getSepetByCustomerId() throws JsonProcessingException {
        AutocationRequest<Long> request= new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOSepet> sepet = restCustomerController.getSepetByCustomerId(customerId, request);  //!!!!!!!!!!!!!!!!!!!!!!!
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sepet);
        System.out.println(response);
    }

    @Test
    void getBildirimler() throws JsonProcessingException {
        AutocationRequest<Long> request= new AutocationRequest<>();
        request.setToken(token);    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOBildirimGecmisi> bildirimler = restCustomerController.getBildirimler(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bildirimler);
        System.out.println(response);
    }

    @Test
    void updateCustomerById() throws JsonProcessingException {
        DTOCustomerIU dtoCustomerIU = new DTOCustomerIU();
        dtoCustomerIU.setName("serkan");    //------
        dtoCustomerIU.setPhoneNumber("312412"); //------

        AutocationRequest<DTOCustomerIU> request= new AutocationRequest<>();
        request.setToken(token);    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        request.setRequest(dtoCustomerIU);

        ResponseEntity<DTOCustomer> customer = restCustomerController.updateCustomerById(customerId, request);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
        System.out.println(response);
    }

    @Test
    void updateSepetByCustomerId() throws JsonProcessingException {

        DTOSepetIU dtoSepetIU = new DTOSepetIU();
        List<DTOSepettekiProductIU> sepettekiProducts = dtoSepetIU.getSepettekiProducts();
        DTOSepettekiProductIU sepettekiProductIU = new DTOSepettekiProductIU();
        sepettekiProductIU.setAdet(1);  //-------------
        sepettekiProductIU.setProductId(1L); //-------------
        sepettekiProductIU.setId(1L);   //---------------
        sepettekiProducts.add(sepettekiProductIU);  //-------------

        List<DTOSepettekiKuponProductIU> sepettekiKuponProducts = dtoSepetIU.getSepettekiKuponProducts();
        DTOSepettekiKuponProductIU dtoSepettekiKuponProductIU = new DTOSepettekiKuponProductIU();
        dtoSepettekiKuponProductIU.setAdet(1);  //----------
        dtoSepettekiKuponProductIU.setProductId(1L);    //--------------
        dtoSepettekiKuponProductIU.setId(1L);   //--------------
        sepettekiProducts.add(sepettekiProductIU);  //-------------

        List<DTOSepettekiKampanyaIU> sepettekiKampanyas = dtoSepetIU.getSepettekiKampanyas();
        DTOSepettekiKampanyaIU dtoSepettekiKampanyaIU = new DTOSepettekiKampanyaIU();
        dtoSepettekiKampanyaIU.setAdet(1);  //--------------
        dtoSepettekiKampanyaIU.setId(1L);   //-----------------
        dtoSepettekiKampanyaIU.setKampanyaId(1L);   //------------
        sepettekiProducts.add(sepettekiProductIU);  //---------------

        AutocationRequest<DTOSepetIU> request= new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        request.setRequest(dtoSepetIU);

        ResponseEntity<DTOSepet> sepet = restCustomerController.updateSepetByCustomerId(customerId, request);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1!!!!!!!!!
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sepet);
        System.out.println(response);
    }
}