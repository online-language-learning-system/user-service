package com.hub.user_service.dto;

public record UserProfileUpdateDto (
        String firstName, String lastName, String email
) { }
