package org.springexample.client;

import java.util.ArrayList;
import java.util.List;

import org.springexample.service.MovieService;
import org.springexamples.bean.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieDbClient {

	public static void main(String[] args) {
		//<!-- Spring Database access using HibernateTemplate -->
		
		//Step-1:Register Spring bean configuration.
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
		
		//Step-2: getting object of movie service class
		MovieService movieService=applicationContext.getBean("movieService",MovieService.class);
		
		//Step-3: creating the raw records of Movie.
		List<Movie> movieList=new ArrayList<Movie>();
		
		Movie movie1=new Movie();
		movie1.setTitle("Bahubali");
		movie1.setReleaseYear(2015);
		movie1.setDirector("S.S.Rajamouli");
		
		Movie movie2=new Movie();
		movie2.setTitle("Welcome Back");
		movie2.setReleaseYear(2015);
		movie2.setDirector("Anees Bazmee");
		
		Movie movie3=new Movie();
		movie3.setTitle("Drishyam");
		movie3.setReleaseYear(2015);
		movie3.setDirector("Nishikant Kamat");
		
		Movie movie4=new Movie();
		movie4.setTitle("Fan");
		movie4.setReleaseYear(2016);
		movie4.setDirector("Maneesh Sharma");
		
		Movie movie5=new Movie();
		movie5.setTitle("Housefull 3");
		movie5.setReleaseYear(2016);
		movie5.setDirector("Sajid Farhad");
		
		movieList.add(movie1);
		movieList.add(movie2);
		movieList.add(movie3);
		movieList.add(movie4);
		movieList.add(movie5);
		
		//Step-4:Inserting movie records to the database.
		/*for(Movie movie:movieList){
			movieService.addMovieRecord(movie);
		}*/
		
		//Step-6:Update the movie record to the database.
		/*Movie movie6=new Movie();
		movie6.setMovieid(5);
		movie6.setTitle("Housefull_3");
		movie6.setReleaseYear(2016);
		movie6.setDirector("Sajid Farhad");
		
		movieService.updateMovieRecord(movie6);*/
		
		//Step-7:Delete movie record from database.
		/*Movie movie7=new Movie();
		movie7.setMovieid(3);
		
		movieService.deleteMovieRecord(movie7);*/
		
		//Step-5:fetching movie records from the database.
		movieService.displayMovieRecord();
		
	}

}
