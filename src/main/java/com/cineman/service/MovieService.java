package com.cineman.service;

import com.cineman.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> searchByTitle(String keyword);
    Movie findById(Integer id);
    Movie save(Movie movie);
    void deleteById(Integer id);
}
