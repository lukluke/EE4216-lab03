/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.Lab3.jbdc;

/**
 *
 * @author user01
 */
public class Movie {
    
    private int id;
    private String name;
    private int year;
    private float rank;

    public Movie(int id, String name, int year, float rank) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rank = rank;
    }
    
    public int getId() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }
    

}
