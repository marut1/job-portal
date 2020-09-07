package com.tropogo.jobportal.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Location extends AuditModel {

    public Location() {
    }

    public Location(UUID id, @NotNull @Size(max = 100) String addressLine,
                    @NotNull @Size(max = 50) String city, @NotNull @Size(max = 50) String state,
                    @NotNull @Size(max = 50) String country, @NotNull @Size(max = 50) String zip) {
        this.id = id;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid2")
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Size(max = 100)
    @Column(name = "address_line")
    private String addressLine;

    @NotNull
    @Size(max = 50)
    @Column(name = "city")
    private String city;

    @NotNull
    @Size(max = 50)
    @Column(name = "state")
    private String state;

    @NotNull
    @Size(max = 50)
    @Column(name = "country")
    private String country;

    @NotNull
    @Size(max = 50)
    @Column(name = "zip")
    private String zip;

}
