package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.ClientHistoryDao;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.model.ClientHistory;
import com.example.coursemanagementapp.transformer.ClientHistoryTransformer;

public interface ClientHistoryService extends AbstractService<ClientHistory, ClientHistoryDto, ClientHistoryTransformer, ClientHistoryDao> {

}
