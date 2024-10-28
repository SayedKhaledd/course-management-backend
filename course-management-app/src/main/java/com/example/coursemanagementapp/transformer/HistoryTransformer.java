package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.HistoryMapper;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.model.History;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class HistoryTransformer implements AbstractTransformer<History, HistoryDto, HistoryMapper> {

    private final HistoryMapper historyMapper;

    @Override
    public HistoryMapper getMapper() {
        return historyMapper;
    }


}
