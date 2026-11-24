/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrdina_dedicnost;

/**
 *
 * @author jakub
 */
public class Nepritel {
    protected int miZivot;
    protected int miSilaUtoku;
    protected int miOdmenaGoldy;

    public Nepritel(int aiZivot, int aiSilaUtoku,int aiOdmenaGoldy){
        miZivot = aiZivot;
        miSilaUtoku = aiSilaUtoku;
        miOdmenaGoldy = aiOdmenaGoldy;

    }
    public int vratDosah(){
        return 0;
    }
    public boolean jeMrazivy(){
        return false;
    }
    public void utrpPoskozeni(int aiSilaHrdiny) {
    miZivot -= aiSilaHrdiny;
}
}           
