package com.example.deliverymatchs.Auth;


import com.example.deliverymatchs.Config.JwtService;
import com.example.deliverymatchs.Entitys.Admin;
import com.example.deliverymatchs.Entitys.Conducteur;
import com.example.deliverymatchs.Entitys.Expediteur;
import com.example.deliverymatchs.Entitys.Utilisateurs;
import com.example.deliverymatchs.Repositories.UtilisateurRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {
    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthentificationService(UtilisateurRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authentifactionManager, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthentificationResponse register(RegisterRequest request){
        Utilisateurs utilisateurs;

        switch (request.getRole()) {

            case ADMIN -> utilisateurs = new Utilisateurs();
            case CONDUCTEUR -> utilisateurs = new Conducteur();
            case EXPEDITEREUR -> utilisateurs = new Expediteur();

            default -> throw new IllegalArgumentException("Invalid role: " + request.getRole());
        }

        utilisateurs.setName(request.getNam());
        utilisateurs.setEmail(request.getEmail());
        utilisateurs.setPassword(passwordEncoder.encode(request.getPassword()));
        utilisateurs.setRole(request.getRole());

        repository.save(utilisateurs);
        String jwtToken = jwtService.generateToken(utilisateurs);

        AuthentificationResponse response = new AuthentificationResponse();
        response.setToken(jwtToken);
        return response;
    }

    public AuthentificationResponse authenticate(AuthentificationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Utilisateurs utilisateurs =repository.findByEmail(request.getEmail());
        String jwtToken = jwtService.generateToken(utilisateurs);

        AuthentificationResponse response =new AuthentificationResponse();
        response.setToken(jwtToken);
        return response;
    }
}
