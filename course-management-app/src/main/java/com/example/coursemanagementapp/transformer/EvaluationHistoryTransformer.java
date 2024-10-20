package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.EvaluationHistoryMapper;
import com.example.coursemanagementapp.dto.EvaluationHistoryDto;
import com.example.coursemanagementapp.model.EvaluationHistory;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class EvaluationHistoryTransformer implements AbstractTransformer<EvaluationHistory, EvaluationHistoryDto, EvaluationHistoryMapper> {

    private final EvaluationHistoryMapper evaluationhistoryMapper;

    @Override
    public EvaluationHistoryMapper getMapper() {
        return evaluationhistoryMapper;
    }


}
