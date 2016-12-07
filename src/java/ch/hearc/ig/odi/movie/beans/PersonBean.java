/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movie.beans;

import ch.hearc.ig.odi.movie.business.Movie;
import ch.hearc.ig.odi.movie.business.Person;
import ch.hearc.ig.odi.movie.exception.InvalidParameterException;
import ch.hearc.ig.odi.movie.exception.NullParameterException;
import ch.hearc.ig.odi.movie.exception.UniqueException;
import ch.hearc.ig.odi.movie.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author chloe.trachsel
 */
@Named(value = "personBean")
@ViewScoped
public class PersonBean implements Serializable {

    @Inject
    Services services;

    private Person currentPerson;
    private Long id;

    private Movie addMovie;

    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
    }

    public void initPersonBean() {
        if (id == null) {
            currentPerson = new Person();
        } else {
            currentPerson = services.getPersonWithId(id);
        }
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public Long getId() {
        return id;
    }

    public Movie getAddMovie() {
        return addMovie;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddMovie(Movie addMovie) {
        this.addMovie = addMovie;
    }

    public String save() {
        try {
            services.savePerson(currentPerson);

        } catch (NullParameterException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
        return "detailPerson.xhtml?id=" + currentPerson.getId() + "faces-redirect=true";
    }

    public String addMovieToPerson() {
        try {
            services.addMovieToPerson(currentPerson, addMovie);
        } catch (UniqueException | NullParameterException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
        return "detailPerson.xhtml?id=" + currentPerson.getId() + "faces-redirect=true";
    }

    public List<Movie> getMoviesNotAdded() {
        List<Movie> moviesNotAdded = services.getMoviesList();
        moviesNotAdded.removeAll(currentPerson.getMovies());
        return moviesNotAdded;
    }

    public String removeMovie(Movie movie) {
        try {
            services.removeMovieFromPerson(currentPerson, movie);
        } catch (NullParameterException | InvalidParameterException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
        return "detailPerson.xhtml?id=" + currentPerson.getId() + "faces-redirect=true";
    }
}
