package com.micro.data.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private Integer id;
    private String address;
    private String city;
    private Integer zipCode;
}
