package com.hub.user_service.viewmodel;

import org.keycloak.representations.idm.UserRepresentation;

public record UserVm(
        String id,

        String username,

        String email,

        String firstName,

        String lastName
) {
    public static UserVm fromUserRepresentation(UserRepresentation userRepresentation) {
        return new UserVm(userRepresentation.getId(), userRepresentation.getUsername(),
                userRepresentation.getEmail(),
                userRepresentation.getFirstName(), userRepresentation.getLastName()
        );
    }
}
