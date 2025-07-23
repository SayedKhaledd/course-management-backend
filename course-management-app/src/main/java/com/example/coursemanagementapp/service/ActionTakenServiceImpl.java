package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.ActionTakenDao;
import com.example.coursemanagementapp.enums.ActionTaken;
import com.example.coursemanagementapp.transformer.ActionTakenTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ActionTakenServiceImpl implements ActionTakenService {

    private final ActionTakenDao actiontakenDao;
    private final ActionTakenTransformer actiontakenTransformer;

    @Override
    public ActionTakenDao getDao() {
        return actiontakenDao;
    }

    @Override
    public ActionTakenTransformer getTransformer() {
        return actiontakenTransformer;
    }

    @Override
    public String getEntityName() {
        return ActionTaken.class.getSimpleName();
    }

    @Override
    public com.example.coursemanagementapp.model.ActionTaken findEntityByName(ActionTaken action) {
        log.info("ActionTakenService: findEntityByName() called with action: {}", action);
        return getDao().findByName(action);
    }


}
