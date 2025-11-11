package com.cineman.dao;

import com.cineman.model.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRoomDAO extends JpaRepository<CinemaRoom, Integer> {
}
