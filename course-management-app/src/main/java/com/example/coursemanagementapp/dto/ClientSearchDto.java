package com.example.coursemanagementapp.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ClientSearchDto {
    private String name;
    private String email;
    private String phone;
    private Set<Long> clientStatusIds;
    private Set<String> countries;
    private Set<String> nationalities;
    private Set<Long> referralSourceIds;
    private String specialty;


    public Set<String> getCountries() {
        if (countries == null || countries.isEmpty())
            return null;
        return countries;
    }


}
