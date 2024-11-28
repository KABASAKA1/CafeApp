package com.sunrise.monetcafeapplicationapi.dto.mapper;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOKuponParameterIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOHavuz;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOKuponParameter;
import com.sunrise.monetcafeapplicationapi.model.Havuz;
import com.sunrise.monetcafeapplicationapi.model.KuponParameter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HavuzMapper {
    DTOHavuz havuzToDTO(Havuz havuz);
    DTOKuponParameter kuponParameterToDTO(KuponParameter kuponParameter);
    void updateKuponParameterFromDTO(DTOKuponParameterIU dtoKuponParameter , @MappingTarget KuponParameter kuponParameter);
}
