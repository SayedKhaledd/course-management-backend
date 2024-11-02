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

    @NotBlank(message = "Name is mandatory", groups = {Create.class})
    private String name;
    private CourseDto course;

    @NotNull(message = "Course is mandatory", groups = {Create.class})
    private Long courseId;
    private Boolean paidInPercentage = false;

    @NotNull(message = "Percentage is mandatory", groups = {UpdatePercentage.class})
    private Double percentage;

    @NotNull(message = "Total percentage cost is mandatory", groups = {UpdateTotalPercentageCost.class})
    private Double totalPercentageCost;

    @NotNull(message = "No of lectures is mandatory", groups = {UpdateNoOfLectures.class})
    private Long noOfLectures = 0L;

    @NotNull(message = "Lecture cost is mandatory", groups = {UpdateLectureCost.class})
    private Double lectureCost = 0.0;

    private Double totalFixedCost = 0.0;

    public interface Create {
    }

    public interface UpdatePercentage {

    }

    public interface UpdateTotalPercentageCost {

    }

    public interface UpdateNoOfLectures {

    }

    public interface UpdateLectureCost {

    }

}

