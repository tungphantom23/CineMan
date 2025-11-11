package com.cineman.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tblShowtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate showDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private java.math.BigDecimal baseTicketPrice;

    @ManyToOne
    @JoinColumn(name = "movieID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "roomID")
    private CinemaRoom room;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getShowDate() { return showDate; }
    public void setShowDate(LocalDate showDate) { this.showDate = showDate; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public java.math.BigDecimal getBaseTicketPrice() { return baseTicketPrice; }
    public void setBaseTicketPrice(java.math.BigDecimal baseTicketPrice) { this.baseTicketPrice = baseTicketPrice; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public CinemaRoom getRoom() { return room; }
    public void setRoom(CinemaRoom room) { this.room = room; }
}
