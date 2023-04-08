/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.Lab3.jbdc;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user01
 */

@CrossOrigin
@RestController
@RequestMapping(path="/api")  
public class MovieController {
    
     private final MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    
    @GetMapping("")
    public String getStatus() {
        System.out.print("hi");
        return "Working";
        
    }
        
    
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
        
    }
    
    @PutMapping("/movies/{id}")
    public  List<Movie>  updateMovie(@RequestBody Movie NewMovie, @PathVariable("id") int id, HttpSession session) {
        String name = NewMovie.getName();
        int year = NewMovie.getYear();
        float rank = NewMovie.getRank();
        movieDao.updateMovieName(id, name);
        movieDao.updateMovieYear(id, year);
        movieDao.updateMovieRank(id, rank);
        
        return  movieDao.getAllMovies();

    }
    
    @DeleteMapping("/movies/{id}")
    public  List<Movie> deleteMovie(@PathVariable("id") int id) {
        movieDao.deleteMovie(id);
        return  movieDao.getAllMovies();

    }
    
}
