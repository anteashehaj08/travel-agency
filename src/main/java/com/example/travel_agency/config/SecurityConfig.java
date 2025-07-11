package com.example.travel_agency.config;

import com.example.travel_agency.entities.Role;
import com.example.travel_agency.repositories.RoleRepository;
import com.example.travel_agency.security.UserDetailsServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostConstruct
    public void addRoles() {
        if (!roleRepository.existsById("ROLE_ADMIN")) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }
        if (!roleRepository.existsById("ROLE_USER")) {
            roleRepository.save(new Role("ROLE_USER"));
        }
    }

      @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( request->
                request.requestMatchers("tours", "tours/search","tours/search/",
                                "tours/search/city","tours/search/continent",
                                "tours/search/country","tours/filter","tours/details/",
                                "tours/search/hotel","purchases","purchases/","purchases/new",
                                "purchases/update/","airports/find/","airports/list",
                                "cities/find/", "countries/find/","user/register").permitAll()
                        .requestMatchers("tours/new","tours/","tours/edit/{id}", "tours/update","countries/update",
                                "countries/","cities/","cities/create","user/dashboard").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .authenticationManager(authenticationManager(http))
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return builder.build();
    }


}
