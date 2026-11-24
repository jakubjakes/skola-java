/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrdina_dedicnost;

/**
 *
 * @author jakub
 */
public class Lokace{
   protected boolean maTruhlu;
   protected Nepritel mNepritel;

   public Lokace(){
    maTruhlu = false;
    mNepritel = null;
   }

   public boolean maTruhlu(){
    return maTruhlu;
   }

   public void VyberTruhlu(){
    maTruhlu = true;
   }

   public Nepritel vratNepritele(){
    return mNepritel;
   }

   public void zabijNepritele(){
    mNepritel = null;
   }

   public void vypisInfo(){
    System.out.println("Stojis na nezname lokaci");
   }
   public void vyberTruhlu() {
    maTruhlu = false; // Truhla zmizí z mapy
}

}
