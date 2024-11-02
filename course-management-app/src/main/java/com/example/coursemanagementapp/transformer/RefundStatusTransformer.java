package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.RefundStatusMapper;
import com.example.coursemanagementapp.dto.RefundStatusDto;
import com.example.coursemanagementapp.model.RefundStatus;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class RefundStatusTransformer implements AbstractTransformer<RefundStatus, RefundStatusDto, RefundStatusMapper> {

    private final RefundStatusMapper refundstatusMapper;

    @Override
    public RefundStatusMapper getMapper() {
        return refundstatusMapper;
    }


}
