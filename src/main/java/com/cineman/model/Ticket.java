package com.cineman.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblTickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime purchaseTime;

    private java.math.BigDecimal actualPrice;

    @Column(length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "showtimeID")
    private Showtime showtime;

    @ManyToOne
    @JoinColumn(name = "seatID")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "salespersonID")
    private Employee salesperson;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getPurchaseTime() { return purchaseTime; }
    public void setPurchaseTime(LocalDateTime purchaseTime) { this.purchaseTime = purchaseTime; }

    public java.math.BigDecimal getActualPrice() { return actualPrice; }
    public void setActualPrice(java.math.BigDecimal actualPrice) { this.actualPrice = actualPrice; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Showtime getShowtime() { return showtime; }
    public void setShowtime(Showtime showtime) { this.showtime = showtime; }

    public Seat getSeat() { return seat; }
    public void setSeat(Seat seat) { this.seat = seat; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Employee getSalesperson() { return salesperson; }
    public void setSalesperson(Employee salesperson) { this.salesperson = salesperson; }
}
