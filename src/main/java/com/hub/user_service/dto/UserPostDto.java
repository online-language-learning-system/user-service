package com.hub.user_service.dto;

import jakarta.validation.constraints.NotBlank;

public record UserPostDto (

    @NotBlank
    String username,

    @NotBlank
    String password,

    @NotBlank
    String passwordConfirm,

    @NotBlank
    String email

) {

}
