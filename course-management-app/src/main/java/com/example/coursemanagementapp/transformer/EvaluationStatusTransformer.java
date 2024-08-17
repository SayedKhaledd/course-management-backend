package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.EvaluationStatusMapper;
import com.example.coursemanagementapp.dto.EvaluationStatusDto;
import com.example.coursemanagementapp.model.EvaluationStatus;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class EvaluationStatusTransformer implements AbstractTransformer<EvaluationStatus, EvaluationStatusDto, EvaluationStatusMapper> {

    private final EvaluationStatusMapper evaluationstatusMapper;

    @Override
    public EvaluationStatusMapper getMapper() {
        return evaluationstatusMapper;
    }


}
