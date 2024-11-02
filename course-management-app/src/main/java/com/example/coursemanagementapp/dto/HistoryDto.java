package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true, builderMethodName = "HistoryDtoBuilder")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistoryDto extends AbstractDto {
    private Long id;
    private Long entityId;
    private String entityType;
    private String fieldName;
    private String oldValue;
    private String newValue;

}
