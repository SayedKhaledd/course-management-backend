package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.model.ActionTaken;
import com.example.coursemanagementapp.transformer.mapper.ActionTakenMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActionTakenTransformer implements AbstractTransformer<ActionTaken, ActionTakenDto, ActionTakenMapper> {

    private final ActionTakenMapper actiontakenMapper;

    @Override
    public ActionTakenMapper getMapper() {
        return actiontakenMapper;
    }


}
