package com.gdrc.testingJava.movies.model;

public class Movie {
    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;

    public Movie(String name, int minutes, Genre genre) {
        this.id = null;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Movie(Integer id, String name, int minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }
}