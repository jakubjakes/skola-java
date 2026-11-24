/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hrdina_dedicnost;
import java.util.Scanner;
/**
 *
 * @author jakub
 */
public class Hra {
    private Hrdina  mHrdina;
    private Lokace[] mMapa;
    private int mAktualniPozice;
    
        
    
    public Hra(){
    mMapa = new Lokace[6];
    mAktualniPozice = 0;
    vygenerujMapu();
    }
    
    private void vygenerujMapu(){
        mMapa[0] = new Cesta(false); 
        mMapa[1] = new Cesta(false); 
        mMapa[2] = new Cesta(true); 
        mMapa[3] = new Obchod(); 
        mMapa[4] = new Les(new OhnivyKostlivec()); 
        mMapa[5] = new Les(new MrazivyKostlivec()); 
    }
    public void vyberPostavu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vyber si hrdinu: [1] Rytir, [2] Kouzelnik, [3] Lucisnik");
        String volba = sc.nextLine();

        if (volba.equals("1")) {
            mHrdina = new Rytir();
            System.out.println("Zvolil sis Rytire. Priprav si mec!");
        } else if (volba.equals("2")) {
            mHrdina = new Kouzelnik();
            System.out.println("Zvolil sis Kouzelnika. Priprav si manu!");
        } else {
            // Tohle zatím necháme spadnout na lučištníka, ať nemáme error
            // mHrdina = new Lucisnik(); 
            System.out.println("Zvolil sis Lucisnika.");
        }
    }
    public void startHry() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n=== VYRÁŽÍŠ NA DOBRODRUŽSTVÍ! ===");

    // Jdeme po mapě od indexu 0 až do konce
    for (int i = 0; i < mMapa.length; i++) {
        mAktualniPozice = i;
        Lokace pAktualniPolicko = mMapa[i];

        System.out.println("\n--- KROK " + (i + 1) + " ---");
        
        // Tady zafunguje ten tvůj geniální polymorfismus s dědičností!
        // Samo to vypíše, jestli je to les, cesta nebo obchod.
        pAktualniPolicko.vypisInfo(); 

        // 1. ZKONTROLUJEME TRUHLU
        if (pAktualniPolicko.maTruhlu() == true) {
            System.out.println("Chces vypit lektvar? (napis: ano / ne)");
            String volba = sc.nextLine();
            if (volba.equals("ano")) {
                mHrdina.vypijLektvar();
                pAktualniPolicko.vyberTruhlu(); // Smažeme ji z mapy
            }
        }

        // 2. ZKONTROLUJEME NEPŘÍTELE (SOUBOJ)
        Nepritel zaporak = pAktualniPolicko.vratNepritele();
        
        if (zaporak != null) {
            System.out.println("ZAČÍNÁ BOJ S NEPŘÍTELEM!");
            
            // Boj trvá tak dlouho, dokud oba žijí (mají víc jak 0 životů)
            while (mHrdina.miZivot > 0 && zaporak.miZivot > 0) {
                
                System.out.println("Útočíš na nepřítele! (Zmačkni Enter)");
                sc.nextLine(); // Hra čeká, až hráč potvrdí útok
                
                // Dáme nepříteli třeba 20 poškození (pro zjednodušení)
                zaporak.utrpPoskozeni(20); 
                System.out.println("Nepriteli zbyva " + zaporak.miZivot + " HP.");

                // Pokud nepřítel útok přežil, vrátí ti ránu!
                if (zaporak.miZivot > 0) {
                    System.out.println("Nepřítel vrací úder!");
                    // Tady se volá to speciální tvoje @Override (štít u kouzelníka atd.)
                    mHrdina.utrpPoskozeni(zaporak.miSilaUtoku, zaporak.jeMrazivy());
                }
            }

            // Kdo to po tom `while` cyklu přežil?
            if (mHrdina.miZivot <= 0) {
                System.out.println("\nZEMŘEL JSI! Tvůj hrdina padl v boji.");
                return; // Ukončí okamžitě celou metodu startHry() = Konec
            } else {
                System.out.println("\nZabil jsi nepřítele! Cesta je volná.");
                pAktualniPolicko.zabijNepritele(); // Mrtvola zmizí z mapy
            }
        }

        // 3. PŘECHOD NA DALŠÍ POLÍČKO
        System.out.println("\nŠlápni dál... (Zmačkni Enter)");
        sc.nextLine();
    }

    // Pokud cyklus dojel až na konec a hrdina nezemřel (to by ho vyhodil ten 'return' nahoře)
    System.out.println("\n=== GRATULUJI! PROŠEL JSI CELOU MAPU A VYHRÁL! ===");
}
    
}
