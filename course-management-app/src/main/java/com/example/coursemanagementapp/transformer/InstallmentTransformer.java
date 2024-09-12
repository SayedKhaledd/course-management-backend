package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.InstallmentDto;
import com.example.coursemanagementapp.model.Installment;
import com.example.coursemanagementapp.transformer.mapper.InstallmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InstallmentTransformer implements AbstractTransformer<Installment, InstallmentDto, InstallmentMapper> {

    private final InstallmentMapper installmentMapper;

    @Override
    public InstallmentMapper getMapper() {
        return installmentMapper;
    }


}
