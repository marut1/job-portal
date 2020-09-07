package com.tropogo.jobportal.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class JobPostRequest {
    @JsonIgnore
    private UUID id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private int expStartYear;

    private int expEndYear;

    @NotBlank
    private Date validFrom;

    @NotBlank
    private Date validTill;

    @NotBlank
    private UUID locationId;

    @NotBlank
    private UUID userId;

    @NotBlank
    private UUID job_typeId;

    @NotBlank
    private UUID companyId;

    public JobPostRequest(UUID id, @NotBlank String title, @NotBlank String description,
                          int expStartYear, int expEndYear, @NotBlank Date validFrom,
                          @NotBlank Date validTill, @NotBlank UUID locationId, @NotBlank UUID userId,
                          @NotBlank UUID job_typeId, @NotBlank UUID companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.expStartYear = expStartYear;
        this.expEndYear = expEndYear;
        this.validFrom = validFrom;
        this.validTill = validTill;
        this.locationId = locationId;
        this.userId = userId;
        this.job_typeId = job_typeId;
        this.companyId = companyId;
    }
}
