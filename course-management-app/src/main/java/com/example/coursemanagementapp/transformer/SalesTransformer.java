package com.example.coursemanagementapp.transformer;


import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.enums.PaymentMethod;
import com.example.coursemanagementapp.enums.PaymentType;
import org.hibernate.transform.ResultTransformer;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class SalesTransformer implements ResultTransformer<SalesDto> {

    @Override
    public SalesDto transformTuple(Object[] tuple, String[] aliases) {
        SalesDto salesDto = new SalesDto();
        salesDto.setClientName((String) tuple[0]);
        salesDto.setCourseName((String) tuple[1]);
        salesDto.setAmount((BigDecimal) tuple[2]);
        salesDto.setPaymentType(PaymentType.valueOf((String) tuple[3]));
        salesDto.setPaymentMethod(PaymentMethod.valueOf((String) tuple[4]));
        salesDto.setDate(((Timestamp) tuple[5]).toLocalDateTime());
        salesDto.setCurrency((String) tuple[6]);
        return salesDto;
    }

    @Override
    public List<SalesDto> transformList(List<SalesDto> collection) {
        return collection;
    }
}