package com.authorizen.userauthh.admin;

import com.authorizen.userauthh.dto.CarRequest;
import com.authorizen.userauthh.model.Admin;
import com.authorizen.userauthh.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final S3Service s3Service;
    private final AdminRepository adminRepository;

    public Admin addCar(CarRequest request) {
        // 1. Upload the image to S3 and get the URL
        String imageUrl = s3Service.uploadFile(request.getImageFile());

        // 2. Create the Admin object
        Admin newCar = Admin.builder()
                .carname(request.getCarname())
                .carprice(request.getCarprice())
                .timeline(request.getTimeline())
                .imageUrl(imageUrl)
                .build();

        // 3. Save the car to the database and return it
        return adminRepository.save(newCar);
    }
    // public Admin addCarWithoutImage(CarDetailsRequest request) {
    //     Admin newCar = Admin.builder()
    //             .carname(request.getCarname())
    //             .carprice(request.getCarprice())
    //             .timeline(request.getTimeline())
    //             .build(); // imageUrl is omitted

    //     return adminRepository.save(newCar);
    // }
}