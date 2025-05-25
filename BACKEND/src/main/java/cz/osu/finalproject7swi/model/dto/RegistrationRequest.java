package cz.osu.finalproject7swi.model.dto;

import cz.osu.finalproject7swi.model.entity.Address;
import lombok.Getter;

@Getter
public class RegistrationRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;
}
