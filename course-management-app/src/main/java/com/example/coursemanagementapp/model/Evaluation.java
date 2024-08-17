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
@Table(name = "evaluation")
public class Evaluation extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_id_sequence")
    @SequenceGenerator(name = "evaluation_id_sequence", sequenceName = "evaluation_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "enrollment_id", nullable = false, updatable = false)
    @ManyToOne
    private Enrollment enrollment;

    @Column(name = "enrollment_id", insertable = false, updatable = false)
    private Long enrollmentId;

    @Column(name = "exam_name")
    private String examName;

    @JoinColumn(name = "status_id")
    @ManyToOne
    private EvaluationStatus status;

    @Column(name = "status_id", insertable = false, updatable = false)
    private Long statusId;
}
