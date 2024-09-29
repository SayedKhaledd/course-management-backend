package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Name is mandatory", groups = {CreateWithPercentage.class, CreateWithFixedValue.class})
    private String name;
    private CourseDto course;
    @NotBlank(message = "Course is mandatory", groups = {CreateWithPercentage.class, CreateWithFixedValue.class})
    private Long courseId;
    @NotBlank(message = "Paid in percentage is mandatory", groups = {CreateWithPercentage.class, CreateWithFixedValue.class})
    private Boolean paidInPercentage = false;
    @NotNull(message = "Percentage value is mandatory", groups = {CreateWithPercentage.class})
    private Double percentage;
    @NotNull(message = "Fixed value is mandatory", groups = {CreateWithFixedValue.class})
    private Double fixedValue;

    public interface CreateWithPercentage {
    }

    public interface CreateWithFixedValue {
    }
}
