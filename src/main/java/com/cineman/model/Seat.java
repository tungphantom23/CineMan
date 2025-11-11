package com.cineman.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tblSeats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 5)
    private String rowNumber;

    private Integer seatNumber;

    @Column(length = 50)
    private String seatType;

    @ManyToOne
    @JoinColumn(name = "roomID")
    private CinemaRoom room;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getRowNumber() { return rowNumber; }
    public void setRowNumber(String rowNumber) { this.rowNumber = rowNumber; }

    public Integer getSeatNumber() { return seatNumber; }
    public void setSeatNumber(Integer seatNumber) { this.seatNumber = seatNumber; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }

    public CinemaRoom getRoom() { return room; }
    public void setRoom(CinemaRoom room) { this.room = room; }
}
