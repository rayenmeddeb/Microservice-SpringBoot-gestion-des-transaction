package com.micro.transaction.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "locations")
public class Location {
    @Id
    private Integer id;
    private String address;
    private String city;
    @Column(name = "zip_code")
    private Integer zipCode;
}
