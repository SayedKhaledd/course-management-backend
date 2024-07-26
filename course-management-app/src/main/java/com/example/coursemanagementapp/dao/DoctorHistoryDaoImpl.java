package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.DoctorHistoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DoctorHistoryDaoImpl implements DoctorHistoryDao {

    private final DoctorHistoryRepo doctorhistoryRepo;

    @Override
    public DoctorHistoryRepo getRepo() {
        return doctorhistoryRepo;
    }


}
