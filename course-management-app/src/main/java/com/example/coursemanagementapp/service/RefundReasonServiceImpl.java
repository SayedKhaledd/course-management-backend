package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.RefundReasonDao;
import com.example.coursemanagementapp.transformer.RefundReasonTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class RefundReasonServiceImpl implements RefundReasonService {

    private final RefundReasonDao refundreasonDao;
    private final RefundReasonTransformer refundreasonTransformer;

    @Override
    public RefundReasonDao getDao() {
        return refundreasonDao;
    }

    @Override
    public RefundReasonTransformer getTransformer() {
        return refundreasonTransformer;
    }
    



}
