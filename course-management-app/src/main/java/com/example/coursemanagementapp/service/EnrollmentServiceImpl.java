package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.EnrollmentDao;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.transformer.EnrollmentTransformer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentDao enrollmentDao;
    private final EnrollmentTransformer enrollmentTransformer;
    private final EnrollmentHistoryService enrollmentHistoryService;
    private final CourseService courseService;
    private final ClientService clientService;
    private final ReferralSourceService referralSourceService;

    @Override
    public EnrollmentDao getDao() {
        return enrollmentDao;
    }

    @Override
    public EnrollmentTransformer getTransformer() {
        return enrollmentTransformer;
    }

    @SneakyThrows
    @Override
    public Enrollment doBeforeCreate(Enrollment entity, EnrollmentDto dto) {
        entity.setCourse(courseService.findEntityById(dto.getCourseId()));
        entity.setClient(clientService.findEntityById(dto.getClientId()));
        entity.setAmountPaid(dto.getAmountPaid() == null ? 0.0 : dto.getAmountPaid());
        entity.setRemainingAmount(entity.getCourse().getPrice() - entity.getAmountPaid());
        entity.setReferralSource(dto.getReferralSourceId() == null ? entity.getClient().getReferralSource() : referralSourceService.findEntityById(dto.getReferralSourceId()));
        return entity;
    }

    @Override
    public List<EnrollmentDto> findAllByClientId(Long clientId) {
        log.info("EnrollmentService: findAllByClientId() called with clientId: {}", clientId);
        return getTransformer().transformEntitiesToDtos(getDao().findAllByClientId(clientId));
    }
}
