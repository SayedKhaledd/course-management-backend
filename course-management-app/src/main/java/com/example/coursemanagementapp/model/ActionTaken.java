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
@Table(name = "action_taken")
public class ActionTaken extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_taken_id_sequence")
    @SequenceGenerator(name = "action_taken_id_sequence", sequenceName = "action_taken_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "action")
    @Enumerated(EnumType.STRING)
    private com.example.coursemanagementapp.enums.ActionTaken action;
}
