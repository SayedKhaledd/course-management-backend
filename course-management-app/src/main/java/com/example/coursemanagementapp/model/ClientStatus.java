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
@Table(name = "client_status")
public class ClientStatus extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_status_id_sequence")
    @SequenceGenerator(name = "client_status_id_sequence", sequenceName = "client_status_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private com.example.coursemanagementapp.enums.ClientStatus status;

}
