package org.springexample.service;

import java.util.List;

import org.springexamples.bean.Movie;
import org.springexamples.dao.IMovieDao;

public class MovieService {
	
	IMovieDao objMovieDao;
	
	public void addMovieRecord(Movie movie){
		objMovieDao.addMovie(movie);
	}
	
	public void updateMovieRecord(Movie movie){
		objMovieDao.updateMovie(movie);
	}
	
	public void deleteMovieRecord(Movie movie){
		objMovieDao.deleteMovie(movie);
	}
	
	public void displayMovieRecord(){
		List<Movie> movieList=objMovieDao.fetchMovie();
		int count=0;
		if(movieList !=null && !movieList.isEmpty()){
			for(Movie movie:movieList){
				System.out.println("------------------[Record "+(++count)+" ]------------------------");
				System.out.println("Movie Id:"+movie.getMovieid());
				System.out.println("Title:"+movie.getTitle());
				System.out.println("Release Year:"+movie.getReleaseYear());
				System.out.println("Director:"+movie.getDirector());
				System.out.println("------------------------------------------------------------------");
			}
		}else{
			System.out.println("---------No Record Found----------");
		}
	}

	public IMovieDao getObjMovieDao() {
		return objMovieDao;
	}

	public void setObjMovieDao(IMovieDao objMovieDao) {
		this.objMovieDao = objMovieDao;
	}
}
