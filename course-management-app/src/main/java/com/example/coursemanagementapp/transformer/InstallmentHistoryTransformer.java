package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.InstallmentHistoryMapper;
import com.example.coursemanagementapp.dto.InstallmentHistoryDto;
import com.example.coursemanagementapp.model.InstallmentHistory;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class InstallmentHistoryTransformer implements AbstractTransformer<InstallmentHistory, InstallmentHistoryDto, InstallmentHistoryMapper> {

    private final InstallmentHistoryMapper installmenthistoryMapper;

    @Override
    public InstallmentHistoryMapper getMapper() {
        return installmenthistoryMapper;
    }


}
