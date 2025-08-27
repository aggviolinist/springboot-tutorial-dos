package com.authorizen.userauthh.profile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorizen.userauthh.dto.UserProfileResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/user")
public class ProfileViewController {

    // Endpoint for viewing a car (viewing task)
    @GetMapping("/view/user/{userId}/profile/{profile}")
    public ResponseEntity<UserProfileResponse> getUserCarDetails(
            @PathVariable Integer userId,
            @PathVariable Integer profileId) {
        UserProfileResponse response = ProfileViewService.getProfileViewDetails(userId, profileId);
        return ResponseEntity.ok(response);
    }
    
}
