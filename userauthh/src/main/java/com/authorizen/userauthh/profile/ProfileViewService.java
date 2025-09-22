package com.authorizen.userauthh.profile;


import org.springframework.stereotype.Service;

import com.authorizen.userauthh.dto.UserProfileRequest;
import com.authorizen.userauthh.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
import com.authorizen.userauthh.model.User;


@Service
@RequiredArgsConstructor
public class ProfileViewService {

    private final UserRepository userRepository;

    public UserProfileRequest getProfileViewDetails(Integer userId) {
        //Optional<User> userOptional = userRepository.findById(userId);
        return userRepository.findById(userId)
          .map(user -> UserProfileRequest.builder()
                .firstname(user.getFirstname())
                //.imageUrl(user.getImageUrl())
                .build())
                .orElseThrow(() -> new RuntimeException("User not found with ID " + userId));
        }
    }