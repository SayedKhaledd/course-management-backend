package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.CourseHistoryMapper;
import com.example.coursemanagementapp.dto.CourseHistoryDto;
import com.example.coursemanagementapp.model.CourseHistory;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class CourseHistoryTransformer implements AbstractTransformer<CourseHistory, CourseHistoryDto, CourseHistoryMapper> {

    private final CourseHistoryMapper coursehistoryMapper;

    @Override
    public CourseHistoryMapper getMapper() {
        return coursehistoryMapper;
    }


}
