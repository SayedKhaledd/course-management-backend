package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.ClientStatusDao;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.model.ClientStatus;
import com.example.coursemanagementapp.transformer.ClientStatusTransformer;

import java.util.List;
import java.util.Set;

public interface ClientStatusService extends AbstractService<ClientStatus, ClientStatusDto, ClientStatusTransformer, ClientStatusDao> {

    ClientStatus findEntityByName(com.example.coursemanagementapp.enums.ClientStatus clientStatus);

    List<ClientStatusDto> findAllByStatusesIn(Set<String> statuses);

    Boolean existsByName(String name);

}
