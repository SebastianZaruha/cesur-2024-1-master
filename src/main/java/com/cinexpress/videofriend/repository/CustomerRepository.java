package com.cinexpress.videofriend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT m FROM Movie m WHERE m.customer.id = :customerId")
    List<Movie> findMoviesByCustomerId(@Param("customerId") Long customerId);

}
