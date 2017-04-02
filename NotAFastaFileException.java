/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ORFVoorspeller;

/**
 *
 * @author Beheerder
 */
public class NotAFastaFileException extends Exception {

    public NotAFastaFileException() {
        super();
    }

    public NotAFastaFileException(String err) {

        super(err);

    }

}
