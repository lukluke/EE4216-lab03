/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.Lab3.jbdc;

import java.sql.ResultSet;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author user01
 */
public class MovieDao {
    
    private final JdbcTemplate jdbcTemplate;

    public MovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // int id, String name, int year, float rank
    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM Movies";
        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("year"),
                rs.getFloat("rank")
        ));
    }
    
    public void updateMovieName(int id, String name) {
        String sql = "UPDATE movies SET NAME = ? WHERE ID = ?";
        jdbcTemplate.update(sql, name, id);
    }
    public void updateMovieYear(int id,int year) {
        String sql = "UPDATE movies SET \"year\" = ? WHERE ID = ?";
        jdbcTemplate.update(sql,  year,id);
    }
    public void updateMovieRank(int id, float rank) {
        String sql = "UPDATE movies SET RANK = ? WHERE ID = ?";
        jdbcTemplate.update(sql, rank, id);
    }
    
    public void deleteMovie(int id) {
        String sql = "DELETE FROM movies WHERE id = ? ";
        jdbcTemplate.update(sql, id);
    }

}