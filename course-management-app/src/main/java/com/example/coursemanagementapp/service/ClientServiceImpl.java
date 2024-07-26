package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.ClientDao;
import com.example.coursemanagementapp.transformer.ClientTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private final ClientTransformer clientTransformer;

    @Override
    public ClientDao getDao() {
        return clientDao;
    }

    @Override
    public ClientTransformer getTransformer() {
        return clientTransformer;
    }


}
