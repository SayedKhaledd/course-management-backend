package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.ActionTakenRepo;
import com.example.coursemanagementapp.model.ActionTaken;

public interface ActionTakenDao extends AbstractDao<ActionTaken, ActionTakenRepo> {

    ActionTaken findByName(com.example.coursemanagementapp.enums.ActionTaken action);
}
