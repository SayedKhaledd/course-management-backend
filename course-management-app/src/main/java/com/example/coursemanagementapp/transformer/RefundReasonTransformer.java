package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.RefundReasonDto;
import com.example.coursemanagementapp.model.RefundReason;
import com.example.coursemanagementapp.transformer.mapper.RefundReasonMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefundReasonTransformer implements AbstractTransformer<RefundReason, RefundReasonDto, RefundReasonMapper> {

    private final RefundReasonMapper refundreasonMapper;

    @Override
    public RefundReasonMapper getMapper() {
        return refundreasonMapper;
    }


}
