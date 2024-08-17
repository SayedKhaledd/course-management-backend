package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.Installment;
import com.example.coursemanagementapp.dto.InstallmentDto;
import com.example.coursemanagementapp.transformer.InstallmentTransformer;
import com.example.coursemanagementapp.dao.InstallmentDao;
import com.example.backendcoreservice.service.AbstractService;

public interface InstallmentService extends AbstractService<Installment, InstallmentDto, InstallmentTransformer, InstallmentDao> {

}
