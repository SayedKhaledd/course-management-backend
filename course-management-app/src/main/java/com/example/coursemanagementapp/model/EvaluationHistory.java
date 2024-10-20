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
@Table(name = "evaluation_history")
public class EvaluationHistory extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_history_id_sequence")
    @SequenceGenerator(name = "evaluation_history_id_sequence", sequenceName = "evaluation_history_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "evaluation_id", updatable = false)
    @ManyToOne
    private Evaluation evaluation;

    @Column(name = "evaluation_id", insertable = false, updatable = false)
    private Long evaluationId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;
}
