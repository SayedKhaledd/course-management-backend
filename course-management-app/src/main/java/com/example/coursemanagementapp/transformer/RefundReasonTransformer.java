package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.RefundReasonMapper;
import com.example.coursemanagementapp.dto.RefundReasonDto;
import com.example.coursemanagementapp.model.RefundReason;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class RefundReasonTransformer implements AbstractTransformer<RefundReason, RefundReasonDto, RefundReasonMapper> {

    private final RefundReasonMapper refundreasonMapper;

    @Override
    public RefundReasonMapper getMapper() {
        return refundreasonMapper;
    }


}
