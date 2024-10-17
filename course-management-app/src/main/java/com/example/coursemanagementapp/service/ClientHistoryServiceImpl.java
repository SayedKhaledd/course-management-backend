package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.ClientHistoryDao;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.transformer.ClientHistoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ClientHistoryDto> findAllByClientId(Long clientId) {
        log.info("ClientHistoryService: findAllByClientId() - was called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByClientId(clientId));
    }

    @Override
    public List<ClientHistoryDto> findAllByClientIdAndFieldName(Long clientId, String fieldName) {
        log.info("ClientHistoryService: findAllByClientIdAndFieldName() - was called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByClientIdAndFieldName(clientId,fieldName));
    }
}
