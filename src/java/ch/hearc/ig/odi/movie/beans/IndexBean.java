/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movie.beans;

import ch.hearc.ig.odi.movie.business.Movie;
import ch.hearc.ig.odi.movie.business.Person;
import ch.hearc.ig.odi.movie.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author chloe.trachsel
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean implements Serializable{

    @Inject Services services;
    private List<Movie> movies;
    private List<Person> people;
    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    
    public String initLists(){
        this.movies = services.getMoviesList();
        this.people = services.getPeopleList();
        return "/index.xhtml";
    }
}
