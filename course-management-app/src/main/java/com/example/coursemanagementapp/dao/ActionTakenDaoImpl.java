package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.ActionTakenRepo;

@Component
@AllArgsConstructor
public class ActionTakenDaoImpl implements ActionTakenDao {

    private final ActionTakenRepo actiontakenRepo;

    @Override
    public ActionTakenRepo getRepo() {
        return actiontakenRepo;
    }


}
