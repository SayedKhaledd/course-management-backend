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
@Table(name = "installment_history")
public class InstallmentHistory extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "installment_history_id_sequence")
    @SequenceGenerator(name = "installment_history_id_sequence", sequenceName = "installment_history_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "installment_id", updatable = false)
    @ManyToOne
    private Installment installment;

    @Column(name = "installment_id", insertable = false, updatable = false)
    private Long installmentId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

}
