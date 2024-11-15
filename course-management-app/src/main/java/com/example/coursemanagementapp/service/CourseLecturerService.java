package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseLecturerDao;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.dto.search.CourseLecturerSearchDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import com.example.coursemanagementapp.transformer.CourseLecturerTransformer;

import java.util.List;

public interface CourseLecturerService extends AbstractService<CourseLecturer, CourseLecturerDto, CourseLecturerTransformer, CourseLecturerDao> {

    List<CourseLecturerDto> findAllByCourseId(Long courseId);

    PaginationResponse<CourseLecturerDto> findAllPaginatedAndFiltered(PaginationRequest<CourseLecturerSearchDto> paginationRequest);

    void updatePaidInPercentage(Long id, Boolean paidInPercentage);

    void updatePercentageAndTotalPercentageCost(Long id, CourseLecturerDto dto);

    void updateNoOfLectures(Long id, CourseLecturerDto dto);

    void updateLectureCost(Long id, CourseLecturerDto dto);

}
