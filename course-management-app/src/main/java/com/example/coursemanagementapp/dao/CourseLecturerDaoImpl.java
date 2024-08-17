package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.CourseLecturerRepo;

@Component
@AllArgsConstructor
public class CourseLecturerDaoImpl implements CourseLecturerDao {

    private final CourseLecturerRepo courselecturerRepo;

    @Override
    public CourseLecturerRepo getRepo() {
        return courselecturerRepo;
    }


}
