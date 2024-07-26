package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.SpecialityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SpecialityDaoImpl implements SpecialityDao {

    private final SpecialityRepo specialityRepo;

    @Override
    public SpecialityRepo getRepo() {
        return specialityRepo;
    }


}
