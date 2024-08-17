package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.ClientStatusMapper;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.model.ClientStatus;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class ClientStatusTransformer implements AbstractTransformer<ClientStatus, ClientStatusDto, ClientStatusMapper> {

    private final ClientStatusMapper clientstatusMapper;

    @Override
    public ClientStatusMapper getMapper() {
        return clientstatusMapper;
    }


}
