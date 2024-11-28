package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Movie;

public interface MovieService {

    Movie addMovie(Movie movie);
    

    Movie updateMovie(Long id, Movie movie);

    Movie updateAvailability(Long id, Movie movie);

    List<Movie> getAllMovies();

    List<Movie> advancedSearch(String genre, String language, Integer year, String actor, String director);
    

}
