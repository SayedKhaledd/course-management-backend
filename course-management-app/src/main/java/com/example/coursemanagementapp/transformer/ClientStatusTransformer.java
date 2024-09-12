package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.model.ClientStatus;
import com.example.coursemanagementapp.transformer.mapper.ClientStatusMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientStatusTransformer implements AbstractTransformer<ClientStatus, ClientStatusDto, ClientStatusMapper> {

    private final ClientStatusMapper clientstatusMapper;

    @Override
    public ClientStatusMapper getMapper() {
        return clientstatusMapper;
    }


}
