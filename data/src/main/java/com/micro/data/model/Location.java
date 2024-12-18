package com.micro.data.model;

import jakarta.persistence.*;
import lombok.Data;

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
