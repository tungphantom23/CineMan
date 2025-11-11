package com.cineman.service;

import com.cineman.model.CinemaRoom;
import com.cineman.model.Showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ShowtimeService {
    List<CinemaRoom> findAvailableRooms(LocalDate date, LocalTime start, LocalTime end);
    Showtime createShowtime(LocalDate date, LocalTime start, LocalTime end, Integer roomId, Integer movieId, java.math.BigDecimal price);
    List<Showtime> findByRoomAndDate(Integer roomId, LocalDate date);
}
