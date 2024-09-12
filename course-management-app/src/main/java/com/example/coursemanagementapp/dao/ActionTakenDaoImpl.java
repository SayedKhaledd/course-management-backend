package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ActionTakenRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActionTakenDaoImpl implements ActionTakenDao {

    private final ActionTakenRepo actiontakenRepo;

    @Override
    public ActionTakenRepo getRepo() {
        return actiontakenRepo;
    }


}
