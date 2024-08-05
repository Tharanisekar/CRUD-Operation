package com.example.theatre_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theatre_system.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
