package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.ClientStatusDao;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.model.ClientStatus;
import com.example.coursemanagementapp.transformer.ClientStatusTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public String getEntityName() {
        return ClientStatus.class.getSimpleName();
    }
}
