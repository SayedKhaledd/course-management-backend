package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.CourseLecturerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseLecturerDaoImpl implements CourseLecturerDao {

    private final CourseLecturerRepo courselecturerRepo;

    @Override
    public CourseLecturerRepo getRepo() {
        return courselecturerRepo;
    }


}
