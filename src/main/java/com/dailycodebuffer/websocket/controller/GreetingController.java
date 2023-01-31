package com.dailycodebuffer.websocket.controller;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
//@CrossOrigin
public class GreetingController {

//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greet(HelloMessage message, Principal principal) throws InterruptedException {
//        Thread.sleep(2000);
//        return new Greeting("Hello, " +
//                HtmlUtils.htmlEscape(message.getName()));
//    }

    @GetMapping("/user")
//    @RolesAllowed("user")
    public String user(){
        return "User";
    }

    @GetMapping("/admin")
//    @RolesAllowed("admin")
    public String admin(){
        return "Admin";
    }

    @GetMapping("/member")
    public String member(){
        return "Member";
    }

    @GetMapping("/userinfo")
//    @RolesAllowed("admin")
    public String userInfoController(Principal principal) {

        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
return accessToken.toString();
    }
}
