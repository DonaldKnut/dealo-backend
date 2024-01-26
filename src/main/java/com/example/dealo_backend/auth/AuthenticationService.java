package com.example.dealo_backend.auth;

import com.example.dealo_backend.config.JwtService;
import com.example.dealo_backend.enums.UserRole;
import com.example.dealo_backend.model.User;
import com.example.dealo_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
          var user = User.builder()
                  .username(request.getEmail())
                  .firstname(request.getFirstname())
                  .lastname(request.getLastname())
                  .email(request.getEmail())
                  .password(passwordEncoder.encode(request.getPassword()))
                  .role(UserRole.BUYER)
                  .build();
          userRepository.save(user);
          var jwtToken = jwtService.generateToken(user);
          System.out.println("Generated JWT Token: " + jwtToken);
          return AuthenticationResponse.builder()
                  .token(jwtToken)
                  .message("User registered successfully")
                  .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            var user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("User logged in successfully")
                    .build();
        } catch (AuthenticationException e) {
            // Log the exception or handle it appropriately
            System.out.println("Authentication failed: " + e.getMessage());
            return AuthenticationResponse.builder()
                    .message("Authentication failed: " + e.getMessage())
                    .build();
        }
    }


}
