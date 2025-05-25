package cz.osu.finalproject7swi.model.entity;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;
    @Column(nullable = false)
    private String addressLabel;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private int houseNumber;
    @Column(nullable = false)
    private int zipCode;
}
