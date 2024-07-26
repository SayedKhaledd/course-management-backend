package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ActionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActionDaoImpl implements ActionDao {

    private final ActionRepo actionRepo;

    @Override
    public ActionRepo getRepo() {
        return actionRepo;
    }


}
