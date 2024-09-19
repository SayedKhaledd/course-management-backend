package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "EvaluationDtoBuilder")
@Data
public class EvaluationDto extends AbstractDto {
    private Long id;
    private EnrollmentDto enrollment;
    private Long enrollmentId;
    private String examName;
    private EvaluationStatusDto status;
    private Long statusId;

}
