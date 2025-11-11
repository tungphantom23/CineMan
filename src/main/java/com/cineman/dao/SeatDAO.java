package com.cineman.dao;

import com.cineman.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDAO extends JpaRepository<Seat, Integer> {
}
