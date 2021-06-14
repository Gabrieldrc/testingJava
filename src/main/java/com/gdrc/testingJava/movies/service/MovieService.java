package com.gdrc.testingJava.movies.service;

import com.gdrc.testingJava.movies.data.MovieRepository;
import com.gdrc.testingJava.movies.model.Genre;
import com.gdrc.testingJava.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }
}
