package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ActionTakenRepo;
import com.example.coursemanagementapp.model.ActionTaken;
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

    @Override
    public ActionTaken findByName(com.example.coursemanagementapp.enums.ActionTaken action) {
        log.info("ActionTakenDao: findByName() called with action: {}", action);
        return getRepo().findByAction(action);
    }
}
