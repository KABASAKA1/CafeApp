package com.sunrise.monetcafeapplicationapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.AutocationRequest;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.CreateUserRequst;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.CreateUserResponse;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOBildirimIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOKuponParameterIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOUserIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOYoneticiIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = com.sunrise.monetcafeapplicationapi.starter.MonetCafeApplicationApiApplication.class)
class RestYoneticiControllerTest {
    @Autowired
    private RestYoneticiController restYoneticiController;
    @Autowired
    private ObjectMapper objectMapper ;

    private String token="3226C162A2BF4A16851D";
    private Long yoneticiId=1L;

    @Test
    void createYonetici() throws JsonProcessingException {
        DTOYoneticiIU dtoYoneticiIU = new DTOYoneticiIU();
        dtoYoneticiIU.setName("Eray");  //---------------------
        dtoYoneticiIU.setPhoneNumber("2352623261"); //--------------------

        DTOUserIU dtoUserIU = new DTOUserIU();
        dtoUserIU.setPhoneNumber(dtoYoneticiIU.getPhoneNumber());
        dtoUserIU.setPassword("123");   //----------------------

        CreateUserRequst<DTOYoneticiIU> request = new CreateUserRequst<>();
        request.setUser(dtoUserIU);
        request.setRequest(dtoYoneticiIU);

        ResponseEntity<CreateUserResponse<DTOYonetici>> yonetici = restYoneticiController.createYonetici(request);
        token = Objects.requireNonNull(yonetici.getBody()).getToken();  //token alınır
        yoneticiId = yonetici.getBody().getResponse().getId();  //yoneticiId alınır
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(yonetici);
        System.out.println(response);
    }

    @Test
    void getYoneticiById() throws JsonProcessingException {
        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOYonetici> yonetici = restYoneticiController.getYoneticiById(yoneticiId, request);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(yonetici);
        System.out.println(response);
    }

    @Test
    void updateYoneticiById() throws JsonProcessingException {
        DTOYoneticiIU dtoYoneticiIU = new DTOYoneticiIU();
        dtoYoneticiIU.setName("Eray");  //----------------------
        dtoYoneticiIU.setPhoneNumber("543213"); //----------------------

        AutocationRequest<DTOYoneticiIU> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        request.setRequest(dtoYoneticiIU);

        ResponseEntity<DTOYonetici> yonetici = restYoneticiController.updateYoneticiById(yoneticiId, request);  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(yonetici);
        System.out.println(response);
    }

    @Test
    void deleteYoneticiById() {
        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);

        ResponseEntity<Void> voidResponseEntity = restYoneticiController.deleteYoneticiById(yoneticiId, request);
    }

    @Test
    void createBildirim() throws JsonProcessingException {
        DTOBildirimIU dtoBildirimIU = new DTOBildirimIU();
        dtoBildirimIU.setTitle("Tatlılarda müjdee");    //--------------------
        dtoBildirimIU.setDescription("3 alana 1 bedavaa "); //------------------------

        AutocationRequest<DTOBildirimIU> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        request.setRequest(dtoBildirimIU);

        ResponseEntity<DTOBildirimGecmisi> bildirimler = restYoneticiController.createBildirim(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bildirimler);
        System.out.println(response);
    }

    @Test
    void getBildirimler() throws JsonProcessingException {
        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOBildirimGecmisi> bildirimler = restYoneticiController.getBildirimler(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bildirimler);
        System.out.println(response);
    }

    @Test
    void updateBildirimById() throws JsonProcessingException {
        DTOBildirimIU dtoBildirimIU = new DTOBildirimIU();
        dtoBildirimIU.setId(1L);    //--------------
        dtoBildirimIU.setTitle("Yılbaşı hediyesi"); //-------------------
        dtoBildirimIU.setDescription("1 alana 1 bedavaa "); //----------------

        AutocationRequest<DTOBildirimIU> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        request.setRequest(dtoBildirimIU);

        ResponseEntity<DTOBildirimGecmisi> bildirimler = restYoneticiController.updateBildirimById(dtoBildirimIU.getId(), request); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bildirimler);
        System.out.println(response);
    }

    @Test
    void deleteBildirimById() throws JsonProcessingException {
        Long bildirimID = 1L;   //----------------------

        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOBildirimGecmisi> bildirimler = restYoneticiController.deleteBildirimById(bildirimID, request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bildirimler);
        System.out.println(response);
    }

    @Test
    void getSepetByCustomerId() throws JsonProcessingException {
        Long customerID = 1L;   //---------------------

        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOSepet> sepet = restYoneticiController.getSepetByCustomerId(customerID, request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sepet);
        System.out.println(response);
    }

    @Test
    void orderPlace() throws JsonProcessingException {
        Long customerID = 1L;   //----------------------

        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<String> serverResponse = restYoneticiController.orderPlace(customerID, request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(serverResponse);
        System.out.println(response);
    }

    @Test
    void getAllHavuz() throws JsonProcessingException {
        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOHavuz> allHavuz = restYoneticiController.getAllHavuz(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allHavuz);
        System.out.println(response);
    }

    @Test
    void getAllHavuzdakiKampanya() throws JsonProcessingException {
        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<List<DTOHavuzdakiKampanya>> allHavuzdakiKampanya = restYoneticiController.getAllHavuzdakiKampanya(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allHavuzdakiKampanya);
        System.out.println(response);
    }

    @Test
    void getAllHavuzdakiKuponProduct() throws JsonProcessingException {
        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<List<DTOHavuzdakiKuponProduct>> allHavuzdakiKuponProduct = restYoneticiController.getAllHavuzdakiKuponProduct(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allHavuzdakiKuponProduct);
        System.out.println(response);
    }

    @Test
    void getAllHavuzdakiProduct() throws JsonProcessingException {
        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<List<DTOHavuzdakiProduct>> allHavuzdakiProduct = restYoneticiController.getAllHavuzdakiProduct(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allHavuzdakiProduct);
        System.out.println(response);
    }

    @Test
    void getKuponParameter() throws JsonProcessingException {
        AutocationRequest<Long> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        ResponseEntity<DTOKuponParameter> kuponParameter = restYoneticiController.getKuponParameter(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(kuponParameter);
        System.out.println(response);
    }

    @Test
    void updateKuponParameter() throws JsonProcessingException {
        DTOKuponParameterIU kuponParameterIU = new DTOKuponParameterIU();
        kuponParameterIU.setKahveParameter(4);  //----------------
        kuponParameterIU.setTatliParameter(8);  //--------------------

        AutocationRequest<DTOKuponParameterIU> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        request.setRequest(kuponParameterIU);

        ResponseEntity<DTOKuponParameter> kuponParameter = restYoneticiController.updateKuponParameter(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(kuponParameter);
        System.out.println(response);
    }

    @Test
    void createKuponParameter() throws JsonProcessingException {
        DTOKuponParameterIU kuponParameterIU = new DTOKuponParameterIU();
        kuponParameterIU.setKahveParameter(4);  //----------------
        kuponParameterIU.setTatliParameter(8);  //--------------------

        AutocationRequest<DTOKuponParameterIU> request = new AutocationRequest<>();
        request.setToken(token);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        request.setRequest(kuponParameterIU);

        ResponseEntity<DTOKuponParameter> kuponParameter = restYoneticiController.createKuponParameter(request);
        String response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(kuponParameter);
        System.out.println(response);
    }
}