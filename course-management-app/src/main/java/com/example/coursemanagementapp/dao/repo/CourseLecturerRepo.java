package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.CourseLecturerSearchDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseLecturerRepo extends JpaRepository<CourseLecturer, Long> {

    List<CourseLecturer> findAllByCourseId(Long courseId);

    @Query("""
                SELECT cl
                FROM CourseLecturer cl
                WHERE
                     (:#{#criteria.paidInPercentage} IS NULL OR cl.paidInPercentage IN :#{#criteria.paidInPercentage})
                    AND (:#{#criteria.name} IS NULL OR cl.name = :#{#criteria.name})
                    AND (:#{#criteria.courseId} IS NULL OR cl.courseId = :#{#criteria.courseId})
                    AND (:#{#criteria.percentage} IS NULL OR cl.percentage = :#{#criteria.percentage})
                    AND (:#{#criteria.totalPercentageCost} IS NULL OR cl.totalPercentageCost = :#{#criteria.totalPercentageCost})
                    AND (:#{#criteria.noOfLectures} IS NULL OR cl.noOfLectures = :#{#criteria.noOfLectures})
                    AND (:#{#criteria.lectureCost} IS NULL OR cl.lectureCost = :#{#criteria.lectureCost})
                    AND (:#{#criteria.totalFixedCost} IS NULL OR cl.totalFixedCost = :#{#criteria.totalFixedCost})
                    AND (:#{#criteria.createdBy} IS NULL OR cl.createdBy LIKE CONCAT('%', :#{#criteria.createdBy}, '%'))
                    AND (:#{#criteria.modifiedBy} IS NULL OR cl.modifiedBy LIKE CONCAT('%', :#{#criteria.modifiedBy}, '%'))
                    AND (:#{#criteria.createdDate} IS NULL OR CAST(cl.createdDate AS string) LIKE CONCAT('%', :#{#criteria.createdDate}, '%'))
                    AND (:#{#criteria.modifiedDate} IS NULL OR CAST(cl.modifiedDate AS string) LIKE CONCAT('%', :#{#criteria.modifiedDate}, '%'))
            """)
    Page<CourseLecturer> findAllFilteredAndPaginated(Pageable pageable, CourseLecturerSearchDto criteria);


}
