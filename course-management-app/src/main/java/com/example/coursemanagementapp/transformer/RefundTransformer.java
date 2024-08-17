package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.RefundMapper;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.model.Refund;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class RefundTransformer implements AbstractTransformer<Refund, RefundDto, RefundMapper> {

    private final RefundMapper refundMapper;

    @Override
    public RefundMapper getMapper() {
        return refundMapper;
    }


}
