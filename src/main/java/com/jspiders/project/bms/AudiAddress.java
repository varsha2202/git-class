package com.jspiders.project.bms;

import jakarta.persistence.*;

@Entity
@Table(name = "audi_adress")
public class AudiAddress
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street",nullable = false)
    private String street;

    @Column(name = "area",nullable = false)
    private String area;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "pincode")
    private Integer pincode;

    @OneToOne(mappedBy = "audiAddress")
    private Auditorium auditorium;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
