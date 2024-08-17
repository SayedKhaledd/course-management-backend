package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.ActionTaken;
import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.transformer.ActionTakenTransformer;
import com.example.coursemanagementapp.dao.ActionTakenDao;
import com.example.backendcoreservice.service.AbstractService;

public interface ActionTakenService extends AbstractService<ActionTaken, ActionTakenDto, ActionTakenTransformer, ActionTakenDao> {

}
