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
public class Movie {
    private Long id;
    private String name;
    private String producer;
    private List<Person> people;

    public Movie() {
        this.people = new ArrayList<>();
    }

    public Movie(Long id, String name, String producer) {
        this();
        this.id = id;
        this.name = name;
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    void removePerson(Person person) {
        this.people.remove(person);
    }

    void addPerson(Person person) {
        this.people.add(person);
    }
    
    
}
