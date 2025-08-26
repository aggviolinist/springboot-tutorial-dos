package com.authorizen.userauthh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
    private String carname;
    private Integer carprice;
    private Integer timeline;
    private MultipartFile imageFile;
}