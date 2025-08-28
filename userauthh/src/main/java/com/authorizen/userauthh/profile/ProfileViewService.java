package com.authorizen.userauthh.profile;

import org.springframework.stereotype.Service;

import com.authorizen.userauthh.dto.UserProfileRequest;
import com.authorizen.userauthh.model.Admin;
import com.authorizen.userauthh.model.User;
import com.authorizen.userauthh.repository.AdminRepository;
import com.authorizen.userauthh.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileViewService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    //import UserprofileResponse Dto

    public UserProfileRequest getProfileViewDetails(Integer userId, Integer profileId) {
        // Fetch user information
        Optional<User> user = userRepository.findById(userId);

        // Fetch car information from the 'catalogue' table (Admin entity)
        Optional<Admin> car = adminRepository.findById(profileId);

        // Check if both user and car records exist
        if (user.isPresent() && car.isPresent()) {
            // Build and return the DTO
            return UserProfileRequest.builder()
                    .firstname(user.get().getFirstname())
                    .imageUrl(car.get().getImageUrl())
                    .build();
        } else {
            // Handle cases where user or car is not found
            throw new RuntimeException("User or car not found");
        }
    }
    
}
