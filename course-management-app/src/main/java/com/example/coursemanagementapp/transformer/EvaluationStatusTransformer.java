package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.EvaluationStatusDto;
import com.example.coursemanagementapp.model.EvaluationStatus;
import com.example.coursemanagementapp.transformer.mapper.EvaluationStatusMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EvaluationStatusTransformer implements AbstractTransformer<EvaluationStatus, EvaluationStatusDto, EvaluationStatusMapper> {

    private final EvaluationStatusMapper evaluationstatusMapper;

    @Override
    public EvaluationStatusMapper getMapper() {
        return evaluationstatusMapper;
    }


}
