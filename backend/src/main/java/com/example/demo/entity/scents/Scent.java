package com.example.demo.entity.Scents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Scents")
public class Scent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scent_id")
    private Integer id;


    private String ScentName;

    private String ScentCategory;



    private String ScentDescription;
    
 
    



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScentName() {
        return ScentName;
    }

    public void setScentName(String ScentName) {
        this.ScentName = ScentName;
    }

    public String getScentCategory() {
        return ScentCategory;
    }

    public void setScentCategory(String ScentCategory) {
        this.ScentCategory = ScentCategory;
    }

    public String getScentDescription() {
        return ScentDescription;
    }

    public void setScentDescription(String ScentDescription) {
        this.ScentDescription = ScentDescription;
    }

    
}



  