package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "installment")
public class Installment extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "installment_id_sequence")
    @SequenceGenerator(name = "installment_id_sequence", sequenceName = "installment_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "enrollment_id", updatable = false, nullable = false)
    @ManyToOne
    private Enrollment enrollment;

    @Column(name = "enrollment_id", nullable = false, insertable = false, updatable = false)
    private Long enrollmentId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "payment_due_date", nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @JoinColumn(name = "payment_status_id")
    @ManyToOne
    private PaymentStatus paymentStatus;

    @Column(name = "payment_status_id", insertable = false, updatable = false)
    private Long paymentStatusId;

    @JoinColumn(name = "payment_method_id")
    @ManyToOne
    private PaymentMethod paymentMethod;

    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Long paymentMethodId;


}
