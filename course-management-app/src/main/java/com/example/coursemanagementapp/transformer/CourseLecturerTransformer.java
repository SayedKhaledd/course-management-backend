package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import com.example.coursemanagementapp.transformer.mapper.CourseLecturerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseLecturerTransformer implements AbstractTransformer<CourseLecturer, CourseLecturerDto, CourseLecturerMapper> {

    private final CourseLecturerMapper courselecturerMapper;

    @Override
    public CourseLecturerMapper getMapper() {
        return courselecturerMapper;
    }


}
