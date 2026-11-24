package com.mycompany.simici;
import java.util.Scanner;

public class Domacnost {
    // Trezory režiséra
    private Simik[] mSimici = new Simik[10];
    private int miPocetSimiku = 0;
    private int miPrachy = 0, miDen = 1, miHodina = 1;
    
    // Lednice a televize (ty jsou společné pro všechny )
    private Jidlo[] mLednice = new Jidlo[50];
    private int miVlednici = 0;
    private Elektronika mTV = null; // null = zatím nemáme televizi

    public Domacnost(String asJmeno, String asPohlavi) {
        // Vyrobíme prvního Simíka a strčíme ho do pole na index 0 [cite: 1]
        mSimici[miPocetSimiku] = new Simik(asJmeno, asPohlavi);
        miPocetSimiku++;
    }

    // KONTROLA SMRTI: Projde všechny Simíky, a když je aspoň jeden mrtvý, vrátí false [cite: 17]
    private boolean vsichniZiji() {
        for (int i = 0; i < miPocetSimiku; i++) {
            if (mSimici[i].jeZivy() == false) {
                return false; 
            }
        }
        return true;
    }

    // POSUN ČASU: Tahle metoda dělá to kouzlo, že všichni hladoví naráz 
    private void posun(int aHodiny) {
        miHodina += aHodiny;
        while (miHodina > 24) { 
            miDen++; 
            miHodina -= 24; 
        }
        // Všem Simíkům se odečte tolikrát 5 bodů, kolik uběhlo hodin
        for (int i = 0; i < miPocetSimiku; i++) {
            mSimici[i].klesej(aHodiny);
        }
    }

    // HLAVNÍ HRA
    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        
        // Hra běží, dokud všichni žijí
        while (vsichniZiji() == true) {
            vypisStatistiky();
            
            System.out.println("Vyber akci (1-Prace, 2-Spat, 3-WC, 4-Zabava, 5-Koupit jidlo, 6-Jist, 7-TV, 8-Rande):");
            int volba = sc.nextInt();

            // Zjednodušení: Akci dělá vždycky první Simík (mSimici[0]), ale čas plyne všem!
            Simik hrac = mSimici[0];

            if (volba == 1) {
                miPrachy += 1500; // Přidá peníze [cite: 8]
                posun(6);         // Uběhne 6 hodin [cite: 8]
            } 
            else if (volba == 2) {
                hrac.spi();       // Resetne spánek [cite: 9]
                posun(7);         // Spí 7 hodin [cite: 9]
            } 
            else if (volba == 3) {
                hrac.wc();        // Jde na WC [cite: 11]
                posun(1);         // Trvá to 1 hodinu [cite: 11]
            } 
            else if (volba == 4) {
                // Pokud nemáme TV (je null), čteme knihu za 30[cite: 12]. Jinak čumíme na TV.
                int zabavaBodu = (mTV == null) ? 30 : mTV.vratZabavu(); 
                hrac.bavSe(zabavaBodu);
                posun(2);         // Zábava trvá 2 hodiny [cite: 11]
            } 
            else if (volba == 5) {
                if (miPrachy >= 200) {
                    miPrachy -= 200;
                    // Strčíme novou pizzu do lednice
                    mLednice[miVlednici] = new Jidlo("Pizza", 200, 40);
                    miVlednici++;
                    posun(1);     // Nákup trvá 1 hodinu [cite: 12]
                } else { System.out.println("Nemas prachy!"); }
            } 
            else if (volba == 6) {
                if (miVlednici > 0) {
                    miVlednici--; // Vezmeme jídlo z lednice
                    hrac.jez(mLednice[miVlednici].vratVyzivu()); // Sníme ho [cite: 10]
                    posun(1);     // Jídlo trvá 1 hodinu [cite: 10]
                } else { System.out.println("Lednice je prazdna!"); }
            } 
            else if (volba == 7) {
                if (miPrachy >= 1000) {
                    miPrachy -= 1000;
                    mTV = new Elektronika("TV", 1000, 60); // Máme bednu!
                    posun(1);     // Nákup trvá 1 hodinu [cite: 12]
                }
            } 
            else if (volba == 8) {
                hrac.bavSe(40);   // Rande přidá 40 zábavy [cite: 13]
                posun(2);         // Není řečeno, dáme třeba 2 hodiny
                // 50% šance na novýho Simíka v baráku! [cite: 13]
                if (Math.random() > 0.5 && miPocetSimiku < 10) {
                    System.out.println("RANDE VYSLO! Mas spolubydliciho!");
                    mSimici[miPocetSimiku] = new Simik("Partner", "Zena");
                    miPocetSimiku++;
                }
            }
        }
        System.out.println("!!! KONEC HRY. NEKDO ZEMREL. !!!");
    }

    private void vypisStatistiky() {
        System.out.println("\n*** " + miDen + ". den, " + miHodina + ". hodina ***");
        for (int i = 0; i < miPocetSimiku; i++) {
            System.out.println(mSimici[i].vratJmeno() + " -> Hlad: " + mSimici[i].vratH() + " | Spanek: " + mSimici[i].vratS() + " | WC: " + mSimici[i].vratT() + " | Zabava: " + mSimici[i].vratZ());
        }
        System.out.println("Penize: " + miPrachy + ",- | Jidlo v lednici: " + miVlednici + " ks");
    }
}