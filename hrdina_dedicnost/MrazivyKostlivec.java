/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrdina_dedicnost;

/**
 *
 * @author jakub
 */
public class MrazivyKostlivec extends Nepritel{
    public MrazivyKostlivec(){
        super(60, 10, 25);
    }

    @Override
    public boolean jeMrazivy() {
        return true;
    }
}   
