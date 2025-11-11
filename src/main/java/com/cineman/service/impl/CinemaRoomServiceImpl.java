package com.cineman.service.impl;

import com.cineman.dao.CinemaRoomDAO;
import com.cineman.model.CinemaRoom;
import com.cineman.service.CinemaRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaRoomServiceImpl implements CinemaRoomService {
    private final CinemaRoomDAO cinemaRoomDAO;

    public CinemaRoomServiceImpl(CinemaRoomDAO cinemaRoomDAO) {
        this.cinemaRoomDAO = cinemaRoomDAO;
    }

    @Override
    public List<CinemaRoom> findAll() {
        return cinemaRoomDAO.findAll();
    }

    @Override
    public CinemaRoom findById(Integer id) {
        return cinemaRoomDAO.findById(id).orElse(null);
    }

    @Override
    public CinemaRoom save(CinemaRoom room) {
        return cinemaRoomDAO.save(room);
    }

    @Override
    public void deleteById(Integer id) {
        cinemaRoomDAO.deleteById(id);
    }
}
