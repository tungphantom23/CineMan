package com.cineman.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tblCinemaRooms")
public class CinemaRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String roomName;

    private Integer capacity;

    @Column(length = 50)
    private String status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getRoomName() { return roomName; }
    public void setRoomName(String roomName) { this.roomName = roomName; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
