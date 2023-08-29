package chamath.css.BudgetApp.service;

import chamath.css.BudgetApp.dto.AuthenticationRequest;
import chamath.css.BudgetApp.dto.AuthenticationResponse;
import chamath.css.BudgetApp.dto.RegisterRequest;
import chamath.css.BudgetApp.dto.RegisterResponse;
import chamath.css.BudgetApp.model.Role;
import chamath.css.BudgetApp.model.User;
import chamath.css.BudgetApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public RegisterResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .firstname(registerRequest.getFirstName())
                .lastname(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return RegisterResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate (AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
