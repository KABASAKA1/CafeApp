package com.sunrise.monetcafeapplicationapi.dto.mapper;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOBildirimIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOBildirimGecmisi;
import com.sunrise.monetcafeapplicationapi.model.Bildirim;
import com.sunrise.monetcafeapplicationapi.model.BildirimGecmisi;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BildirimGecmisiMapper {
    DTOBildirimGecmisi bildirimGecmisiToDTO(BildirimGecmisi bildirimGecmisi);
    Bildirim bildirimToEntity(DTOBildirimIU dtoBildirim);
    void updateBildirimFromDTO(DTOBildirimIU dtoBildirim , @MappingTarget Bildirim bildirim);
}
