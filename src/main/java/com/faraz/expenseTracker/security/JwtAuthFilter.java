package com.faraz.expenseTracker.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import com.faraz.expenseTracker.security.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;

    public JwtAuthFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
        System.out.println("🔥 JwtAuthFilter CREATED");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("======== FILTER START ========");
        System.out.println("URI: " + request.getRequestURI());
        // 🔥 skip auth endpoints
        String uri = request.getRequestURI();

        if (uri.startsWith("/api/auth/")) {
            System.out.println("Skipping auth endpoint: " + uri);
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("PROCESSING JWT FOR: " + uri);
        String header = request.getHeader("Authorization");
        System.out.println("HEADER: " + header);
        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);

            if (jwtUtils.validateToken(token)) {

                String email = jwtUtils.extractEmailFromToken(token);
                String role = jwtUtils.getRoleFromToken(token);
                System.out.println("TOKEN VALID");
                System.out.println("EMAIL: " + email);
                System.out.println("ROLE: " + role);

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        email,
                        null,
                        List.of(new SimpleGrantedAuthority(role)));
                System.out.println("ROLE FROM TOKEN: " + role);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
        System.out.println("======== FILTER END ========");

    }
}