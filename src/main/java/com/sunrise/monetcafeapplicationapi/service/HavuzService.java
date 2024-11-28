package com.sunrise.monetcafeapplicationapi.service;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOKuponParameterIU;
import com.sunrise.monetcafeapplicationapi.dto.mapper.HavuzMapper;
import com.sunrise.monetcafeapplicationapi.dto.outward.*;
import com.sunrise.monetcafeapplicationapi.exception.ResourceNotFoundException;
import com.sunrise.monetcafeapplicationapi.model.KuponParameter;
import com.sunrise.monetcafeapplicationapi.repository.HavuzRepository;
import com.sunrise.monetcafeapplicationapi.repository.KuponParameterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HavuzService {
    private final HavuzRepository havuzRepository;
    private final KuponParameterRepository kuponParameterRepository;
    private final HavuzMapper havuzMapper;

    protected DTOHavuz getAllHavuz() {
        return havuzRepository.findAll().stream().findFirst()
                .map(havuzMapper::havuzToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Havuz not found"));
    }
    protected List<DTOHavuzdakiKampanya> getHavuzdakiKampanyas() {
        return havuzRepository.findAll().stream().findFirst()
                .map(havuzMapper::havuzToDTO)
                .map(DTOHavuz::getHavuzdakiKampanyas)
                .orElseThrow(()-> new ResourceNotFoundException("Havuz not found"));

    }
    protected List<DTOHavuzdakiProduct> getHavuzdakiProducts() {
        return havuzRepository.findAll().stream().findFirst()
                .map(havuzMapper::havuzToDTO)
                .map(DTOHavuz::getHavuzdakiProducts)
                .orElseThrow(()-> new ResourceNotFoundException("Havuz not found"));
    }
    protected List<DTOHavuzdakiKuponProduct> getHavuzdakiKuponProducts() {
        return havuzRepository.findAll().stream().findFirst()
                .map(havuzMapper::havuzToDTO)
                .map(DTOHavuz::getHavuzdakiKuponProducts)
                .orElseThrow(()-> new ResourceNotFoundException("Havuz not found"));
    }



    protected DTOKuponParameter getKuponParameter() {
        return kuponParameterRepository.findAll().stream().findFirst()
                .map(havuzMapper::kuponParameterToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Kupon parameter not found"));
    }
    protected DTOKuponParameter updateKuponParameter(DTOKuponParameterIU request) {
        return kuponParameterRepository.findAll().stream().findFirst()
                .map(kuponParameter -> {
                    havuzMapper.updateKuponParameterFromDTO(request, kuponParameter);
                    return kuponParameter;
                })
                .map(havuzMapper::kuponParameterToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Kupon parameter not found"));
    }
    protected DTOKuponParameter createKuponParameter(DTOKuponParameterIU request) {
        Optional<KuponParameter> kuponParameter = kuponParameterRepository.findAll().stream().findFirst();
        if (kuponParameter.isPresent()) {
            throw new IllegalStateException("Kupon parameter already exists");
        }
        KuponParameter kuponParameter1 = new KuponParameter();
        havuzMapper.updateKuponParameterFromDTO(request,kuponParameter1);
        return havuzMapper.kuponParameterToDTO(kuponParameterRepository.save(kuponParameter1));
    }

}
