/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hrdina_dedicnost;

/**
 *
 * @author jakub
 */
public class Hrdina_dedicnost {

    public static void main(String[] args) {
        System.out.println("Vitej ve hre!");
        
        Hra mojeHra = new Hra();
        mojeHra.vyberPostavu();
        mojeHra.startHry();
    }
}
