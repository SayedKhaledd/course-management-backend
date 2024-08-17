package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.ClientMapper;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.model.Client;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class ClientTransformer implements AbstractTransformer<Client, ClientDto, ClientMapper> {

    private final ClientMapper clientMapper;

    @Override
    public ClientMapper getMapper() {
        return clientMapper;
    }


}
