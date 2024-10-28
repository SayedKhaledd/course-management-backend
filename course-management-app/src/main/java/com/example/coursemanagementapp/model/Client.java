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
@Table(name = "client")
@EntityListeners(GenericEntityListener.class)
public class Client extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_sequence")
    @SequenceGenerator(name = "client_id_sequence", sequenceName = "client_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phone;

    @Column(name = "alternative_phone_number")
    private String alternativePhone;

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

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Enrollment> enrollments;


}
