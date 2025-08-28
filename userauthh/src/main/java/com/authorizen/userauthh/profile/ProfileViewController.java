package com.authorizen.userauthh.profile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorizen.userauthh.dto.UserProfileRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/user")
public class ProfileViewController {
    
    private final ProfileViewService profileViewService; // Inject the service here
    // Endpoint for viewing a car (viewing task)
    @GetMapping("/view/profile/{userId}/profile/{profileId}")
    public ResponseEntity<UserProfileRequest> getUserCarDetails(
            @PathVariable Integer userId,
            @PathVariable Integer profileId) {
        UserProfileRequest response = profileViewService.getProfileViewDetails(userId, profileId);
        return ResponseEntity.ok(response);
    }
    
}
