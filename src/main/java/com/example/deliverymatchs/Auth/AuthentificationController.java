package com.example.deliverymatchs.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthentificationController {
    private final AuthentificationService service;

    public AuthentificationController(AuthentificationService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthentificationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authentification")
    public ResponseEntity<AuthentificationResponse> authentification(
            @RequestBody AuthentificationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
