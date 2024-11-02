package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.transformer.mapper.CourseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseTransformer implements AbstractTransformer<Course, CourseDto, CourseMapper> {

    private final CourseMapper courseMapper;

    @Override
    public CourseMapper getMapper() {
        return courseMapper;
    }


}
