package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.ClientStatusRepo;

@Component
@AllArgsConstructor
public class ClientStatusDaoImpl implements ClientStatusDao {

    private final ClientStatusRepo clientstatusRepo;

    @Override
    public ClientStatusRepo getRepo() {
        return clientstatusRepo;
    }


}
