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
    @NotBlank(message = "Name is mandatory", groups = {Create.class, CreateInitial.class, UpdateName.class})
    private String name;
    @NotBlank(message = "Description is mandatory", groups = {UpdateDescription.class})
    private String description;
    @NotBlank(message = "Code is mandatory", groups = {Create.class, UpdateCode.class})
    private String code;
    @NotBlank(message = "Part is mandatory", groups = {Create.class, CreateInitial.class, UpdatePart.class})
    private String part;
    @NotNull(message = "StartDate is mandatory", groups = {UpdateStartDate.class})
    private LocalDateTime startDate;
    @NotNull(message = "EndDate is mandatory", groups = {UpdateEndDate.class})
    private LocalDateTime endDate;
    private CourseStatusDto courseStatus;
    private Long courseStatusId;
    @NotNull(message = "Price is mandatory", groups = {Create.class, UpdatePrice.class})
    private Double price;

    public interface Create {
    }

    public interface CreateInitial {
    }

    public interface UpdateName {
    }

    public interface UpdateCode {
    }

    public interface UpdatePart {
    }

    public interface UpdatePrice {
    }

    public interface UpdateDescription {
    }

    public interface UpdateStartDate {
    }

    public interface UpdateEndDate {
    }


}
