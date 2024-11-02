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
@Table(name = "client_status")
public class ClientStatus extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_status_id_sequence")
    @SequenceGenerator(name = "client_status_id_sequence", sequenceName = "client_status_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "status")

    @Convert(converter = ClientStatusConverter .class)
    private com.example.coursemanagementapp.enums.ClientStatus status;

    public static class ClientStatusConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.ClientStatus> {
        public ClientStatusConverter() {
            super(com.example.coursemanagementapp.enums.ClientStatus.class);
        }
    }

}
