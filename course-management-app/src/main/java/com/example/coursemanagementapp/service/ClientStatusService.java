package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.ClientStatusDao;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.model.ClientStatus;
import com.example.coursemanagementapp.transformer.ClientStatusTransformer;

public interface ClientStatusService extends AbstractService<ClientStatus, ClientStatusDto, ClientStatusTransformer, ClientStatusDao> {

    com.example.coursemanagementapp.model.ClientStatus findEntityByName(com.example.coursemanagementapp.enums.ClientStatus clientStatus);

}
