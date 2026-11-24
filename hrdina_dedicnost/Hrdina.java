/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrdina_dedicnost;

/**
 *
 * @author jakub
 */
public abstract class Hrdina {
    protected int miZivot;
    protected int miBrneni;
    protected int miDosahUtoku; // 0 = blizko, 1 = dalka
    protected int miPocetLektvaru;
    protected int miMaxLektvaru;
    protected int miZlataky;

    public Hrdina(int aiZivot, int aiBrneni, int aiDosahUtoku, int aiMaxLektvaru) {
        miZivot = aiZivot;
        miBrneni = aiBrneni;
        miDosahUtoku = aiDosahUtoku;
        miMaxLektvaru = aiMaxLektvaru;
        miPocetLektvaru = 0;
        miZlataky = 0;
    }
    public void vypijLektvar(){
            if(miPocetLektvaru > 0){
                miZivot += 50;
                miPocetLektvaru--;
                System.out.println("Vypil jsi lektvar");
            }else{
                System.out.println("Nemas lektvar");
            }
        }

        public void utrpPoskozeni(int aiSilaUtoku, boolean abMrazivy) {
        int pZraneni = aiSilaUtoku - miBrneni;
        if(pZraneni < 0) pZraneni = 0;
        miZivot -= pZraneni;
        System.out.println("Dostal jsi zasah! Zbyva zivotu: " + miZivot);
}
    }

        

