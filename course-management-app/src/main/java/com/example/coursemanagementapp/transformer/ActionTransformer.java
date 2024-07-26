package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.ActionDto;
import com.example.coursemanagementapp.model.Action;
import com.example.coursemanagementapp.transformer.mapper.ActionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActionTransformer implements AbstractTransformer<Action, ActionDto, ActionMapper> {

    private final ActionMapper actionMapper;

    @Override
    public ActionMapper getMapper() {
        return actionMapper;
    }


}
