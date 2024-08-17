package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.ClientStatusDao;
import com.example.coursemanagementapp.transformer.ClientStatusTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class ClientStatusServiceImpl implements ClientStatusService {

    private final ClientStatusDao clientstatusDao;
    private final ClientStatusTransformer clientstatusTransformer;

    @Override
    public ClientStatusDao getDao() {
        return clientstatusDao;
    }

    @Override
    public ClientStatusTransformer getTransformer() {
        return clientstatusTransformer;
    }
    



}
