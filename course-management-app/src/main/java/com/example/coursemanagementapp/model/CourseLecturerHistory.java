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
@Table(name = "course_lecturer_history")
public class CourseLecturerHistory extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_lecturer_history_id_sequence")
    @SequenceGenerator(name = "course_lecturer_history_id_sequence", sequenceName = "course_lecturer_history_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "course_lecturer_id", updatable = false)
    @ManyToOne
    private CourseLecturer courseLecturer;

    @Column(name = "course_lecturer_id", insertable = false, updatable = false)
    private Long courseLecturerId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

}
