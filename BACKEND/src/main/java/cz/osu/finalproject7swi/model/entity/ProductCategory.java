package cz.osu.finalproject7swi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(name = "category_sequence", sequenceName = "CATEGORY_SEQ", allocationSize = 1)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AttributeDefinition> specifications;
}
