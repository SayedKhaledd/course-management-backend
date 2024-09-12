package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ClientStatusRepo;
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


}
