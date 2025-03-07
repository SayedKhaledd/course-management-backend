package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.model.Client;
import com.example.coursemanagementapp.transformer.mapper.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientTransformer implements AbstractTransformer<Client, ClientDto, ClientMapper> {

    private final ClientMapper clientMapper;

    @Override
    public ClientMapper getMapper() {
        return clientMapper;
    }


}
