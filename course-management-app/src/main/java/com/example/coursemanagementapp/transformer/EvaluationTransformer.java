package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.model.Evaluation;
import com.example.coursemanagementapp.transformer.mapper.EvaluationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EvaluationTransformer implements AbstractTransformer<Evaluation, EvaluationDto, EvaluationMapper> {

    private final EvaluationMapper evaluationMapper;

    @Override
    public EvaluationMapper getMapper() {
        return evaluationMapper;
    }


}
