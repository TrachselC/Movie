/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.movie.exception;

/**
 *
 * @author chloe.trachsel
 */
public class UniqueException extends Exception {

    /**
     * Creates a new instance of <code>UniqueException</code> without detail
     * message.
     */
    public UniqueException() {
    }

    /**
     * Constructs an instance of <code>UniqueException</code> with the specified
     * detail message.
     *
     * @param message the detail message.
     */
    public UniqueException(String message) {
        super(message);
    }
}
