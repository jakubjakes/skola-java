/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simici;

/**
 *
 * @author jakub
 */

public class Simik {
    private String msJmeno;
    private String msPohlavi;
    // Všechno je na 100, když se narodí [cite: 4]
    private int miHlad = 100, miSpanek = 100, miToaleta = 100, miZabava = 100;

    public Simik(String asJmeno, String asPohlavi) {
        msJmeno = asJmeno;
        msPohlavi = asPohlavi;
    }

    // TOHLE JE NEJDŮLEŽITĚJŠÍ METODA PRO SIMÍKA
    // Kolik hodin uběhlo, tolikrát 5 bodů se mu odečte [cite: 4]
    public void klesej(int aiHodiny) {
        int piPokles = aiHodiny * 5; 
        miHlad -= piPokles; 
        miSpanek -= piPokles; 
        miToaleta -= piPokles; 
        miZabava -= piPokles;
    }

    // Akce, které mu vrací body zpátky
    public void spi() { miSpanek = 100; } // Spánek resetuje na 100 [cite: 9]
    public void wc() { miToaleta = 90; }  // Záchod vrátí 90 [cite: 11]
    
    public void jez(int aiBodyZJidla) { 
        miHlad += aiBodyZJidla; 
        if (miHlad > 100) miHlad = 100; // Nesmí se přežrat přes 100 [cite: 4]
    }
    
    public void bavSe(int aiBodyZeZabavy) {
        miZabava += aiBodyZeZabavy; 
        if (miZabava > 100) miZabava = 100; // Nesmí se ubavit k smrti [cite: 4]
    }

    // Žije, dokud nepadne nějaké číslo na 0 (nebo do mínusu) [cite: 17]
    public boolean jeZivy() {
        return miHlad > 0 && miSpanek > 0 && miToaleta > 0 && miZabava > 0;
    }

    // Klasická okýnka ven
    public String vratJmeno() { return msJmeno; }
    public int vratH() { return miHlad; }
    public int vratS() { return miSpanek; }
    public int vratT() { return miToaleta; }
    public int vratZ() { return miZabava; }
}
