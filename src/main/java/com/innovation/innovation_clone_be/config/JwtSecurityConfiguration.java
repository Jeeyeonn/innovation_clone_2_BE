package com.innovation.innovation_clone_be.config;

import com.innovation.innovation_clone_be.Member.Service.UserDetailsServiceImpl;
import com.innovation.innovation_clone_be.Member.jwt.JwtFilter;
import com.innovation.innovation_clone_be.Member.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtSecurityConfiguration
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final String SECRET_KEY;
    private final TokenProvider tokenProvider;
    private final UserDetailsServiceImpl userDetailsService;

    // TokenProvider를 주입받아서 직접 만든 JwtFilter를 통해 Security 로직에 필터를 등록
    @Override
    public void configure(HttpSecurity httpSecurity) {
        JwtFilter customJwtFilter = new JwtFilter(SECRET_KEY, tokenProvider, userDetailsService);
        httpSecurity.addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
