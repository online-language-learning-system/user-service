package com.hub.user_service.controller;

import com.hub.user_service.dto.UserPostDto;
import com.hub.user_service.service.UserService;
import com.hub.user_service.viewmodel.UserVm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/storefront/user/profile")
    public ResponseEntity<UserVm> getUserProfile() {
        // (OIDC) - SecurityContextHolder.getContext().getAuthentication().getName()
        // return the username of the current user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(userService.getUserProfile(username));
    }

    @GetMapping("/backoffice/users/{userId}")
    public ResponseEntity<UserVm> getUserByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserByUserId(userId));
    }

    @PostMapping("/backoffice/users")
    public ResponseEntity<UserVm> createUser(@RequestBody @Valid UserPostDto userPostDto,
                                             UriComponentsBuilder uriComponentsBuilder) {
        UserVm userVm = userService.createNewUser(userPostDto);
        URI uri = uriComponentsBuilder.replacePath("/users/{id}").buildAndExpand(userVm.id()).toUri();
        return ResponseEntity.created(uri).body(userVm);
    }

}
