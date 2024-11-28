package com.sunrise.monetcafeapplicationapi.controller;

import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.AutocationRequest;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.CreateUserRequst;
import com.sunrise.monetcafeapplicationapi.dto.autocationDTO.CreateUserResponse;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOBildirimIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOKuponParameterIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOYoneticiIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.*;
import com.sunrise.monetcafeapplicationapi.enums.Yetki;
import com.sunrise.monetcafeapplicationapi.service.AutocaticationService;
import com.sunrise.monetcafeapplicationapi.service.YoneticiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/yoneticiler")
public class RestYoneticiController {
    private final YoneticiService yoneticiService;
    private final AutocaticationService autocaticationService;

    @PostMapping
    public ResponseEntity<CreateUserResponse<DTOYonetici>> createYonetici(@RequestBody @Valid CreateUserRequst<DTOYoneticiIU> request){
        CreateUserResponse<DTOYonetici> response = new CreateUserResponse<>(autocaticationService.createUser(request.getUser(), Yetki.YONETICI), yoneticiService.createYonetici(request.getRequest()));
        return ResponseEntity.ok(response);
    }

    @GetMapping(("{id}"))
    public ResponseEntity<DTOYonetici> getYoneticiById(@PathVariable Long id ,@RequestBody AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.getYoneticiById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOYonetici> updateYoneticiById(@PathVariable Long id, @RequestBody @Valid AutocationRequest<DTOYoneticiIU> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.updateYoneticiById(id, request.getRequest()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYoneticiById(@PathVariable Long id , @RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        yoneticiService.deleteYoneticiById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/bildirimler")
    public ResponseEntity<DTOBildirimGecmisi> createBildirim(@RequestBody AutocationRequest<DTOBildirimIU> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.createBildirim(request.getRequest()));
    }

    @GetMapping("/bildirimler")
    public ResponseEntity<DTOBildirimGecmisi> getBildirimler(@RequestBody AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.getBildirimGecmisi());
    }

    @PutMapping("/bildirimler/{bildirimID}")
    public ResponseEntity<DTOBildirimGecmisi> updateBildirimById(@PathVariable Long bildirimID, @RequestBody @Valid AutocationRequest<DTOBildirimIU> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.updateBildirim(bildirimID, request.getRequest()));
    }

    @DeleteMapping("/bildirimler/{bildirimID}")
    public ResponseEntity<DTOBildirimGecmisi> deleteBildirimById(@PathVariable Long bildirimID, @RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.deleteBildirim(bildirimID));
    }

    @GetMapping("/sepet/{customerID}")
    public ResponseEntity<DTOSepet> getSepetByCustomerId(@PathVariable Long customerID, @RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.getSepetByCustomerId(customerID));
    }

    @PostMapping("/order/{customerID}")
    public ResponseEntity<String> orderPlace(@PathVariable Long customerID , @RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.ProcessCustomerOrder(customerID));
    }

    @GetMapping("/havuz")
    public ResponseEntity<DTOHavuz> getAllHavuz(@RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.getAllHavuz());
    }

    @GetMapping("/havuz/kampanyalar")
    public ResponseEntity<List<DTOHavuzdakiKampanya>> getAllHavuzdakiKampanya(@RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.getHavuzdakiKampanyas());
    }

    @GetMapping("/havuz/kuponProducts")
    public ResponseEntity<List<DTOHavuzdakiKuponProduct>> getAllHavuzdakiKuponProduct(@RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.getHavuzdakiKuponProducts());
    }

    @GetMapping("/havuz/products")
    public ResponseEntity<List<DTOHavuzdakiProduct>> getAllHavuzdakiProduct(@RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.getHavuzdakiProducts());
    }

    @GetMapping("/kuponParameter")
    public ResponseEntity<DTOKuponParameter> getKuponParameter(@RequestBody @Valid AutocationRequest<Long> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.getKuponParameter());
    }

    @PutMapping("/kuponParameter")
    public ResponseEntity<DTOKuponParameter> updateKuponParameter(@RequestBody @Valid AutocationRequest<DTOKuponParameterIU> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.updateKuponParameter(request.getRequest()));
    }

    @PostMapping("/kuponParameter")
    public ResponseEntity<DTOKuponParameter> createKuponParameter(@RequestBody @Valid AutocationRequest<DTOKuponParameterIU> request){
        autocaticationService.kullaniciDogrulama(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(yoneticiService.createKuponParameter(request.getRequest()));
    }

    @PostMapping("/login")
    public ResponseEntity<CreateUserResponse<Long>> logIn(@RequestBody @Valid CreateUserRequst<Long> request){
        CreateUserResponse<Long> response = new CreateUserResponse<>(autocaticationService.logIn(request.getUser(),Yetki.YONETICI) ,null);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logOut(@RequestBody @Valid AutocationRequest<Long> request){
        boolean response = autocaticationService.logOut(request.getToken(), Yetki.YONETICI);
        return ResponseEntity.ok(response);
    }
}
