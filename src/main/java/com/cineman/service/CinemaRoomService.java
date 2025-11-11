package com.cineman.service;

import com.cineman.model.CinemaRoom;

import java.util.List;

public interface CinemaRoomService {
    List<CinemaRoom> findAll();
    CinemaRoom findById(Integer id);
    CinemaRoom save(CinemaRoom room);
    void deleteById(Integer id);
}
