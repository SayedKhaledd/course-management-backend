package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true, builderMethodName = "InstallmentHistoryDtoBuilder")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InstallmentHistoryDto extends AbstractDto {
    private Long id;
    private InstallmentDto installment;
    private Long installmentId;
    private String fieldName;
    private String oldValue;
    private String newValue;

}
