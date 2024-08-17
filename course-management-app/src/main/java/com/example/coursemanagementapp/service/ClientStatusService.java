package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.ClientStatus;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.transformer.ClientStatusTransformer;
import com.example.coursemanagementapp.dao.ClientStatusDao;
import com.example.backendcoreservice.service.AbstractService;

public interface ClientStatusService extends AbstractService<ClientStatus, ClientStatusDto, ClientStatusTransformer, ClientStatusDao> {

}
