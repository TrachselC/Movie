/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movie.beans;

import ch.hearc.ig.odi.movie.business.Movie;
import ch.hearc.ig.odi.movie.exception.NullParameterException;
import ch.hearc.ig.odi.movie.service.Services;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author chloe.trachsel
 */
@Named(value = "movieBean")
@ViewScoped
public class MovieBean implements Serializable {

    @Inject
    Services services;

    private Long id;
    private Movie currentMovie;

    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }

    public Long getId() {
        return id;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    public void initMovieBean() {
        if (id == null) {
            currentMovie = new Movie();
        } else {
            currentMovie = services.getMovieWithId(id);
        }
    }

    /**
     * Cette méthode permet d'enregistrer un nouveau film. L'utilisateur est
     * ensuite redirigé vers le détail de ce nouveau film
     *
     * @return La page de détail du film
     */
    public String save() {
        try {
            services.saveMovie(currentMovie);

        } catch (NullParameterException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
        return "detailMovie.xhtml?id=" + currentMovie.getId() + "faces-redirect=true";
    }
}
