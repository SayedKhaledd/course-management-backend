package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourseDto extends AbstractDto {
    private Long id;
    private String name;
    private String description;
    private String code;
    private String part;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private CourseStatusDto courseStatus;
    private Long courseStatusId;

}
