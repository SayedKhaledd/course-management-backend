package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.CourseMapper;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.model.Course;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class CourseTransformer implements AbstractTransformer<Course, CourseDto, CourseMapper> {

    private final CourseMapper courseMapper;

    @Override
    public CourseMapper getMapper() {
        return courseMapper;
    }


}
