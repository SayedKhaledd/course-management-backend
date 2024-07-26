package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.SpecialityDto;
import com.example.coursemanagementapp.model.Speciality;
import com.example.coursemanagementapp.transformer.mapper.SpecialityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SpecialityTransformer implements AbstractTransformer<Speciality, SpecialityDto, SpecialityMapper> {

    private final SpecialityMapper specialityMapper;

    @Override
    public SpecialityMapper getMapper() {
        return specialityMapper;
    }


}
