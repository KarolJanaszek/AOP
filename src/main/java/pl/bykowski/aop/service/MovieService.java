package pl.bykowski.aop.service;

import pl.bykowski.aop.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    void addMovie(Movie movie);
}
