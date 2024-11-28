package com.sunrise.monetcafeapplicationapi.dto.autocationDTO;

import com.sunrise.monetcafeapplicationapi.dto.inward.DTOUserIU;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequst<DTOIU> {
    private DTOIU request;
    private DTOUserIU user;
}
