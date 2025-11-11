package com.cineman.dao;

import com.cineman.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDAO extends JpaRepository<Movie, Integer> {
    List<Movie> findByTitleContainingIgnoreCase(String keyword);
}
