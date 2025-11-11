package com.cineman.dao;

import com.cineman.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowtimeDAO extends JpaRepository<Showtime, Integer> {
    List<Showtime> findByRoomIdAndShowDate(Integer roomId, LocalDate showDate);
}
