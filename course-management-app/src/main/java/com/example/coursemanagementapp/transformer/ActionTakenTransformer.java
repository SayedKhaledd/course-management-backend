package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.ActionTakenMapper;
import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.model.ActionTaken;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class ActionTakenTransformer implements AbstractTransformer<ActionTaken, ActionTakenDto, ActionTakenMapper> {

    private final ActionTakenMapper actiontakenMapper;

    @Override
    public ActionTakenMapper getMapper() {
        return actiontakenMapper;
    }


}
