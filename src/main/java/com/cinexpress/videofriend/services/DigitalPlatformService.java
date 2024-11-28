package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Movie;

public interface DigitalPlatformService {
    List<Movie> searchMovies();

    Movie streamingMovie();

    List<Movie> searchMovies(Company company);
    // managementDownload()
    // liveChat()
}
