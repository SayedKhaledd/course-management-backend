package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "CourseDtoBuilder")
@Data
public class CourseDto extends AbstractDto {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String description;
    @NotBlank(message = "Code is mandatory")
    private String code;
    @NotBlank(message = "Part is mandatory")
    private String part;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private CourseStatusDto courseStatus;
    @NotNull(message = "Course status is mandatory")
    private Long courseStatusId;

    @NotNull(message = "Price is mandatory")
    private Double price;

}
