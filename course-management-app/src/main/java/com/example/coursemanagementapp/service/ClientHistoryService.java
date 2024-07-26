package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.ClientHistory;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.transformer.ClientHistoryTransformer;
import com.example.coursemanagementapp.dao.ClientHistoryDao;
import com.example.backendcoreservice.service.AbstractService;

public interface ClientHistoryService extends AbstractService<ClientHistory, ClientHistoryDto, ClientHistoryTransformer, ClientHistoryDao> {

}
