package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto extends AbstractDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
