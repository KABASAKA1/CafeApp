package com.sunrise.monetcafeapplicationapi.dto.mapper;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOCustomerIU;
import com.sunrise.monetcafeapplicationapi.dto.outward.DTOCustomer;
import com.sunrise.monetcafeapplicationapi.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {
    DTOCustomer customerToDTO(Customer customer);
    Customer customerToENTITY(DTOCustomerIU dtoCustomer);
    void updateCustomerFromDTO(DTOCustomerIU dtoCustomer , @MappingTarget Customer customer);
}
