package com.cineman.controler;

import com.cineman.model.CinemaRoom;
import com.cineman.model.Movie;
import com.cineman.service.CinemaRoomService;
import com.cineman.service.MovieService;
import com.cineman.dao.InvoiceDAO;
import com.cineman.dao.CustomerDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ManagerController {
    private final MovieService movieService;
    private final CinemaRoomService cinemaRoomService;
    private final InvoiceDAO invoiceDAO;
    private final CustomerDAO customerDAO;

    public ManagerController(MovieService movieService, CinemaRoomService cinemaRoomService, InvoiceDAO invoiceDAO, CustomerDAO customerDAO) {
        this.movieService = movieService;
        this.cinemaRoomService = cinemaRoomService;
        this.invoiceDAO = invoiceDAO;
        this.customerDAO = customerDAO;
    }

    @GetMapping("/manager/movies")
    public String listMovies(Model model) {
        List<Movie> movies = movieService.searchByTitle(null);
        model.addAttribute("movies", movies);
        return "managerMovieList";
    }

    @GetMapping("/manager/movies/create")
    public String createForm() { return "managerMovieForm"; }

    @PostMapping("/manager/movies/create")
    public String create(Movie movie) {
        movieService.save(movie);
        return "redirect:/manager/movies";
    }

    @GetMapping("/manager/movies/delete")
    public String delete(@RequestParam Integer id) {
        movieService.deleteById(id);
        return "redirect:/manager/movies";
    }

    // Rooms
    @GetMapping("/manager/rooms")
    public String listRooms(Model model) {
        model.addAttribute("rooms", cinemaRoomService.findAll());
        return "managerRoomList";
    }

    @GetMapping("/manager/rooms/create")
    public String createRoomForm(Model model) {
        model.addAttribute("room", new CinemaRoom());
        return "managerRoomForm";
    }

    @PostMapping("/manager/rooms/create")
    public String createRoom(CinemaRoom room) {
        cinemaRoomService.save(room);
        return "redirect:/manager/rooms";
    }

    @GetMapping("/manager/rooms/delete")
    public String deleteRoom(@RequestParam Integer id) {
        cinemaRoomService.deleteById(id);
        return "redirect:/manager/rooms";
    }

    // Statistics
    @GetMapping("/manager/stats")
    public String stats(Model model) {
        long movieCount = movieService.searchByTitle(null).size();
        long customerCount = customerDAO.count();
        java.math.BigDecimal totalRevenue = invoiceDAO.findAll().stream()
                .map(i -> i.getTotalAmount() == null ? java.math.BigDecimal.ZERO : i.getTotalAmount())
                .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);
        model.addAttribute("movieCount", movieCount);
        model.addAttribute("customerCount", customerCount);
        model.addAttribute("totalRevenue", totalRevenue);
        return "managerStatistics";
    }
}
