package com.example.travel_agency.config;

import com.example.travel_agency.entities.Continent;
import com.example.travel_agency.entities.Role;
import com.example.travel_agency.repositories.ContinentRepository;
import com.example.travel_agency.repositories.RoleRepository;
import com.example.travel_agency.security.UserDetailsServiceImpl;
import com.example.travel_agency.statics.ContinentEnum;
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

import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ContinentRepository continentRepository;

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
    @PostConstruct
    public void addContinents() {
        Arrays.stream(ContinentEnum.values()).forEach(enumVal -> {
            if (!continentRepository.existsByName(enumVal)) {
                Continent continent = new Continent();
                continent.setName(enumVal);
                continentRepository.save(continent);
            }
        });
    }
  @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( request->
                request.requestMatchers("/tour/all", "user/register").permitAll()
                        .requestMatchers("/tour/create","/city/create","country/create",
                                "/airports/create", "/hotel/create", "/tour/update").hasRole("ADMIN")
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
