package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.InstallmentDao;
import com.example.coursemanagementapp.dto.InstallmentDto;
import com.example.coursemanagementapp.model.Installment;
import com.example.coursemanagementapp.transformer.InstallmentTransformer;

public interface InstallmentService extends AbstractService<Installment, InstallmentDto, InstallmentTransformer, InstallmentDao> {

}
