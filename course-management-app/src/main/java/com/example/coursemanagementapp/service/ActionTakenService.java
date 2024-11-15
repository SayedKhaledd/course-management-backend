package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.ActionTakenDao;
import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.model.ActionTaken;
import com.example.coursemanagementapp.transformer.ActionTakenTransformer;

public interface ActionTakenService extends AbstractService<ActionTaken, ActionTakenDto, ActionTakenTransformer, ActionTakenDao> {

    ActionTakenDto findByName(com.example.coursemanagementapp.enums.ActionTaken action);

    ActionTaken findEntityByName(com.example.coursemanagementapp.enums.ActionTaken action);

}
