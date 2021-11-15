package com.incentro.myservice.oauth.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class TokenChangePasswordRequest {

    @NotBlank(message = "{oauth.token.empty}")
    private String token;
    @NotBlank(message = "{oauth.password.empty}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{P}\\p{S}]).{8,}", message = "{oauth.password.strength}")
    private String password;
}
