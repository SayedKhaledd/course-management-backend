package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.InstallmentRepo;

@Component
@AllArgsConstructor
public class InstallmentDaoImpl implements InstallmentDao {

    private final InstallmentRepo installmentRepo;

    @Override
    public InstallmentRepo getRepo() {
        return installmentRepo;
    }


}
