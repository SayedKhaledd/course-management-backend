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
@Table(name = "course_status")
public class CourseStatus extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_status_id_sequence")
    @SequenceGenerator(name = "course_status_id_sequence", sequenceName = "course_status_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "status")
    @Convert(converter = CourseStatusConverter.class)
    private com.example.coursemanagementapp.enums.CourseStatus status;

    public static class CourseStatusConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.CourseStatus> {
        public CourseStatusConverter() {
            super(com.example.coursemanagementapp.enums.CourseStatus.class);
        }
    }

}
