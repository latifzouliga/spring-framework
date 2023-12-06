package com.cydeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(value = {"latitude","longitude"}, ignoreUnknown = true)
public class Location extends BaseEntity{

    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String address;



}
