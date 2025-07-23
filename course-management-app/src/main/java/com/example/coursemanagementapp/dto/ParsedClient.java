package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import com.opencsv.bean.CsvBindByName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Data
public class ParsedClient extends AbstractDto {
    @CsvBindByName(column = "Name", required = true)
    private String name;

    @CsvBindByName(column = "Email")
    private String email;

    @CsvBindByName(column = "Phone", required = true)
    @NotBlank(message = "Phone number is required")
    private String phone;

    @CsvBindByName(column = "Alternative Phone")
    private String alternativePhone;

    @CsvBindByName(column = "Country")
    private String country;

    @CsvBindByName(column = "Nationality")
    private String nationality;

    @CsvBindByName(column = "Address")
    private String address;

    @CsvBindByName(column = "Initial Course", required = true)
    @NotBlank(message = "Initial course is required")
    private String initialCourse;

    @CsvBindByName(column = "Client Status")
    private String status;

    @CsvBindByName(column = "Referral Source")
    private String referralSource;

    @CsvBindByName(column = "Description")
    private String description;

    @CsvBindByName(column = "Specialty")
    private String specialty;

    private Map<String, String> errors;
    private boolean valid = true;


    public Map<String, String> getErrors() {
        if (errors == null) {
            errors = new HashMap<>();
        }
        return errors;
    }


}
