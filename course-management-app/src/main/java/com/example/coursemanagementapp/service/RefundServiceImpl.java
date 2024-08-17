package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.RefundDao;
import com.example.coursemanagementapp.transformer.RefundTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final RefundDao refundDao;
    private final RefundTransformer refundTransformer;

    @Override
    public RefundDao getDao() {
        return refundDao;
    }

    @Override
    public RefundTransformer getTransformer() {
        return refundTransformer;
    }
    



}
