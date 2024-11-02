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

    @NotBlank(message = "Name is mandatory", groups = {Create.class, UpdateName.class})
    private String name;

    @NotBlank(message = "Email is mandatory", groups = {UpdateEmail.class})
    private String email;

    @NotBlank(message = "Phone is mandatory", groups = {Create.class, UpdatePhone.class})
    private String phone;

    @NotBlank(message = "Initial course name is mandatory", groups = {Create.class, UpdateInitialCourseName.class})
    private String initialCourseName;

    @NotBlank(message = "Alternative phone is mandatory", groups = {UpdateAlternativePhone.class})
    private String alternativePhone;

    @NotBlank(message = "Country is mandatory", groups = {UpdateCountry.class})
    private String country;

    @NotBlank(message = "Nationality is mandatory", groups = {UpdateNationality.class})
    private String nationality;

    @NotBlank(message = "Address is mandatory", groups = {UpdateAddress.class})
    private String address;

    private ClientStatusDto clientStatus;
    private Long clientStatusId;

    @NotBlank(message = "Specialty is mandatory", groups = {UpdateSpecialty.class})
    private String specialty;

    private ReferralSourceDto referralSource;
    private Long referralSourceId;

    @NotBlank(message = "Description is mandatory", groups = {UpdateDescription.class})
    private String description;

    public interface Create {
    }

    public interface UpdateDescription {
    }

    public interface UpdateEmail {
    }

    public interface UpdatePhone {

    }

    public interface UpdateAlternativePhone {

    }

    public interface UpdateCountry {

    }

    public interface UpdateNationality {

    }

    public interface UpdateAddress {

    }

    public interface UpdateSpecialty {

    }


    public interface Update {

    }

    public interface UpdateName {

    }

    public interface UpdateInitialCourseName {

    }


}
