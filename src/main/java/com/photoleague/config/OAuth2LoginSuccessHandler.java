package com.photoleague.config;

import com.photoleague.jwt.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtils jwtUtils;

    public OAuth2LoginSuccessHandler(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String username = oAuth2User.getAttribute("login");  // Assuming 'login' is the username
        String provider = authentication.getAuthorities().toString();  // Use the authority to determine provider (e.g., GitHub, Google)

        // Generate the JWT
        String jwtToken = jwtUtils.generateTokenFromUsernameAndProvider(username, provider);

        // Optionally: Add the token to response headers or body (for client to use)
        response.addHeader("Authorization", "Bearer " + jwtToken);

        // Redirect or send the token response to the client
        response.sendRedirect("http://localhost:3000/dashboard?token=" + jwtToken);  // Send token as URL param if necessary
    }
}