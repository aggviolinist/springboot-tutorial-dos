package com.authorizen.userauthh.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfileRequest  {
    private String firstname;
    private String imageUrl;
    
}
