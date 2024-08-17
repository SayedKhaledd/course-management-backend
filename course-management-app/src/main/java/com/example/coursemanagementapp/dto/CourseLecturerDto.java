package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourseLecturerDto extends AbstractDto {
    private Long id;
    private String name;
    private CourseDto course;
    private Long courseId;
    private Boolean paidInPercentage = false;
    private Double percentage;
    private Double fixedValue;
}
