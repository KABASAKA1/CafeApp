package com.sunrise.monetcafeapplicationapi.dto.mapper;

import com.sunrise.monetcafeapplicationapi.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {
    @Mappings({
            @Mapping(target = "id" , ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
    })
    HavuzdakiProduct itemsToOrderPlace (SepettekiProduct sepettekiProduct);

    @Mappings({
            @Mapping(target = "id" , ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
    })
    List<HavuzdakiProduct> listToOrderPlace(List<SepettekiProduct> productsInCart);

    @Mappings({
            @Mapping(target = "id" , ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
    })
    HavuzdakiKampanya itemsToUsingKampanya (SepettekiKampanya sepettekiKampanyas);

    @Mappings({
            @Mapping(target = "id" , ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
    })
    List<HavuzdakiKampanya> listToUsingKampanya(List<SepettekiKampanya> sepettekiKampanyas);

    @Mappings({
            @Mapping(target = "id" , ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
    })
    HavuzdakiKuponProduct itemsToUsingKupon (SepettekiKuponProduct sepettekiKuponProduct);

    @Mappings({
            @Mapping(target = "id" , ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
    })
    List<HavuzdakiKuponProduct> listToUsingKupon(List<SepettekiKuponProduct> sepettekiKuponProducts);
}
