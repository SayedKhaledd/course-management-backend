package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import com.example.coursemanagementapp.config.GenericEntityListener;
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
@Table(name = "refund")
@EntityListeners(GenericEntityListener.class)
public class Refund extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refund_id_sequence")
    @SequenceGenerator(name = "refund_id_sequence", sequenceName = "refund_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "enrollment_id", updatable = false, nullable = false)
    @ManyToOne
    private Enrollment enrollment;

    @Column(name = "enrollment_id", nullable = false, insertable = false, updatable = false)
    private Long enrollmentId;

    @JoinColumn(name = "payment_method_id")
    @ManyToOne
    private PaymentMethod paymentMethod;

    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Long paymentMethodId;


    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "refund_date", nullable = false)
    private LocalDateTime refundDate;

    @Column(name = "explanation")
    private String explanation;

    @JoinColumn(name = "refund_reason_id")
    @ManyToOne
    private RefundReason refundReason;

    @Column(name = "refund_reason_id", insertable = false, updatable = false)
    private Long refundReasonId;

    @Column(name = "is_confirmed", nullable = false)
    private Boolean isConfirmed = false;

}
