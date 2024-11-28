package com.sunrise.monetcafeapplicationapi.service;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOBildirimIU;
import com.sunrise.monetcafeapplicationapi.dto.mapper.BildirimGecmisiMapper;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOBildirimGecmisi;
import com.sunrise.monetcafeapplicationapi.exception.ResourceNotFoundException;
import com.sunrise.monetcafeapplicationapi.model.Bildirim;
import com.sunrise.monetcafeapplicationapi.model.BildirimGecmisi;
import com.sunrise.monetcafeapplicationapi.repository.BildirimGecmisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BildirimGecmisiService {
    private final BildirimGecmisiRepository bildirimGecmisiRepository;
    private final BildirimGecmisiMapper bildirimGecmisiMapper;

    protected DTOBildirimGecmisi createBildirim(DTOBildirimIU request){
        return bildirimGecmisiRepository.findAll()
                .stream().findFirst()
                .map(bildirimGecmisi -> {
                    List<Bildirim> bildirimler = bildirimGecmisi.getBildirimler();
                    Bildirim bildirim = bildirimGecmisiMapper.bildirimToEntity(request);
                    bildirimler.add(bildirim);
                    return bildirimGecmisiMapper.bildirimGecmisiToDTO(bildirimGecmisiRepository.save(bildirimGecmisi));
                })
                .orElseGet(() -> {
                    BildirimGecmisi bildirimGecmisi = new BildirimGecmisi();
                    bildirimGecmisi.getBildirimler().add(bildirimGecmisiMapper.bildirimToEntity(request));
                    return bildirimGecmisiMapper.bildirimGecmisiToDTO(bildirimGecmisiRepository.save(bildirimGecmisi));
                });
    }

    protected DTOBildirimGecmisi getBildirimGecmisi(){
        return bildirimGecmisiRepository.findAll()
                .stream().findFirst()
                .map(bildirimGecmisiMapper::bildirimGecmisiToDTO)
                .orElseThrow(()-> new ResourceNotFoundException("There are no any bildirim to view !!"));
    }

    protected DTOBildirimGecmisi updateBildirim(Long id , DTOBildirimIU request){
        return bildirimGecmisiRepository.findAll()
                .stream().findFirst()
                .map(bildirimGecmisi -> {
                    bildirimGecmisi.getBildirimler().stream()
                            .filter(bildirim -> bildirim.getId().equals(id))
                            .findFirst()
                            .map(bildirim -> {bildirimGecmisiMapper.updateBildirimFromDTO(request , bildirim);
                                return bildirimGecmisiRepository.save(bildirimGecmisi);
                            })
                            .orElseThrow(()-> new ResourceNotFoundException("Bildirim not found for this id ::"+id));
                    return bildirimGecmisiMapper.bildirimGecmisiToDTO(bildirimGecmisi);
                })
                .orElseThrow(()-> new ResourceNotFoundException("There are no any bildirim to update"));
    }

    protected DTOBildirimGecmisi deleteBildirim(Long id){
        return bildirimGecmisiRepository.findAll()
                .stream().findFirst()
                .map(bildirimGecmisi -> {
                    bildirimGecmisi.getBildirimler().stream().filter(bildirim -> bildirim.getId().equals(id))
                            .findFirst().map(bildirim -> bildirimGecmisi.getBildirimler().remove(bildirim))
                            .orElseThrow(()-> new ResourceNotFoundException("Bildirim not found for this id ::"+id));
                    return bildirimGecmisiMapper.bildirimGecmisiToDTO(bildirimGecmisiRepository.save(bildirimGecmisi));
                })
                .orElseThrow(()-> new ResourceNotFoundException("There are no any bildirim to delete"));
    }

}
