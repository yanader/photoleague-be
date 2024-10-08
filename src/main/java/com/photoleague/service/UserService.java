package com.photoleague.service;

import com.photoleague.model.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Optional;

public interface UserService {
    User processOAuthPostLogin(OAuth2User principal);
    String extractOAuth2Platform();
    User setUpNewUser(OAuth2User principal, String platform);
    User processGoogleOAuthLogin(OAuth2User principal, String oAuth2Platform);
    User processGithubOAuthLogin(OAuth2User principal, String oAuth2Platform);
    boolean userExists(OAuth2User principal);
    Optional<User> getUser(OAuth2User principal);
}
