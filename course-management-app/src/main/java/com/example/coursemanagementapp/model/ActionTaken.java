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
@Table(name = "action_taken")
public class ActionTaken extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_taken_id_sequence")
    @SequenceGenerator(name = "action_taken_id_sequence", sequenceName = "action_taken_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "action")
    @Convert(converter = ActionTakenConverter.class)
    private com.example.coursemanagementapp.enums.ActionTaken action;

    public static class ActionTakenConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.ActionTaken> {
        public ActionTakenConverter() {
            super(com.example.coursemanagementapp.enums.ActionTaken.class);
        }
    }
}
