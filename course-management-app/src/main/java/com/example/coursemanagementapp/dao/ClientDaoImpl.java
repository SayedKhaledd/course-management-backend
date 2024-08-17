package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.ClientRepo;

@Component
@AllArgsConstructor
public class ClientDaoImpl implements ClientDao {

    private final ClientRepo clientRepo;

    @Override
    public ClientRepo getRepo() {
        return clientRepo;
    }


}
