package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.ClientStatusRepo;
import com.example.coursemanagementapp.model.ClientStatus;

import java.util.List;
import java.util.Set;

public interface ClientStatusDao extends AbstractDao<ClientStatus, ClientStatusRepo> {

    ClientStatus findEntityByName(com.example.coursemanagementapp.enums.ClientStatus clientStatus);

    List<ClientStatus> findAllByStatusesIn(Set<String> statuses);

    Boolean existsByName(String name);
}
