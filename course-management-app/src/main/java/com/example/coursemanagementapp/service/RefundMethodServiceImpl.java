package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.RefundMethodDao;
import com.example.coursemanagementapp.transformer.RefundMethodTransformer;
import com.example.coursemanagementapp.model.RefundMethod;


@Slf4j
@Service
@AllArgsConstructor
public class RefundMethodServiceImpl implements RefundMethodService {

    private final RefundMethodDao refundmethodDao;
    private final RefundMethodTransformer refundmethodTransformer;

    @Override
    public RefundMethodDao getDao() {
        return refundmethodDao;
    }

    @Override
    public RefundMethodTransformer getTransformer() {
        return refundmethodTransformer;
    }
    
    @Override
    public String getEntityName() {
       return RefundMethod.class.getSimpleName();
    }
    



}
