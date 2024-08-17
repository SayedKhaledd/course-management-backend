package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReferralSourceDto extends AbstractDto {
    private Long id;
    private com.example.coursemanagementapp.enums.ReferralSource source;

}
