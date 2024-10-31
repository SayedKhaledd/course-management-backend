package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.RefundMethodMapper;
import com.example.coursemanagementapp.dto.RefundMethodDto;
import com.example.coursemanagementapp.model.RefundMethod;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class RefundMethodTransformer implements AbstractTransformer<RefundMethod, RefundMethodDto, RefundMethodMapper> {

    private final RefundMethodMapper refundmethodMapper;

    @Override
    public RefundMethodMapper getMapper() {
        return refundmethodMapper;
    }


}
