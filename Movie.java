package com.example.theatre_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	private Integer movieId;
	private String name;
	private Character screen;
	private Integer shows;
	private String Distributor;
	private String releaseDate;
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getScreen() {
		return screen;
	}
	public void setScreen(Character screen) {
		this.screen = screen;
	}
	public Integer getShows() {
		return shows;
	}
	public void setShows(Integer shows) {	
		this.shows = shows;
	}
	public String getDistributor() {
		return Distributor;
	}
	public void setDistributor(String distributor) {
		Distributor = distributor;
		}
}
