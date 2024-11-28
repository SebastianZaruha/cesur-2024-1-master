package com.cinexpress.videofriend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE " +
            "(:genre IS NULL OR m.genre = :genre) AND " +
            "(:language IS NULL OR m.language = :language) AND " +
            "(:year IS NULL OR m.year = :year) AND " +
            "(:actor IS NULL OR :actor MEMBER OF m.actors) AND " +
            "(:director IS NULL OR m.director = :director)")
    List<Movie> findMoviesByFilters(
            @Param("genre") String genre,
            @Param("language") String language,
            @Param("year") Integer year,
            @Param("actor") String actor,
            @Param("director") String director);
}
