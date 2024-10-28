package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "history")
public class History extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_id_sequence")
    @SequenceGenerator(name = "history_id_sequence", sequenceName = "history_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "entity_id", updatable = false)
    private Long entityId;

    @Column(name = "entity_type", nullable = false)
    private String entityType;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

}
