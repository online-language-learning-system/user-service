package com.hub.user_service.model.dto;

import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;
import java.util.Map;

public record UserDetailGetDto(
        String id,

        String username,

        String email,

        String firstName,

        String lastName

) {
    public static UserDetailGetDto fromUserRepresentation(UserRepresentation userRepresentation) {
        return new UserDetailGetDto(userRepresentation.getId(), userRepresentation.getUsername(),
                userRepresentation.getEmail(),
                userRepresentation.getFirstName(), userRepresentation.getLastName()
        );
    }
}
