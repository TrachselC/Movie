/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movie.business;

import ch.hearc.ig.odi.movie.exception.NullParameterException;
import ch.hearc.ig.odi.movie.exception.UniqueException;
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

    public Person() {
        this.movies = new ArrayList<>();
    }

    public Person(Long id, String firstName, String lastName) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void addMovie(Movie movie) throws UniqueException, NullParameterException {
        if (movie == null) {
            throw new NullParameterException("Movie is null");
        }
        if (movies.contains(movie)) {
            throw new UniqueException("Movie already exist");
        }
        this.movies.add(movie);
        movie.addPerson(this);
    }

    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
        movie.removePerson(this);
    }

}
