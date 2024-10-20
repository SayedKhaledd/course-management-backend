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
@Table(name = "course_history")
public class CourseHistory extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_history_id_sequence")
    @SequenceGenerator(name = "course_history_id_sequence", sequenceName = "course_history_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "course_id", updatable = false)
    @ManyToOne
    private Course course;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Long courseId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;
}
