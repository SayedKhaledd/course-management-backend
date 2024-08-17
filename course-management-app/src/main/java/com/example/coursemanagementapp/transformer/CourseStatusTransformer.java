package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.CourseStatusMapper;
import com.example.coursemanagementapp.dto.CourseStatusDto;
import com.example.coursemanagementapp.model.CourseStatus;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class CourseStatusTransformer implements AbstractTransformer<CourseStatus, CourseStatusDto, CourseStatusMapper> {

    private final CourseStatusMapper coursestatusMapper;

    @Override
    public CourseStatusMapper getMapper() {
        return coursestatusMapper;
    }


}
