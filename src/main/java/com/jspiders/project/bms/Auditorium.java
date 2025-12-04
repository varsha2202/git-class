package com.jspiders.project.bms;

import com.jspiders.project.bms.Main.Shows;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auditorium")
public class Auditorium  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "audi_name",nullable = false)
    private String audiName;

    @Column(name = "seat_rows",nullable = false)
    private Integer seatRows;

    @Column(name = "seat_columns",nullable = false)
    private Integer seatColumns;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id" , referencedColumnName = "id")
    private AudiAddress audiAddress;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "audi_id")
    private List<Shows> shows = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAudiName() {
        return audiName;
    }

    public void setAudiName(String audiName) {
        this.audiName = audiName;
    }

    public Integer getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(Integer seatRows) {
        this.seatRows = seatRows;
    }

    public Integer getSeatColumns() {
        return seatColumns;
    }

    public void setSeatColumns(Integer seatColumns) {
        this.seatColumns = seatColumns;
    }

    public AudiAddress getAudiAddress() {
        return audiAddress;
    }

    public void setAudiAddress(AudiAddress audiAddress) {
        this.audiAddress = audiAddress;
    }

    public List<Shows> getShows() {
        return shows;
    }

    public void setShows(List<Shows> shows) {
        this.shows = shows;
    }
}
