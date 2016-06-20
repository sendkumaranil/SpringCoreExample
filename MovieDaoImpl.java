package org.springexamples.daoImpl;

import java.util.List;

import org.springexamples.bean.Movie;
import org.springexamples.dao.IMovieDao;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class MovieDaoImpl implements IMovieDao {
	HibernateTemplate myhibernateTemplate;

	@Override
	public void addMovie(Movie movie) {
		myhibernateTemplate.save(movie);
	}

	@Override
	public void updateMovie(Movie movie) {
		myhibernateTemplate.update(movie);
	}

	@Override
	public void deleteMovie(Movie movie) {
		myhibernateTemplate.delete(movie);
	}

	@Override
	public List<Movie> fetchMovie() {
		
		List<Movie> movieList=myhibernateTemplate.find("from Movie");
		return movieList;
	}

	public HibernateTemplate getMyhibernateTemplate() {
		return myhibernateTemplate;
	}

	public void setMyhibernateTemplate(HibernateTemplate myhibernateTemplate) {
		this.myhibernateTemplate = myhibernateTemplate;
	}
}
