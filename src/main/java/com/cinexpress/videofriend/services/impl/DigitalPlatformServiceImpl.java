package com.cinexpress.videofriend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.DigitalPlatformRepository;
import com.cinexpress.videofriend.services.DigitalPlatformService;

@Service
public class DigitalPlatformServiceImpl implements DigitalPlatformService{

    @Autowired
    DigitalPlatformRepository digitalPlatformRepository;

@Override
public List<Movie> searchMovies(Company company) {
    return digitalPlatformRepository.findByCompany(company);
}

    @Override
    public Movie streamingMovie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'streamingMovie'");
    }

    @Override
    public List<Movie> searchMovies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchMovies'");
    }
    
}
