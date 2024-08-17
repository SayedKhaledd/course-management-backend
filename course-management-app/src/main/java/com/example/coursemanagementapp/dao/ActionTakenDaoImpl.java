package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.ActionTaken;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.ActionTakenRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class ActionTakenDaoImpl implements ActionTakenDao {

    private final ActionTakenRepo actiontakenRepo;

    @Override
    public ActionTakenRepo getRepo() {
        return actiontakenRepo;
    }


    @Override
    public List<ActionTaken> findAll() {
        return getRepo().findAllByMarkedAsDeletedFalse();
    }
}
