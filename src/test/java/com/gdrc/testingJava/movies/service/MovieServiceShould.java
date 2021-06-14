package com.gdrc.testingJava.movies.service;

import com.gdrc.testingJava.movies.data.MovieRepository;
import com.gdrc.testingJava.movies.model.Genre;
import com.gdrc.testingJava.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    @Test
    public void return_movies_by_genre() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Pelicula 1", 60, Genre.ACTION),
                        new Movie(2, "Pelicula 2", 60, Genre.COMEDY),
                        new Movie(3, "Pelicula 3", 60, Genre.DRAMA),
                        new Movie(4, "Pelicula 4", 60, Genre.HORROR),
                        new Movie(5, "Pelicula 5", 60, Genre.ACTION),
                        new Movie(6, "Pelicula 6", 60, Genre.COMEDY),
                        new Movie(7, "Pelicula 7", 60, Genre.DRAMA),
                        new Movie(8, "Pelicula 8", 60, Genre.HORROR)
                        )
        );
        MovieService movieService = new MovieService(movieRepository);

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        List<Integer> movieIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        assertEquals(Arrays.asList(2, 6), movieIds);
    }
}