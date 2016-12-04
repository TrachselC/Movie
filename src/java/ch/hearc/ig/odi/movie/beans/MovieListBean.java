/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movie.beans;

import ch.hearc.ig.odi.movie.service.Services;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author chloe.trachsel
 */
@Named(value = "movieListBean")
@RequestScoped
public class MovieListBean {

    @Inject Services services;
    /**
     * Creates a new instance of movieListBean
     */
    public MovieListBean() {
    }
    
    public List getMoviesList(){
        return services.getMoviesList();
    }
    
    public int getPeopleCount() {
        return 0;
    }
    
}
