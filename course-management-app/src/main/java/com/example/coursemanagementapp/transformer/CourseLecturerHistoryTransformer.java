package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.CourseLecturerHistoryMapper;
import com.example.coursemanagementapp.dto.CourseLecturerHistoryDto;
import com.example.coursemanagementapp.model.CourseLecturerHistory;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class CourseLecturerHistoryTransformer implements AbstractTransformer<CourseLecturerHistory, CourseLecturerHistoryDto, CourseLecturerHistoryMapper> {

    private final CourseLecturerHistoryMapper courselecturerhistoryMapper;

    @Override
    public CourseLecturerHistoryMapper getMapper() {
        return courselecturerhistoryMapper;
    }


}
