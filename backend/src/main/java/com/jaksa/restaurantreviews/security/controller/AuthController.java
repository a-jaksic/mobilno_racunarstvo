package com.jaksa.restaurantreviews.security.controller;

import com.jaksa.restaurantreviews.security.dtos.MobileJwtResponse;
import com.jaksa.restaurantreviews.security.dtos.UserLoginDTO;
import com.jaksa.restaurantreviews.security.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {

        try {
            UserDetails userDetails = authService.authenticate(userLoginDTO.username(), userLoginDTO.password());

            HttpHeaders cookieHeaders = authService.createAuthHeaders(userDetails);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(cookieHeaders)
                    .body("User logged in successfully");

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error, login failed");
        }

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok()
                .headers(authService.createLogoutHeaders())
                .body("Logged out");
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(HttpServletRequest request) {
        try {

            // 1. Validate and generate new headers
            HttpHeaders newCookies = authService.refreshAccessToken(request);

            return ResponseEntity.ok().headers(newCookies).body("Token refreshed");
        } catch (Exception e) {
            // If refresh fails (expired or invalid), return 401 so frontend redirects to login
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session expired, please login again");
        }
    }

    @PostMapping("/mobile/login")
    public ResponseEntity<?> mobileLogin(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            UserDetails userDetails = authService.authenticate(userLoginDTO.username(), userLoginDTO.password());

            MobileJwtResponse tokens = authService.createMobileAuthTokens(userDetails);
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, mobile login failed");
        }
    }

    @PostMapping("/mobile/refresh")
    public ResponseEntity<?> mobileRefresh(@RequestHeader("Authorization") String bearerRefreshToken) {
        try {
            String rawRefreshToken = null;
            if (bearerRefreshToken != null && bearerRefreshToken.startsWith("Bearer ")) {
                rawRefreshToken = bearerRefreshToken.substring(7);
            }

            MobileJwtResponse tokens = authService.refreshMobileAccessToken(rawRefreshToken);
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session expired, please login again");
        }
    }
}
