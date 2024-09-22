package com.photoleague;

//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/health")
    public String health() {
        return "UP";
    }

//    @GetMapping
//    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principle) {
//        return principle.getAttributes();
//    }

}
