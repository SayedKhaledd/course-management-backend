package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ClientStatusRepo;
import com.example.coursemanagementapp.model.ClientStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

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

    @Override
    public List<ClientStatus> findAllByStatusesIn(Set<String> statuses) {
        return getRepo().findAllByStatusesIn(statuses);
    }

    @Override
    public Boolean existsByName(String name) {
        return getRepo().existsByStatus(name);
    }
}
