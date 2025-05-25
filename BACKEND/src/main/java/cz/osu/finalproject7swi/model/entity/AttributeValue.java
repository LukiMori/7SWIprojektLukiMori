package cz.osu.finalproject7swi.model.entity;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "attribute_value")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attr_val_sequence")
    @SequenceGenerator(name = "attr_val_sequence", sequenceName = "ATTR_VAL_SEQ", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    private AttributeDefinition attribute;
    @Column
    private String valueText;
    @Column
    private Double valueNumber;
    @Column
    private Boolean valueBoolean;
}
