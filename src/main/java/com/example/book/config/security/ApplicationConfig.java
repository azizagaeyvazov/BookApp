package com.example.book.config.security;

import com.example.book.entites.Admin;
import com.example.book.entites.Author;
import com.example.book.entites.Reader;
import com.example.book.repositories.AdminRepository;
import com.example.book.repositories.AuthorRepository;
import com.example.book.repositories.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AuthorRepository authorRepository;

    private final ReaderRepository readerRepository;

    private final AdminRepository adminRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Optional<Author> author = authorRepository.findByUsername(username);
            if (author.isPresent()) {
                return author.get();
            }

            Optional<Reader> reader = readerRepository.findByUsername(username);
            if (reader.isPresent()) {
                return reader.get();
            }

            Optional<Admin> admin = adminRepository.findByUsername(username);
            if (admin.isPresent()) {
                return admin.get();
            }

            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
