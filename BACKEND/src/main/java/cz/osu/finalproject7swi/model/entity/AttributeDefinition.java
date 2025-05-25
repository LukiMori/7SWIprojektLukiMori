package cz.osu.finalproject7swi.model.entity;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "attribute_definition")
public class AttributeDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attr_def_sequence")
    @SequenceGenerator(name = "attr_def_sequence", sequenceName = "ATTR_DEF_SEQ", allocationSize = 1)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String displayName;
    @Column(nullable = false)
    private String dataType;
    @Column
    private String unit;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
    @Column(nullable = false)
    private boolean filterable;
    @Column(nullable = false)
    private boolean required;
    @Column
    private Integer displayOrder;
}
