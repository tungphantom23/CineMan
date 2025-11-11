package com.cineman.controler;

import com.cineman.model.Showtime;
import com.cineman.service.ShowtimeService;
import com.cineman.service.MovieService;
import com.cineman.service.CinemaRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class ShowtimeController {
    private final ShowtimeService showtimeService;
    private final MovieService movieService;
    private final CinemaRoomService cinemaRoomService;

    public ShowtimeController(ShowtimeService showtimeService, MovieService movieService, CinemaRoomService cinemaRoomService) {
        this.showtimeService = showtimeService;
        this.movieService = movieService;
        this.cinemaRoomService = cinemaRoomService;
    }

    @GetMapping("/showtimes/create")
    public String createForm() {
        return "schedule"; // schedule.jsp
    }

    @PostMapping("/showtimes/create")
    public String create(@RequestParam String showDate,
                         @RequestParam String startTime,
                         @RequestParam String endTime,
                         @RequestParam Integer roomId,
                         @RequestParam Integer movieId,
                         @RequestParam(required = false) Integer baseTicketPrice,
                         Model model) {
        // populate drop-downs for redisplay on error/success
        model.addAttribute("rooms", cinemaRoomService.findAll());
        model.addAttribute("movies", movieService.searchByTitle(null));
        LocalDate date = LocalDate.parse(showDate);
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        BigDecimal price = baseTicketPrice == null ? BigDecimal.ZERO : BigDecimal.valueOf(baseTicketPrice);
        Showtime s = showtimeService.createShowtime(date, start, end, roomId, movieId, price);
        if (s == null) {
            model.addAttribute("error", "Room is not available or invalid data");
            return "schedule";
        }
        model.addAttribute("message", "Tạo lịch chiếu thành công");
        return "schedule";
    }
}
