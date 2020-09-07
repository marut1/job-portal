package com.tropogo.jobportal.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company extends AuditModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID id;

    @NotNull
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    public Company() {
    }

    public Company(UUID id, @NotNull @Size(max = 50) String name) {
        this.id = id;
        this.name = name;
    }
}
