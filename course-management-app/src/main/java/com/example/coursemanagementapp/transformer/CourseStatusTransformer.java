package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.CourseStatusDto;
import com.example.coursemanagementapp.model.CourseStatus;
import com.example.coursemanagementapp.transformer.mapper.CourseStatusMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseStatusTransformer implements AbstractTransformer<CourseStatus, CourseStatusDto, CourseStatusMapper> {

    private final CourseStatusMapper coursestatusMapper;

    @Override
    public CourseStatusMapper getMapper() {
        return coursestatusMapper;
    }


}
