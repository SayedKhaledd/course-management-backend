package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.DoctorHistoryDto;
import com.example.coursemanagementapp.model.DoctorHistory;
import com.example.coursemanagementapp.transformer.mapper.DoctorHistoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DoctorHistoryTransformer implements AbstractTransformer<DoctorHistory, DoctorHistoryDto, DoctorHistoryMapper> {

    private final DoctorHistoryMapper doctorhistoryMapper;

    @Override
    public DoctorHistoryMapper getMapper() {
        return doctorhistoryMapper;
    }


}
