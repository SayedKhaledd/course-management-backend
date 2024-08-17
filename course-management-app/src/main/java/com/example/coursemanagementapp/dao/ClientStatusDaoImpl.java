package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.ClientStatus;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.ClientStatusRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class ClientStatusDaoImpl implements ClientStatusDao {

    private final ClientStatusRepo clientstatusRepo;

    @Override
    public ClientStatusRepo getRepo() {
        return clientstatusRepo;
    }

    @Override
    public List<ClientStatus> findAll() {
        return getRepo().findAllByMarkedAsDeletedFalse();
    }
}
