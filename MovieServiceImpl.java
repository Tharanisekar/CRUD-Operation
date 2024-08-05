package com.example.theatre_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theatre_system.model.Movie;
import com.example.theatre_system.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepo;

	@Override
	public List<Movie> showAllMovies() {
		
		return movieRepo.findAll();
	}

	@Override
	public Optional<Movie> searchMovie(int movieId) {
		
		return movieRepo.findById(movieId);
	}

	@Override
	public Movie addNewMovie(Movie newMovie) {
		
		return movieRepo.save(newMovie);
	}

	@Override
	public void deleteMovie(int movieId) {
		movieRepo.deleteById(movieId);
		
	}
	
	


}