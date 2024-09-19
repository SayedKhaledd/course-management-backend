package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "UserDtoBuilder")
@Data
public class UserDto extends AbstractDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
