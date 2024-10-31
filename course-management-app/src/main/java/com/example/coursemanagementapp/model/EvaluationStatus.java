package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import com.example.coursemanagementapp.enums.GenericEnumConverter;
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
@Table(name = "evaluation_status")
public class EvaluationStatus extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_status_id_sequence")
    @SequenceGenerator(name = "evaluation_status_id_sequence", sequenceName = "evaluation_status_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "status")
    @Convert(converter = EvaluationStatusConverter.class)
    private com.example.coursemanagementapp.enums.EvaluationStatus status;

    public static class EvaluationStatusConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.EvaluationStatus> {
        public EvaluationStatusConverter() {
            super(com.example.coursemanagementapp.enums.EvaluationStatus.class);
        }
    }

}
