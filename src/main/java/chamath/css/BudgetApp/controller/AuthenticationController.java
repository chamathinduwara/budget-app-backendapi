package chamath.css.BudgetApp.controller;

import chamath.css.BudgetApp.dto.AuthenticationRequest;
import chamath.css.BudgetApp.dto.AuthenticationResponse;
import chamath.css.BudgetApp.dto.RegisterRequest;
import chamath.css.BudgetApp.dto.RegisterResponse;
import chamath.css.BudgetApp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register (
            @RequestBody RegisterRequest registerRequest
    ){
        System.out.println(registerRequest);
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest authenticationRequest
            ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
