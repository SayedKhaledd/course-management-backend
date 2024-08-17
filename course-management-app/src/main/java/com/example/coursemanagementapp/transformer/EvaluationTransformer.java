package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.EvaluationMapper;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.model.Evaluation;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class EvaluationTransformer implements AbstractTransformer<Evaluation, EvaluationDto, EvaluationMapper> {

    private final EvaluationMapper evaluationMapper;

    @Override
    public EvaluationMapper getMapper() {
        return evaluationMapper;
    }


}
