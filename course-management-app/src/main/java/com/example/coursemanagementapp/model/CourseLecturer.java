package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import com.example.coursemanagementapp.config.GenericEntityListener;
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
@Table(name = "course_lecturer")
@EntityListeners(GenericEntityListener.class)
public class CourseLecturer extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_lecturer_id_sequence")
    @SequenceGenerator(name = "course_lecturer_id_sequence", sequenceName = "course_lecturer_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "course_id", nullable = false, updatable = false)
    @ManyToOne
    private Course course;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Long courseId;

    @Column(name = "paid_in_percentage")
    private Boolean paidInPercentage = false;

    @Column(name = "percentage")
    private Double percentage;

    @Column(name = "total_percentage_cost")
    private Double totalPercentageCost;

    @Column(name = "no_of_lectures")
    private Long noOfLectures;

    @Column(name = "lecture_cost")
    private Double lectureCost;

    @Column(name = "total_fixed_cost")
    private Double totalFixedCost;


}
