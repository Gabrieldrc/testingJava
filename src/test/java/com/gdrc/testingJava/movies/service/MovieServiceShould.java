package com.gdrc.testingJava.movies.service;

import com.gdrc.testingJava.movies.data.MovieRepository;
import com.gdrc.testingJava.movies.model.Genre;
import com.gdrc.testingJava.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    private MovieService movieService;
    @Before
    public void setUp() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Pelicula 1", 60, Genre.ACTION),
                        new Movie(2, "Pelicula 2", 120, Genre.COMEDY),
                        new Movie(3, "Pelicula 3", 100, Genre.DRAMA),
                        new Movie(4, "Pelicula 4", 104, Genre.HORROR),
                        new Movie(5, "Pelicula 5", 60, Genre.ACTION),
                        new Movie(6, "Pelicula 6", 120, Genre.COMEDY),
                        new Movie(7, "Pelicula 7", 100, Genre.DRAMA),
                        new Movie(8, "Pelicula 8", 104, Genre.HORROR)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {


        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertEquals(Arrays.asList(2, 6), getMovieIds(movies));
    }

    @Test
    public void return_movies_by_duration() {
        Collection<Movie> movies = movieService.findMoviesByDuration(100);

        assertEquals(Arrays.asList(1, 3, 5, 7), getMovieIds(movies));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
    }
}