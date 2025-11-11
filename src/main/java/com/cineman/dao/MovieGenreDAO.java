package com.cineman.dao;

import com.cineman.model.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGenreDAO extends JpaRepository<MovieGenre, Integer> {
}
