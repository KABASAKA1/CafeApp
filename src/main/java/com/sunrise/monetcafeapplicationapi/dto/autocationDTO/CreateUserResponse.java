package com.sunrise.monetcafeapplicationapi.dto.autocationDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse<DTO> {
    private String token;
    private DTO response;
}
