package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import com.example.coursemanagementapp.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "UserDtoBuilder")
@Data
public class UserDto extends AbstractDto {
    private Long id;
    @NotBlank(message = "First name is mandatory", groups = {Create.class, UpdateFirstName.class})
    private String firstName;
    @NotBlank(message = "Last name is mandatory", groups = {Create.class, UpdateLastName.class})
    private String lastName;
    @NotBlank(message = "Email is mandatory", groups = {Create.class, UpdateEmail.class})
    private String email;
    @NotBlank(message = "Phone number is mandatory", groups = {Create.class, UpdatePhoneNumber.class})
    private String phoneNumber;
    @NotNull(message = "Role is mandatory", groups = {UpdateRole.class, Create.class})
    private Role role;
    @NotBlank(message = "Password is mandatory", groups = Create.class)
    private String password;
    private String keycloakId;

    public interface Create {
    }

    public interface UpdateRole {
    }

    public interface UpdateFirstName {
    }

    public interface UpdateLastName {
    }

    public interface UpdateEmail {
    }

    public interface UpdatePhoneNumber {
    }
}
