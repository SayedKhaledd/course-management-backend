package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.InstallmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InstallmentDaoImpl implements InstallmentDao {

    private final InstallmentRepo installmentRepo;

    @Override
    public InstallmentRepo getRepo() {
        return installmentRepo;
    }


}
