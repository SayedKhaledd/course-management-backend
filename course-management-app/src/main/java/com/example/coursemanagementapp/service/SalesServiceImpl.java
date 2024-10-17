package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.SalesDao;
import com.example.coursemanagementapp.dto.SalesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SalesServiceImpl implements SalesService {
    private final SalesDao salesDao;

    public SalesDao getDao() {
        return salesDao;
    }

    @Override
    public List<SalesDto> findAll() {
        return getDao().findAll();
    }
}
