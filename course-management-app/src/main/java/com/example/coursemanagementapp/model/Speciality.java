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
@Table(name = "speciality")
public class Speciality extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "speciality_id_sequence")
    @SequenceGenerator(name = "speciality_id_sequence", sequenceName = "speciality_id_sequence", allocationSize = 1)
    private Long id;

}
