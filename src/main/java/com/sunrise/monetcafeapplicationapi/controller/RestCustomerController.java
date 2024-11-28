package com.sunrise.monetcafeapplicationapi.controller;

import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.AutocationRequest;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.CreateUserRequst;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.CreateUserResponse;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOCustomerIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOSepetIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOBildirimGecmisi;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOCustomer;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOSepet;
import com.sunrise.monetcafeapplicationapi.enums.Yetki;
import com.sunrise.monetcafeapplicationapi.service.AutocaticationService;
import com.sunrise.monetcafeapplicationapi.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/customers")
public class RestCustomerController {
    private final CustomerService customerService;
    private final AutocaticationService autocaticationService;

    @PostMapping
    public ResponseEntity<CreateUserResponse<DTOCustomer>> createCustomer(@RequestBody @Valid CreateUserRequst<DTOCustomerIU> request){
        CreateUserResponse<DTOCustomer> response = new CreateUserResponse<>(autocaticationService.createUser(request.getUser(), Yetki.CUSTOMER), customerService.createCustomer(request.getRequest()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOCustomer> getCustomerById(@PathVariable Long id , @RequestBody AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(),Yetki.CUSTOMER);
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/{id}/sepet")
    public ResponseEntity<DTOSepet> getSepetByCustomerId(@PathVariable Long id , @RequestBody AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(),Yetki.CUSTOMER);
        return ResponseEntity.ok(customerService.getSepetByCustomerId(id));
    }

    @GetMapping("/bildirimler")
    public ResponseEntity<DTOBildirimGecmisi> getBildirimler(@RequestBody AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(),Yetki.CUSTOMER);
        return ResponseEntity.ok(customerService.getBildirimGecmisi());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOCustomer> updateCustomerById(@PathVariable Long id , @RequestBody AutocationRequest<DTOCustomerIU> request){
        autocaticationService.kullaniciDogrulama(request.getToken(),Yetki.CUSTOMER);
        return ResponseEntity.ok(customerService.updateCustomerById(id , request.getRequest()));
    }

    @PutMapping("/{id}/sepet")
    public ResponseEntity<DTOSepet> updateSepetByCustomerId(@PathVariable Long id , @RequestBody AutocationRequest<DTOSepetIU> request){
        autocaticationService.kullaniciDogrulama(request.getToken(),Yetki.CUSTOMER);
        return ResponseEntity.ok(customerService.updateSepetByCustomerId(id , request.getRequest()));
    }
}
