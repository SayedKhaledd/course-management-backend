package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.ActionDao;
import com.example.coursemanagementapp.transformer.ActionTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionDao actionDao;
    private final ActionTransformer actionTransformer;

    @Override
    public ActionDao getDao() {
        return actionDao;
    }

    @Override
    public ActionTransformer getTransformer() {
        return actionTransformer;
    }


}
