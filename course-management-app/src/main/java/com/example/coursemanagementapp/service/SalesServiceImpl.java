package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.exception.CustomException;
import com.example.coursemanagementapp.dao.SalesDao;
import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.enums.PaymentType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SalesServiceImpl implements SalesService {
    private final SalesDao salesDao;
    private final EnrollmentService enrollmentService;
    private final InstallmentService installmentService;
    private final RefundService refundService;

    public SalesDao getDao() {
        return salesDao;
    }

    @Override
    public List<SalesDto> findAll() {
        return getDao().findAll();
    }

    @Override
    public void updatePaymentType(Long id, PaymentType paymentType, Boolean isReceived) {
        switch (paymentType) {
            case REFUND:
                refundService.updateIsReceived(id, isReceived);
                break;
            case INSTALLMENT:
                installmentService.updateIsReceived(id, isReceived);
                break;
            case COURSE_PURCHASE:
                enrollmentService.updateIsReceived(id, isReceived);
                break;
            default:
                throw new CustomException("Invalid payment type: " + paymentType);
        }
    }
}
