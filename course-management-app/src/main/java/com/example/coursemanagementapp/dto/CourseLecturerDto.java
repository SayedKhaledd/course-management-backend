package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "CourseLecturerDtoBuilder")
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
