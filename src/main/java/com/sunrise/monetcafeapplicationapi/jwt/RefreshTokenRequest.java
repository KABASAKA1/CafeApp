package com.sunrise.monetcafeapplicationapi.jwt;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenRequest {

	@NotEmpty
	private String refreshToken;
}
