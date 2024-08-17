package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.Client;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.transformer.ClientTransformer;
import com.example.coursemanagementapp.dao.ClientDao;
import com.example.backendcoreservice.service.AbstractService;

public interface ClientService extends AbstractService<Client, ClientDto, ClientTransformer, ClientDao> {

}
