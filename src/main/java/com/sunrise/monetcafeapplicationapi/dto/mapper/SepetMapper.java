package com.sunrise.monetcafeapplicationapi.dto.mapper;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOSepetIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOSepettekiKampanyaIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOSepettekiKuponProductIU;
import com.sunrise.monetcafeapplicationapi.dto.inward.DTOSepettekiProductIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOSepet;
import com.sunrise.monetcafeapplicationapi.model.Sepet;
import com.sunrise.monetcafeapplicationapi.model.SepettekiKampanya;
import com.sunrise.monetcafeapplicationapi.model.SepettekiKuponProduct;
import com.sunrise.monetcafeapplicationapi.model.SepettekiProduct;
import org.mapstruct.*;

@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SepetMapper {
    DTOSepet sepetToDTO(Sepet sepet);

    void updateSepetFromDTO(DTOSepetIU dtoSepet , @MappingTarget Sepet sepet);

    @Mapping(source = "productId",target = "product.id")
    void updateSepettekiProductFromDTO(DTOSepettekiProductIU dtoSepettekiProduct , @MappingTarget SepettekiProduct sepettekiProduct);
    @Mapping(source = "kampanyaId",target = "kampanya.id")
    void updateSepettekiKampanyaFromDTO(DTOSepettekiKampanyaIU dtoSepettekiKampanya , @MappingTarget SepettekiKampanya sepettekiKampanya);
    @Mapping(source = "productId",target = "product.id")
    void updateSepettekiKuponProductFromDTO(DTOSepettekiKuponProductIU dtoSepettekiKuponProduct , @MappingTarget SepettekiKuponProduct sepettekiKuponProduct);

}
