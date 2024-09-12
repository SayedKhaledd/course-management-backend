package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.model.Refund;
import com.example.coursemanagementapp.transformer.mapper.RefundMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefundTransformer implements AbstractTransformer<Refund, RefundDto, RefundMapper> {

    private final RefundMapper refundMapper;

    @Override
    public RefundMapper getMapper() {
        return refundMapper;
    }


}
