package com.example.coursemanagementapp.dto.search;

import lombok.Data;

import java.util.Set;

@Data
public class ClientSearchDto {
    private String name;
    private String email;
    private String phone;
    private String alternativePhone;
    private Set<Long> clientStatusIds;
    private Set<String> countries;
    private Set<String> nationalities;
    private Set<Long> referralSourceIds;
    private Set<Long> initialCourseIds;
    private String specialty;
    private String address;
    private String description;
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;


    public Set<String> getCountries() {
        if (countries == null || countries.isEmpty())
            return null;
        return countries;
    }

    public Set<String> getNationalities() {
        if (nationalities == null || nationalities.isEmpty())
            return null;
        return nationalities;
    }

    public Set<Long> getClientStatusIds() {
        if (clientStatusIds == null || clientStatusIds.isEmpty())
            return null;
        return clientStatusIds;
    }

    public Set<Long> getReferralSourceIds() {
        if (referralSourceIds == null || referralSourceIds.isEmpty())
            return null;
        return referralSourceIds;
    }

    public Set<Long> getInitialCourseIds() {
        if (initialCourseIds == null || initialCourseIds.isEmpty())
            return null;
        return initialCourseIds;
    }


}
