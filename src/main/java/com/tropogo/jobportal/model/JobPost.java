package com.tropogo.jobportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "job_post")
@Getter
@Setter
public class JobPost extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid2")
    @JsonIgnore
    private UUID id;

    @NotNull
    @Size(max = 50)
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(max = 20000)
    @Column(name = "description")
    private String description;

    @Column(name = "exp_start_year")
    private int expStartYear;

    @Column(name = "exp_end_year")
    private int expEndYear;

    @Column(name = "valid_from")
    private Date validFrom;

    @Column(name = "valid_till")
    private Date validTill;

    @Column(name= "user_id", nullable = true)
    private UUID userId;

    @Column(name = "location_id",nullable = true)
    private UUID locationId;

    @Column(name = "job_type_id", nullable = true)
    private UUID jobTypeId;

    @Column(name = "company_id", nullable = true)
    private UUID companyId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName="id",updatable=false, insertable = false)
    private UserAccount user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",referencedColumnName="id", updatable=false, insertable = false)
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Skills> skills;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_type_id",referencedColumnName="id", updatable=false, insertable = false)
    private JobType jobType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id",referencedColumnName="id", updatable=false, insertable = false)
    private Location location;

    public JobPost() {
    }

    public JobPost(UUID id, @NotNull @Size(max = 50) String title,
                   @NotNull @Size(max = 20000) String description,
                   int expStartYear, int expEndYear, Date validFrom, Date validTill,
                   UUID userId, UUID locationId, UUID jobTypeId, UUID companyId,
                   UserAccount user, Company company, List<Skills> skills, JobType jobType,
                   Location location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.expStartYear = expStartYear;
        this.expEndYear = expEndYear;
        this.validFrom = validFrom;
        this.validTill = validTill;
        this.userId = userId;
        this.locationId = locationId;
        this.jobTypeId = jobTypeId;
        this.companyId = companyId;
        this.user = user;
        this.company = company;
        this.skills = skills;
        this.jobType = jobType;
        this.location = location;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public UUID getJobTypeId() {
        return jobTypeId;
    }

    public UUID getCompanyId() {
        return companyId;
    }
}
