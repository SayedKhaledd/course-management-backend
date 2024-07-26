package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.ClientHistoryRepo;

@Component
@AllArgsConstructor
public class ClientHistoryDaoImpl implements ClientHistoryDao {

    private final ClientHistoryRepo clienthistoryRepo;

    @Override
    public ClientHistoryRepo getRepo() {
        return clienthistoryRepo;
    }


}
