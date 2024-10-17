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
@Table(name = "enrollment_history")
public class EnrollmentHistory extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enrollment_history_id_sequence")
    @SequenceGenerator(name = "enrollment_history_id_sequence", sequenceName = "enrollment_history_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "enrollment_id", updatable = false)
    @ManyToOne
    private Enrollment enrollment;

    @Column(name = "enrollment_id", insertable = false, updatable = false)
    private Long enrollmentId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;


}
