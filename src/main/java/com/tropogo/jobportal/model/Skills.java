package com.tropogo.jobportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "skills")
@Getter
@Setter
public class Skills extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid2")
    @JsonIgnore
    private UUID id;

    @NotNull
    @Size(max = 50)
    @Column(name = "skill")
    private String skill;

    public Skills() {
    }

    public Skills(UUID id, @NotNull @Size(max = 50) String skill) {
        this.id = id;
        this.skill = skill;
    }
}
