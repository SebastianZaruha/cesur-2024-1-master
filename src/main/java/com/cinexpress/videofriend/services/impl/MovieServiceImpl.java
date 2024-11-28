package com.cinexpress.videofriend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        return movieRepository.findById(id).map(existingMovie -> {
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setFormat(movie.getFormat());
            existingMovie.setGenre(movie.getGenre());
            existingMovie.setLanguage(movie.getLanguage());
            existingMovie.setAvailability(movie.getAvailability());
            return movieRepository.save(existingMovie);
        }).orElse(null);
    }

    @Override
    public Movie updateAvailability(Long id, Movie movie) {
        return movieRepository.findById(id).map(existingMovie -> {
            existingMovie.setAvailability(movie.getAvailability());
            return movieRepository.save(existingMovie);
        }).orElse(null);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> advancedSearch(String genre, String language, Integer year, String actor, String director) {
        return movieRepository.findMoviesByFilters(genre, language, year, actor, director);
    }

}
