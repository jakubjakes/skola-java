import java.util.Scanner;

public class Stanice {
    // 1. TREZORY (Vlastnosti stanice)
    private Dron[] mDrony;          // Chlívky pro 20 dronů
    private int miPocetDronu;       // Kolik dronů reálně máme
    private Asteroid[] mAsteroidy;  // Chlívky pro 10 asteroidů
    
    // Sklady surovin
    private int miKyslik = 200;
    private int miVodik = 100;
    private int miVoda = 100;
    private int miKredity = 0;

    // 2. KONSTRUKTOR (Tady se všechno nachystá při startu)
    public Stanice() {
        mDrony = new Dron[20];
        mAsteroidy = new Asteroid[10];
        
        // Vyrobíme 10 náhodných asteroidů
        for (int i = 0; i < 10; i++) {
            mAsteroidy[i] = new Asteroid();
        }
        
        // Vyrobíme 2 základní drony
        mDrony[0] = new Dron("DronA");
        mDrony[1] = new Dron("DronB");
        miPocetDronu = 2;
    }

    // 3. POMOCNÉ METODY (Menší úkoly)

    public void vypisDrony() {
        System.out.println("\n--- SEZNAM DRONU V DOKU ---");
        for (int i = 0; i < miPocetDronu; i++) {
            if (mDrony[i] != null) {
                String stav = mDrony[i].jeVLetu() ? "[V LETU]" : "[V DOKU]";
                System.out.println(i + " - " + mDrony[i].vratOznaceni() + " (" + mDrony[i].vratPalivo() + "L) " + stav);
            }
        }
    }

    public void odeslatDron() {
        Scanner sc = new Scanner(System.in);
        vypisDrony();
        System.out.println("Vyber index dronu k odeslani:");
        int pIdxD = Integer.parseInt(sc.nextLine());

        // Kontrola, jestli dron náhodou už nelítá
        if (mDrony[pIdxD].jeVLetu()) {
            System.out.println("Chyba: Tento dron uz je ve vesmiru!");
            return;
        }

        System.out.println("Vyber asteroid (0-9):");
        int pIdxA = Integer.parseInt(sc.nextLine());

        // Pošleme dron na vybraný šutr
        mDrony[pIdxD].vzlet(mAsteroidy[pIdxA]);
        System.out.println("Dron " + mDrony[pIdxD].vratOznaceni() + " odstartoval.");
    }

    public void iterace() {
        // Lidi dýchají a pijí - suroviny mizí
        miKyslik -= 50;
        miVoda -= 15;

        // Projdeme všechny drony a pohneme s nimi ve vesmíru
        for (int i = 0; i < miPocetDronu; i++) {
            if (mDrony[i] != null && mDrony[i].jeVLetu()) {
                
                boolean pPrezil = mDrony[i].aktualizujLet();
                
                if (!pPrezil) {
                    System.out.println("!!! TRAGEDIE: Dron " + mDrony[i].vratOznaceni() + " vybouchl (doslo palivo) !!!");
                    mDrony[i] = null; // Vymažeme ho z pole
                } 
                else if (!mDrony[i].jeVLetu()) {
                    // Pokud se právě teď vrátil (vzdálenost klesla na 0)
                    Asteroid pAst = mDrony[i].vratAsteroid();
                    
                    // Výpočet čistého ledu (10 tun - znečištění)
                    double pCistyLed = 10.0 * (1.0 - (pAst.vratZnecisteni() / 100.0));
                    
                    // Výroba surovin z ledu
                    miKyslik += (int)(pCistyLed * 500);
                    miVodik += (int)(pCistyLed * 400);
                    miVoda += (int)(pCistyLed * 100);
                    
                    System.out.println("Dron se vratil! Privezl " + pCistyLed + "t ledu.");
                }
            }
        }
    }

    // 4. HLAVNÍ MENU (Ovládání hry)
    public void menu() {
        Scanner sc = new Scanner(System.in);
        
        while (miKyslik > 0 && miVoda > 0) {
            System.out.println("\n================================================");
            System.out.println("KYSLIK: " + miKyslik + " | VODIK: " + miVodik + " | VODA: " + miVoda + " | KREDITY: " + miKredity);
            System.out.println("------------------------------------------------");
            System.out.println("1-Odeslat dron | 2-Cekat (1 kolo) | 3-Tankovat | 4-Koupit | 5-Prodat | 6-Konec");
            
            String volba = sc.nextLine();

            if (volba.equals("1")) {
                odeslatDron();
            } 
            else if (volba.equals("2")) {
                iterace(); // Tady se posune čas
            } 
            else if (volba.equals("3")) {
                vypisDrony();
                System.out.println("Index dronu k natankovani:");
                int pIdx = Integer.parseInt(sc.nextLine());
                int pChybi = 1000 - mDrony[pIdx].vratPalivo();
                if (miVodik >= pChybi) {
                    miVodik -= pChybi;
                    mDrony[pIdx].natankuj();
                    System.out.println("Natankovano.");
                } else {
                    System.out.println("Malo vodiku na stanici!");
                }
            } 
            else if (volba.equals("4")) {
                if (miKredity >= 100000 && miPocetDronu < 20) {
                    miKredity -= 100000;
                    mDrony[miPocetDronu] = new Dron("Dron" + miPocetDronu);
                    miPocetDronu++;
                    System.out.println("Novy dron zakoupen.");
                } else {
                    System.out.println("Malo penez nebo plny dok.");
                }
            } 
            else if (volba.equals("5")) {
                System.out.println("Prodat: 1-Kyslik (500sc), 2-Vodik (150sc), 3-Voda (50sc)");
                String co = sc.nextLine();
                if (co.equals("1") && miKyslik >= 100) { miKyslik -= 100; miKredity += 500; }
                else if (co.equals("2") && miVodik >= 100) { miVodik -= 100; miKredity += 150; }
                else if (co.equals("3") && miVoda >= 100) { miVoda -= 100; miKredity += 50; }
                else { System.out.println("Chyba prodeje."); }
            } 
            else if (volba.equals("6")) {
                break;
            }
        }
        System.out.println("\n!!! KONEC HRY: POSADKA ZAHYNULA NEBO JSTE UKONCILI MISI !!!");
    }

    public static void main(String[] args) {
        new Stanice().menu();
    }
}