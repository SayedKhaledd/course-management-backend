package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.DoctorHistoryDao;
import com.example.coursemanagementapp.dto.DoctorHistoryDto;
import com.example.coursemanagementapp.model.DoctorHistory;
import com.example.coursemanagementapp.transformer.DoctorHistoryTransformer;

public interface DoctorHistoryService extends AbstractService<DoctorHistory, DoctorHistoryDto, DoctorHistoryTransformer, DoctorHistoryDao> {

}
