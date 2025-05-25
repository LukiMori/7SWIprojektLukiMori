package cz.osu.finalproject7swi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phoneNumber;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Address> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<OrderInformation> orderInformation  = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List<CartItem> cartItems = new ArrayList<>();
}
