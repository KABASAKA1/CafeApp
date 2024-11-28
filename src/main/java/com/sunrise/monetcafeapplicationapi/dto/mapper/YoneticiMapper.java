package com.sunrise.monetcafeapplicationapi.dto.mapper;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOYoneticiIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOYonetici;
import com.sunrise.monetcafeapplicationapi.model.Yonetici;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface YoneticiMapper {
    DTOYonetici yoneticiToDTO(Yonetici yonetici);
    Yonetici yoneticiToENTITY(DTOYoneticiIU dtoYonetici);
    void updateYoneticiFromDTO(DTOYoneticiIU dtoYonetici , @MappingTarget Yonetici yonetici);
}
