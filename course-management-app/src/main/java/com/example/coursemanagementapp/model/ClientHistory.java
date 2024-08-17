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
@Table(name = "client_history")
public class ClientHistory extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_history_id_sequence")
    @SequenceGenerator(name = "client_history_id_sequence", sequenceName = "client_history_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "client_id")
    @ManyToOne
    private Client client;

    @Column(name = "client_id", insertable = false, updatable = false)
    private Long clientId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phone;

    @Column(name = "alternative_phone_number")
    private String alternatePhone;

    @Column(name = "country")
    private String country;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "address")
    private String address;

    @JoinColumn(name = "status_id")
    @ManyToOne
    private ClientStatus clientStatus;

    @Column(name = "status_id", insertable = false, updatable = false)
    private Long clientStatusId;

    @Column(name = "specialty")
    private String specialty;

    @JoinColumn(name = "referral_source_id")
    @ManyToOne
    private ReferralSource referralSource;

    @Column(name = "referral_source_id", insertable = false, updatable = false)
    private Long referralSourceId;

    @Column(name = "description")
    private String description;

}
