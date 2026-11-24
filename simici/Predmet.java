/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simici;

/**
 *
 * @author jakub
 */
public class Predmet {
    protected String msNazev; // protected = děti to zdědí
    protected int miCena;

    public Predmet(String asNazev, int aiCena) {
        msNazev = asNazev;
        miCena = aiCena;
    }
}
