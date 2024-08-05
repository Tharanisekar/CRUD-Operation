package com.example.theatre_system.service;

import java.util.List;
import java.util.Optional;

import com.example.theatre_system.model.Movie;
import com.example.theatre_system.repository.MovieRepository;

public interface MovieService {

	List<Movie> showAllMovies();

	Optional<Movie> searchMovie(int movieId);
	
	Movie addNewMovie(Movie newMovie);
	
	void deleteMovie(int movieId);

	
}
