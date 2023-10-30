package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Cinema extends BaseEntity{
    private String name;
    private String sponsoredName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

}
