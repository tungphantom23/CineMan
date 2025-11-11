package com.cineman.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblMovies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String title;

    @Lob
    private String description;

    private Integer durationMinutes;

    @Column(length = 100)
    private String director;

    @Column(length = 255)
    private String cast;

    private LocalDate releaseDate;

    @Column(length = 255)
    private String trailerLink;

    @Column(length = 255)
    private String posterLink;

    @ManyToMany
    @JoinTable(name = "tblMovieGenres_tblMovies",
        joinColumns = @JoinColumn(name = "movieID"),
        inverseJoinColumns = @JoinColumn(name = "genreID"))
    private Set<MovieGenre> genres = new HashSet<>();

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getCast() { return cast; }
    public void setCast(String cast) { this.cast = cast; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }

    public String getTrailerLink() { return trailerLink; }
    public void setTrailerLink(String trailerLink) { this.trailerLink = trailerLink; }

    public String getPosterLink() { return posterLink; }
    public void setPosterLink(String posterLink) { this.posterLink = posterLink; }
}
