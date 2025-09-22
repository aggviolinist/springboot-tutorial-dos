package com.authorizen.userauthh.profile;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorizen.userauthh.dto.UserProfileRequest;
import com.authorizen.userauthh.model.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/user")
@PreAuthorize("hasRole('USER')")
public class ProfileViewController {
    
    private final ProfileViewService profileViewService; // Inject the service here
    // Endpoint for viewing a car (viewing task)
    @GetMapping("/view/profile")
    public ResponseEntity<UserProfileRequest> getUserCarDetails(){
             
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Integer userId = currentUser.getId();
        UserProfileRequest response = profileViewService.getProfileViewDetails(userId);
        return ResponseEntity.ok(response);
    }
    
}
