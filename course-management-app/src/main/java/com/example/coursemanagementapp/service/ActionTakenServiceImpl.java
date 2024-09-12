package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.ActionTakenDao;
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


}
