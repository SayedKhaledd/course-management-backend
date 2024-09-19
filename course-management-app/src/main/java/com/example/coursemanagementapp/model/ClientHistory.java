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

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;


}
