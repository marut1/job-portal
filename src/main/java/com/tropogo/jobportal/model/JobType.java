package com.tropogo.jobportal.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "job_type")
@Getter
@Setter
public class JobType extends AuditModel {
    public JobType() {
    }

    public JobType(UUID id, @NotNull @Size(max = 50) String type) {
        this.id = id;
        this.type = type;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid2")
    private UUID id;

    @NotNull
    @Size(max = 50)
    @Column(name = "type")
    private String type;

}
