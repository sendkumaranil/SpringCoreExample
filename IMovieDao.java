package org.springexamples.dao;

import java.util.List;

import org.springexamples.bean.Movie;

public interface IMovieDao {
	public void addMovie(Movie movie);
	public void updateMovie(Movie movie);
	public void deleteMovie(Movie movie);
	public List<Movie> fetchMovie();
}
