package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ClientStatusRepo;
import com.example.coursemanagementapp.model.ClientStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientStatusDaoImpl implements ClientStatusDao {

    private final ClientStatusRepo clientstatusRepo;

    @Override
    public ClientStatusRepo getRepo() {
        return clientstatusRepo;
    }

    @Override
    public ClientStatus findEntityByName(com.example.coursemanagementapp.enums.ClientStatus clientStatus) {
        return getRepo().findEntityByStatus(clientStatus);
    }
}
