package com.rakateja.model.entity;

import javax.persistence.*;

/**
 * Created by rakateja on 8/24/15.
 *
 * Country class
 * @author Raka Teja
 */

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 2)
    private String iso2;

    @Column(length = 3)
    private String iso3;

    @Column(length = 100, nullable = false)
    private String title;

    public Country(){}

    public Country(String title){
        this.setTitle(title);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
