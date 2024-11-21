package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.exception.CustomException;
import com.example.coursemanagementapp.dao.SalesDao;
import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.dto.search.SalesSearchDto;
import com.example.coursemanagementapp.enums.PaymentType;
import com.example.coursemanagementapp.model.Sales;
import com.example.coursemanagementapp.transformer.SalesTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SalesServiceImpl implements SalesService {
    private final SalesDao salesDao;
    private final SalesTransformer salesTransformer;
    private final EnrollmentService enrollmentService;
    private final InstallmentService installmentService;
    private final RefundService refundService;
    private final PaymentStatusService paymentStatusService;
    private final RefundStatusService refundStatusService;

    @Override
    public SalesDao getDao() {
        return salesDao;
    }

    @Override
    public SalesTransformer getTransformer() {
        return salesTransformer;
    }

    @Override
    public String getEntityName() {
        return Sales.class.getSimpleName();
    }

    @Override
    public PaginationResponse<SalesDto> findAllPaginatedAndFiltered(PaginationRequest<SalesSearchDto> paginationRequest) {
        log.info("SalesService: findAllPaginatedAndFiltered() called with paginationRequest: {}", paginationRequest);
        PaginationResponse<SalesDto> response = buildPaginationResponse(getDao().findAllPaginatedAndFiltered(paginationRequest));
        List<SalesDto> result = response.getResult().stream().map(salesDto -> {
            assignPaymentStatus(salesDto);
            return salesDto;
        }).collect(Collectors.toList());
        response.setResult(result);
        return response;
    }

    @Override
    public void updateIsReceivedByPaymentType(Long entityId, PaymentType paymentType, Boolean isReceived) {
        log.info("SalesService: updateIsReceivedByPaymentType() called with entityId: {}, paymentType: {}, isReceived: {}", entityId, paymentType, isReceived);
        switch (paymentType) {
            case REFUND:
                refundService.updateIsReceived(entityId, isReceived);
                break;
            case INSTALLMENT:
                installmentService.updateIsReceived(entityId, isReceived);
                break;
            case COURSE_PURCHASE:
                enrollmentService.updateIsReceived(entityId, isReceived);
                break;
            default:
                throw new CustomException("Invalid payment type: " + paymentType);
        }
    }

    @Override
    public void updatePaymentStatusByPaymentType(Long entityId, PaymentType paymentType, Long paymentStatusId) {
        log.info("SalesService: updatePaymentStatus() called with entityId: {}, paymentType: {}, paymentStatusId: {}", entityId, paymentType, paymentStatusId);
        switch (paymentType) {
            case REFUND:
                refundService.updateRefundStatus(entityId, paymentStatusId);
                break;
            case INSTALLMENT:
                installmentService.updatePaymentStatus(entityId, paymentStatusId);
                break;
            case COURSE_PURCHASE:
                enrollmentService.updatePaymentStatus(entityId, paymentStatusId);
                break;
            default:
                throw new CustomException("Invalid payment type: " + paymentType);
        }
    }


    private void assignPaymentStatus(SalesDto salesDto) {
        log.info("SalesService: assignPaymentStatus() called with salesDto: {}", salesDto);
        switch (salesDto.getType()) {
            case COURSE_PURCHASE, INSTALLMENT:
                salesDto.setPaymentStatus(paymentStatusService.findById(salesDto.getPaymentStatusId()));
                break;
            case REFUND:
                salesDto.setPaymentStatus(refundStatusService.findById(salesDto.getPaymentStatusId()));
                break;
            default:
                throw new CustomException("Invalid payment type: " + salesDto.getType());
        }
    }
}
