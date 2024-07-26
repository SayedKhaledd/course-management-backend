package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.SpecialityDao;
import com.example.coursemanagementapp.dto.SpecialityDto;
import com.example.coursemanagementapp.model.Speciality;
import com.example.coursemanagementapp.transformer.SpecialityTransformer;

public interface SpecialityService extends AbstractService<Speciality, SpecialityDto, SpecialityTransformer, SpecialityDao> {

}
