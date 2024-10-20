package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true, builderMethodName = "EvaluationHistoryDtoBuilder")

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EvaluationHistoryDto extends AbstractDto {
    private Long id;
    private EvaluationDto evaluation;
    private Long evaluationId;
    private String fieldName;
    private String oldValue;
    private String newValue;

}
