package com.example.theatre_system.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.theatre_system.model.Movie;
import com.example.theatre_system.service.MovieService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class HomeController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public String homepage() {
	return "index";
	}
	
	@GetMapping("/movie/view")
	public String viewPage(Model model) {
		model.addAttribute("allMovies", movieService.showAllMovies());
		return "movie-view";
	}
	
	@GetMapping("/movie/add")
	public String addMoviePage(Model model) {
		model.addAttribute("obj", new Movie());
		return "movie-add";
	}
	@PostMapping("/movie/add")
		public String addMovie(@ModelAttribute("obj") Movie movie) 
	{
		Optional<Movie> opt= movieService.searchMovie(movie.getMovieId()) ;
		if(opt.isEmpty()) 
		{
			movieService.addNewMovie(movie);
			return "redirect:/movie/view";
			//return "redirect:/movie/view?success";
		}
		else
		{
			return "redirect:/movie/add?failed";
		}
	}
		
		@GetMapping("/movie/edit/{id}")
		public String editPage(@PathVariable("id")int movieId,Model model)
		{
			model.addAttribute("obj",movieService.searchMovie(movieId));
			return "movie-edit";
		}

	@PostMapping("/movie/edit")
	public String updateMovieDetails(@ModelAttribute("obj") Movie updateMovie) 
	{
		movieService.addNewMovie(updateMovie);
		return "redirect:/movie/view";
	}
	
	@GetMapping("/movie/delete/{id}")
	public String deleteMovie(@PathVariable("id") int movieId) 
	{
		movieService.deleteMovie(movieId);
		return "redirect:/movie/view";
	}
}
