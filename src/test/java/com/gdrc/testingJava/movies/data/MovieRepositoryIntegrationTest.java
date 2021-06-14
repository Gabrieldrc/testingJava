package com.gdrc.testingJava.movies.data;

import com.gdrc.testingJava.movies.model.Genre;
import com.gdrc.testingJava.movies.model.Movie;
import org.junit.Test;
import org.springframework.core.io.PathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    @Test
    public void load_all_movies() throws SQLException {
        //Realizo la conexion
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/tests",
                "gabriel",
                "123654"
        );
        //Ejecutamos el script que esta en resource para que cree
        //la tabla y las peliculas
        ScriptUtils.executeSqlScript(
                dataSource.getConnection(),
                new PathResource("src/test/resources/sql-scripts/test-data.sql")
        );
        // Creo mi jdbcTemplate para darcelo al MovieRepository
        // para que se conecte a la base de datos
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        MovieRepositoryJdbc movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
        //Recupero las peliculas
        Collection<Movie> movies = movieRepository.findAll();
        //Compruebo que las peliculas obtenidas sean las correctas
        assertEquals(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Mmento", 113, Genre.THRILLER),
                        new Movie(3, "Matrix", 136, Genre.ACTION)
                ),
                movies
        );
    }
}