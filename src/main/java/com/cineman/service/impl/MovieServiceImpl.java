package com.cineman.service.impl;

import com.cineman.dao.MovieDAO;
import com.cineman.model.Movie;
import com.cineman.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieDAO movieRepository;

    public MovieServiceImpl(MovieDAO movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> searchByTitle(String keyword) {
        if (keyword == null || keyword.isBlank()) return movieRepository.findAll();
        return movieRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }
}
