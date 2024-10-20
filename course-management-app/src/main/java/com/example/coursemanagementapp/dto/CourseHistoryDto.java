package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true, builderMethodName = "CourseHistoryDtoBuilder")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseHistoryDto extends AbstractDto {
    private Long id;
    private CourseDto course;
    private Long courseId;
    private String fieldName;
    private String oldValue;
    private String newValue;


}
