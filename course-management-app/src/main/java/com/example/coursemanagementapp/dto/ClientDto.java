package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "ClientDtoBuilder")
@Data
public class ClientDto extends AbstractDto {
    private Long id;
    @NotBlank(message = "Name is mandatory", groups = {Create.class})
    private String name;
    private String email;
    @NotBlank(message = "Phone is mandatory", groups = {Create.class})
    private String phone;
    private String alternativePhone;
    private String country;
    private String nationality;
    private String address;
    private ClientStatusDto clientStatus;
    private Long clientStatusId;
    private String specialty;
    private ReferralSourceDto referralSource;
    private Long referralSourceId;
    @NotBlank(message = "Description is mandatory", groups = {UpdateDescription.class})
    private String description;

    public interface Create {
    }

    public interface UpdateDescription {
    }

    public interface UpdatePhone {

    }

    public interface UpdateAlternativePhone {

    }

    public interface UpdateStatus {
    }

    public interface Update {

    }


}
