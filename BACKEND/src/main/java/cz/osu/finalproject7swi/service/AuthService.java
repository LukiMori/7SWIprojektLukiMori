package cz.osu.finalproject7swi.service;

import cz.osu.finalproject7swi.model.entity.AppUser;
import cz.osu.finalproject7swi.model.entity.Address;
import cz.osu.finalproject7swi.model.repository.AppUserRepository;
import cz.osu.finalproject7swi.model.dto.UserToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AppUserRepository userRepository;

    public AuthService(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(String email, String password, String firstName, String lastName, String phoneNumber, Address address) {
        String ret;
        if (userRepository.existsByEmailIgnoreCase(email)) {
            ret = "Email already in use.";
        } else {
            AppUser user = new AppUser();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phoneNumber);
            user.getAddresses().add(address);
            //Zde by bylo vhodné šifrování hesla
            user.setPassword(password);
            userRepository.save(user);
            ret = "User with email " + email + " registered";
        }

        return ret;
    }

    public UserToken login(String email, String password) {
        AppUser user = userRepository.findByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return new UserToken(user.getEmail());
            } else {
                throw new RuntimeException("Wrong password!");
            }
        } else {
            throw new IllegalArgumentException("User with this email does not exist!");
        }
    }

}
