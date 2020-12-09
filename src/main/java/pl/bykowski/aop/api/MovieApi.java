package pl.bykowski.aop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.bykowski.aop.aspect.SendEmailAspect;
import pl.bykowski.aop.model.Movie;
import pl.bykowski.aop.service.MovieService;


import java.util.List;

@RestController
public class MovieApi {

    private MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getMovies() {
        if (movieService.getAllMovies().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @SendEmailAspect
    @PostMapping("/")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
