/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simici;

/**
 *
 * @author jakub
 */
public class Elektronika extends Predmet {
    private int miZabava; // Kolik to přidá zábavy

    public Elektronika(String asNazev, int aiCena, int aiZabava) {
        super(asNazev, aiCena); // Pošleme název a cenu tátovi
        miZabava = aiZabava;
    }
    public int vratZabavu() { return miZabava; }
}
