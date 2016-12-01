/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movie.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chloe.trachsel
 */
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Movie> movies;

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
    
    public void removeMovie(Movie movie){
        this.movies.remove(movie);
    }
    
}
