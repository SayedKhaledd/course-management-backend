package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.CourseLecturerMapper;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class CourseLecturerTransformer implements AbstractTransformer<CourseLecturer, CourseLecturerDto, CourseLecturerMapper> {

    private final CourseLecturerMapper courselecturerMapper;

    @Override
    public CourseLecturerMapper getMapper() {
        return courselecturerMapper;
    }


}
