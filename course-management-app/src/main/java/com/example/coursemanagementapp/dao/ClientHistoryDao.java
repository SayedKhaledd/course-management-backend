package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.ClientHistoryRepo;
import com.example.coursemanagementapp.model.ClientHistory;

import java.util.List;

public interface ClientHistoryDao extends AbstractDao<ClientHistory, ClientHistoryRepo> {

    List<ClientHistory> findAllByClientId(Long clientId);
}
