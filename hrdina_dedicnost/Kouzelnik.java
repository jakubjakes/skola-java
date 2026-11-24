/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrdina_dedicnost;

/**
 *
 * @author jakub
 */
public class Kouzelnik extends Hrdina{
    private int miMana;

    public Kouzelnik(){
        super(50,0,1,0);
        miMana = 0;
    }
    
    public @Override void utropPoskozeni(int aiSilaUtoku, boolean abMrazivy){
        if(abMrazivy){
            miZivot -= aiSilaUtoku;
            System.out.println("Mrazivy utok prorazil stit");
        }else if(miMana >=10 ){
            miMana -= 10;
            System.out.println("Stit odrazil utok");
        }
    }
}

