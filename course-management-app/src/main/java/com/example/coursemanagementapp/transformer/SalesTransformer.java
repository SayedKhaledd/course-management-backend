package com.example.coursemanagementapp.transformer;


import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.model.Sales;
import com.example.coursemanagementapp.transformer.mapper.SalesMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SalesTransformer implements AbstractTransformer<Sales, SalesDto, SalesMapper> {

    private final SalesMapper salesMapper;

    @Override
    public SalesMapper getMapper() {
        return salesMapper;
    }
}