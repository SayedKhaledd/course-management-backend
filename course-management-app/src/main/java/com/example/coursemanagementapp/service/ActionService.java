package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.ActionDao;
import com.example.coursemanagementapp.dto.ActionDto;
import com.example.coursemanagementapp.model.Action;
import com.example.coursemanagementapp.transformer.ActionTransformer;

public interface ActionService extends AbstractService<Action, ActionDto, ActionTransformer, ActionDao> {

}
