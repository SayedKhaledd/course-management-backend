package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ClientHistoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientHistoryDaoImpl implements ClientHistoryDao {

    private final ClientHistoryRepo clienthistoryRepo;

    @Override
    public ClientHistoryRepo getRepo() {
        return clienthistoryRepo;
    }


}
