package pl.bykowski.aop.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.bykowski.aop.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private List<Movie> movies;

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void init() {
        movies = new ArrayList<>();
        movies.add(new Movie("Star Wars 1","Lucas", 2002));
        movies.add(new Movie("Star Wars 2","Lucas", 2003));
        movies.add(new Movie("Star Wars 3","Lucas", 2004));
        movies.add(new Movie("Star Wars 4","Lucas", 1992));
        movies.add(new Movie("Star Wars 5","Lucas", 1993));
        movies.add(new Movie("Star Wars 6","Lucas", 1994));
        movies.add(new Movie("Star Wars 7","Disney", 2016));
        movies.add(new Movie("Star Wars 8","Disney", 2017));
        movies.add(new Movie("Star Wars 9","Disney", 2018));
    }
}
