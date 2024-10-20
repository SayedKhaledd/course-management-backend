package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true, builderMethodName = "RefundHistoryDtoBuilder")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RefundHistoryDto extends AbstractDto {
    private Long id;
    private RefundDto refund;
    private Long refundId;
    private String fieldName;
    private String oldValue;
    private String newValue;


}
