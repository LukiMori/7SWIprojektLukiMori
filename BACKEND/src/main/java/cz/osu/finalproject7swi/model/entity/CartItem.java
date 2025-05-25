package cz.osu.finalproject7swi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private AppUser user;
    @Column(nullable = false)
    private int quantity;

}
