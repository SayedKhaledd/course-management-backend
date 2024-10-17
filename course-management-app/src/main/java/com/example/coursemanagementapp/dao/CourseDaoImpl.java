package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.coursemanagementapp.dao.repo.CourseRepo;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private final CourseRepo courseRepo;

    @Override
    public CourseRepo getRepo() {
        return courseRepo;
    }

    //TODO: Implement this method
    @Override
    public Page<Course> findAllPaginatedAndFiltered(PaginationRequest<CourseSearchDto> paginationRequest) {
        CourseSearchDto criteria = paginationRequest.getCriteria();
        Boolean markedAsDeleted = paginationRequest.getDeletedRecords();
        if (criteria == null)
            return getRepo().findAllByMarkedAsDeleted(getPageRequest(paginationRequest), markedAsDeleted);

//        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria, markedAsDeleted);
        return null;
    }

    @Override
    public void updateCourseStatus(Long id, Long statusId) {
        log.info("CourseDao: updateCourseStatus() - was called with id: {} and statusId: {}", id, statusId);
        getRepo().updateCourseStatus(id, statusId);
    }
}
