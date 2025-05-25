package cz.osu.finalproject7swi.controller;

import cz.osu.finalproject7swi.model.dto.RegistrationRequest;
import cz.osu.finalproject7swi.model.dto.LoginRequest;
import cz.osu.finalproject7swi.model.dto.UserToken;
import cz.osu.finalproject7swi.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/register", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody RegistrationRequest registrationDTO) {
        System.out.println("Here");
        String ret = authService.register(registrationDTO.getEmail(), registrationDTO.getPassword(),
                registrationDTO.getFirstName(), registrationDTO.getLastName(), registrationDTO.getPhoneNumber(),
                registrationDTO.getAddress());

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginDTO) {
        try {
            UserToken userToken = authService.login(loginDTO.getEmail(), loginDTO.getPassword());
            return new ResponseEntity<>(userToken, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
