package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import com.example.coursemanagementapp.config.GenericEntityListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "enrollment")
@EntityListeners(GenericEntityListener.class)
public class Enrollment extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enrollment_id_sequence")
    @SequenceGenerator(name = "enrollment_id_sequence", sequenceName = "enrollment_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "course_id", updatable = false)
    @ManyToOne
    private Course course;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Long courseId;


    @JoinColumn(name = "client_id", updatable = false)
    @ManyToOne
    private Client client;

    @Column(name = "client_id", insertable = false, updatable = false)
    private Long clientId;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "remaining_amount")
    private Double remainingAmount;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "discount")
    private Double discount;

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

    @Column(name = "pay_in_installment")
    private Boolean payInInstallments = false;

    @Column(name = "review")
    private String review;

    @Column(name = "rate")
    private Integer rating;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "action_taken_id")
    @ManyToOne
    private ActionTaken actionTaken;

    @Column(name = "action_taken_id", insertable = false, updatable = false)
    private Long actionTakenId;

    @JoinColumn(name = "referral_source_id")
    @ManyToOne
    private ReferralSource referralSource;

    @Column(name = "referral_source_id", insertable = false, updatable = false)
    private Long referralSourceId;

    @Column(name = "inside_Egypt")
    private Boolean insideEgypt = true;

    @Column(name = "is_received")
    private Boolean isReceived = false;


    @OneToMany(mappedBy = "enrollment", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Installment> installments;

    @OneToMany(mappedBy = "enrollment", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Refund> refunds;

}
