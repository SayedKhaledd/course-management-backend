package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.ClientHistoryDao;
import com.example.coursemanagementapp.transformer.ClientHistoryTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class ClientHistoryServiceImpl implements ClientHistoryService {

    private final ClientHistoryDao clienthistoryDao;
    private final ClientHistoryTransformer clienthistoryTransformer;

    @Override
    public ClientHistoryDao getDao() {
        return clienthistoryDao;
    }

    @Override
    public ClientHistoryTransformer getTransformer() {
        return clienthistoryTransformer;
    }
    



}
