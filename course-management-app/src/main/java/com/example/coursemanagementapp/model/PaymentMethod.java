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
@Table(name = "payment_method")
public class PaymentMethod extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_method_id_sequence")
    @SequenceGenerator(name = "payment_method_id_sequence", sequenceName = "payment_method_id_sequence", allocationSize = 1)
    private Long id;

}
