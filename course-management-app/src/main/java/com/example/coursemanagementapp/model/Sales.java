package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import com.example.coursemanagementapp.enums.PaymentStatusSource;
import com.example.coursemanagementapp.enums.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;


@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sales_view")
@IdClass(SalesId.class)
public class Sales extends AbstractEntity {
    @Id
    @Column(name = "entity_id")
    private Long entityId;

    @Id
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @JoinColumn(name = "client_id")
    @ManyToOne
    private Client client;

    @Column(name = "client_id", insertable = false, updatable = false)
    private Long clientId;

    @JoinColumn(name = "course_id")
    @ManyToOne
    private Course course;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Long courseId;

    @Column(name = "amount")
    private Double amount;

    @JoinColumn(name = "payment_method_id")
    @ManyToOne
    private PaymentMethod paymentMethod;

    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Long paymentMethodId;

    @Column(name = "payment_status_id")
    private Long paymentStatusId;

    @Column(name = "payment_status_source")
    @Enumerated(EnumType.STRING)
    private PaymentStatusSource paymentStatusSource;

    @Column(name = "currency")
    private String currency;

    @Column(name = "is_received")
    private Boolean isReceived;
}
