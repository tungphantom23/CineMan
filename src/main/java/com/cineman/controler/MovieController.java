package com.cineman.controler;

import com.cineman.model.Movie;
import com.cineman.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping({"/", "/movies/search"})
    public String search(@RequestParam(required = false) String keyword, Model model) {
        List<Movie> movies = movieService.searchByTitle(keyword);
        model.addAttribute("movies", movies);
        model.addAttribute("keyword", keyword);
        return "search"; // /WEB-INF/jsp/search.jsp
    }

    @GetMapping("/movies/detail")
    public String detail(@RequestParam Integer id, Model model) {
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "movieDetail";
    }
}
