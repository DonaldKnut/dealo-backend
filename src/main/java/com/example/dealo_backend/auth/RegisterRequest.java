package com.example.dealo_backend.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String username;
    private String firstname;
    private String lastname;
    private String email;

    private String password;

    @Bean
    public int age(){
        return  15;
    }

}
