package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.RefundStatus;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.RefundStatusRepo;

public interface RefundStatusDao extends AbstractDao<RefundStatus, RefundStatusRepo> {

    RefundStatus findEntityByStatus(com.example.coursemanagementapp.enums.RefundStatus refundStatus);

}
