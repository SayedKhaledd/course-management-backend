package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ClientHistoryRepo;
import com.example.coursemanagementapp.model.ClientHistory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class ClientHistoryDaoImpl implements ClientHistoryDao {

    private final ClientHistoryRepo clienthistoryRepo;

    @Override
    public ClientHistoryRepo getRepo() {
        return clienthistoryRepo;
    }

    @Override
    public List<ClientHistory> findAllByClientId(Long clientId) {
        log.info("ClientHistoryDao: findAllByClientId() - was called");
        return getRepo().findAllByClientId(clientId);
    }
}
