/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.simici;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadej jmeno Simika:");
        String jmeno = sc.nextLine();
        
        System.out.println("Zadej pohlavi (Muz/Zena):");
        String pohlavi = sc.nextLine();
        
        // Vyrobíme režiséra a hodíme mu vstupní data
        Domacnost hra = new Domacnost(jmeno, pohlavi);
        hra.gameStart(); // A hra běží! 
    }
}