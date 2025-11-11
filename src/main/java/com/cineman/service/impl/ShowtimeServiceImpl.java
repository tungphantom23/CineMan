package com.cineman.service.impl;

import com.cineman.dao.CinemaRoomDAO;
import com.cineman.dao.MovieDAO;
import com.cineman.dao.ShowtimeDAO;
import com.cineman.model.CinemaRoom;
import com.cineman.model.Movie;
import com.cineman.model.Showtime;
import com.cineman.service.ShowtimeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    private final CinemaRoomDAO roomRepo;
    private final ShowtimeDAO showtimeRepo;
    private final MovieDAO movieRepo;

    public ShowtimeServiceImpl(CinemaRoomDAO roomRepo, ShowtimeDAO showtimeRepo, MovieDAO movieRepo) {
        this.roomRepo = roomRepo;
        this.showtimeRepo = showtimeRepo;
        this.movieRepo = movieRepo;
    }

    @Override
    public List<CinemaRoom> findAvailableRooms(LocalDate date, LocalTime start, LocalTime end) {
        List<CinemaRoom> all = roomRepo.findAll();
        List<CinemaRoom> available = new ArrayList<>();
        for (CinemaRoom r : all) {
            List<Showtime> shows = showtimeRepo.findByRoomIdAndShowDate(r.getId(), date);
            boolean ok = true;
            for (Showtime s : shows) {
                // check overlap
                if (!(end.isBefore(s.getStartTime()) || start.isAfter(s.getEndTime()))) {
                    ok = false; break;
                }
            }
            if (ok) available.add(r);
        }
        return available;
    }

    @Override
    public Showtime createShowtime(LocalDate date, LocalTime start, LocalTime end, Integer roomId, Integer movieId, java.math.BigDecimal price) {
        CinemaRoom room = roomRepo.findById(roomId).orElse(null);
        Movie movie = movieRepo.findById(movieId).orElse(null);
        if (room == null || movie == null) return null;
        // check availability
        List<Showtime> shows = showtimeRepo.findByRoomIdAndShowDate(roomId, date);
        for (Showtime s : shows) {
            if (!(end.isBefore(s.getStartTime()) || start.isAfter(s.getEndTime()))) {
                return null; // conflict
            }
        }
        Showtime st = new Showtime();
        st.setShowDate(date);
        st.setStartTime(start);
        st.setEndTime(end);
        st.setRoom(room);
        st.setMovie(movie);
        st.setBaseTicketPrice(price);
        return showtimeRepo.save(st);
    }

    @Override
    public List<Showtime> findByRoomAndDate(Integer roomId, LocalDate date) {
        return showtimeRepo.findByRoomIdAndShowDate(roomId, date);
    }
}
