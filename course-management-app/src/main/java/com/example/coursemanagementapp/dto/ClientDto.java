package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClientDto extends AbstractDto {
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String email;
    @NotBlank(message = "Phone is mandatory")
    private String phone;
    private String alternatePhone;
    private String country;
    private String nationality;
    private String address;
    private ClientStatusDto clientStatus;
    private Long clientStatusId;
    private String specialty;
    private ReferralSourceDto referralSource;
    private Long referralSourceId;
    private String description;


}
