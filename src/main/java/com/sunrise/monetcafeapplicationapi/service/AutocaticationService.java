package com.sunrise.monetcafeapplicationapi.service;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOUserIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOUser;
import com.sunrise.monetcafeapplicationapi.enums.Yetki;
import com.sunrise.monetcafeapplicationapi.exception.ResourceNotFoundException;
import com.sunrise.monetcafeapplicationapi.model.User;
import com.sunrise.monetcafeapplicationapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutocaticationService {
    private final UserRepository userRepository;

    public String logIn(DTOUserIU userIU , Yetki yetki)  {
        User user = userRepository.findByPhoneNumber(userIU.getPhoneNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Kullanıcı bulunamamıştır !!"));
        if (!user.getPassword().equals(userIU.getPassword())) {
            throw new ResourceNotFoundException("Kullanıcı şifreniz yanlıştır");
        }else {
            if (user.getYetki().equals(yetki)) {
                if (user.getToken().isEmpty()){
                    user.setToken(generateToken());
                    user = userRepository.save(user);
                }
                return user.getToken();
            }else{
                throw new ResourceNotFoundException("Yetki eşleşmedi !!");
            }

        }
    }

    public boolean logOut(String token , Yetki yetki)  {
        User user = userRepository.findByToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("Kullanıcı bulunamamıştır !!"));
        if (!user.getToken().equals(token)) {
            throw new ResourceNotFoundException("Yetki eşleşmedi !!");
        }
        user.setToken("");
        user = userRepository.save(user);
        return true;
    }

    public String createUser(DTOUserIU userIU , Yetki yetki) {
        User user = userRepository.findByPhoneNumber(userIU.getPhoneNumber())
                .orElse(null);
        if (user!=null){
            throw new ResourceNotFoundException("Bu telefon numarasına ait kullanıcı bulunmaktadır !!");
        }
        user = new User();
        user.setPhoneNumber(userIU.getPhoneNumber());
        user.setPassword(userIU.getPassword());
        user.setToken(generateToken());
        user.setYetki(yetki);
        user = userRepository.save(user);

        return user.getToken();
    }

    public String kullaniciDogrulama(String token , Yetki yetki) {
        return userRepository.findByToken(token)
                .map(user1 -> {
                    if (user1.getYetki().equals(yetki)) {
                        throw new ResourceNotFoundException("kullanıcı yetkisi doğulanamadı !!");
                    }
                    return user1.getPhoneNumber();})
                .orElseThrow(() -> new ResourceNotFoundException("Böyle bir kullanıcı bulunmamaktadır !!!"));
    }





    private String generateToken() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 20).toUpperCase();
    }
}
