package com.sunrise.monetcafeapplicationapi.dto.autocationDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutocationRequest<DTOIU> {
    private String token;
    private DTOIU request;
}