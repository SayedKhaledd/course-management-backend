package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true, builderMethodName = "CourseLecturerHistoryDtoBuilder")

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseLecturerHistoryDto extends AbstractDto {
    private Long id;
    private CourseLecturerDto courseLecturer;
    private Long courseLecturerId;
    private String fieldName;
    private String oldValue;
    private String newValue;
}
