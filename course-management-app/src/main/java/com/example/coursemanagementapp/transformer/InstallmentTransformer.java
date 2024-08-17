package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.InstallmentMapper;
import com.example.coursemanagementapp.dto.InstallmentDto;
import com.example.coursemanagementapp.model.Installment;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class InstallmentTransformer implements AbstractTransformer<Installment, InstallmentDto, InstallmentMapper> {

    private final InstallmentMapper installmentMapper;

    @Override
    public InstallmentMapper getMapper() {
        return installmentMapper;
    }


}
