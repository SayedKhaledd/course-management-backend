package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "ActionTakenDtoBuilder")
@Data
public class ActionTakenDto extends AbstractDto {
    private Long id;
    private com.example.coursemanagementapp.enums.ActionTaken action;


}
