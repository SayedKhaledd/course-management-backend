package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

@Validated
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "EvaluationDtoBuilder")
@Data
public class EvaluationDto extends AbstractDto {
    private Long id;
    private EnrollmentDto enrollment;
    private Long enrollmentId;
    @NotNull(message = "Exam name is mandatory", groups = {Create.class, UpdateExamName.class})
    private String examName;
    private EvaluationStatusDto evaluationStatus;
    private Long evaluationStatusId;

    public interface Create {
    }

    public interface UpdateExamName {
    }

}
