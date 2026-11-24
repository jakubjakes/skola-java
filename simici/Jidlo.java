/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simici;

/**
 *
 * @author jakub
 */
public class Jidlo extends Predmet {
    private int miVyziva; // Kolik to přidá hladu

    public Jidlo(String asNazev, int aiCena, int aiVyziva) {
        super(asNazev, aiCena); // Pošleme název a cenu tátovi
        miVyziva = aiVyziva;
    }
    public int vratVyzivu() { return miVyziva; }
}