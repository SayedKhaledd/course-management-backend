package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.InstallmentDao;
import com.example.coursemanagementapp.transformer.InstallmentTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class InstallmentServiceImpl implements InstallmentService {

    private final InstallmentDao installmentDao;
    private final InstallmentTransformer installmentTransformer;

    @Override
    public InstallmentDao getDao() {
        return installmentDao;
    }

    @Override
    public InstallmentTransformer getTransformer() {
        return installmentTransformer;
    }


}
