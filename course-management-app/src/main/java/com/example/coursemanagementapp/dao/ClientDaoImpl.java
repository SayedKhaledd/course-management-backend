package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientDaoImpl implements ClientDao {

    private final ClientRepo clientRepo;

    @Override
    public ClientRepo getRepo() {
        return clientRepo;
    }


}
