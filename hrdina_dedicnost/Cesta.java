/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrdina_dedicnost;

/**
 *
 * @author jakub
 */
public class Cesta extends Lokace{
    
    public Cesta(boolean abChciTruhlu){
        if(abChciTruhlu == true){
            maTruhlu = true;
        }
    }

        @Override
        public void vypisInfo() {
            System.out.println("Stojis na ceste");
            if(maTruhlu == true){
                System.out.println("Na ceste je truhla");
            }
        }
    
}
