package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.RefundHistoryMapper;
import com.example.coursemanagementapp.dto.RefundHistoryDto;
import com.example.coursemanagementapp.model.RefundHistory;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class RefundHistoryTransformer implements AbstractTransformer<RefundHistory, RefundHistoryDto, RefundHistoryMapper> {

    private final RefundHistoryMapper refundhistoryMapper;

    @Override
    public RefundHistoryMapper getMapper() {
        return refundhistoryMapper;
    }


}
