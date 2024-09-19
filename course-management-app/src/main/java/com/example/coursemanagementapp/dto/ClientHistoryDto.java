package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "ClientHistoryDtoBuilder")
@Data
public class ClientHistoryDto extends AbstractDto {
    private Long id;
    private ClientDto client;
    private Long clientId;
    private String fieldName;
    private String oldValue;
    private String newValue;

}
