import java.util.Scanner;

public class Servis {
    private Zakaznik[] mZakaznici;
    private Technik[] mTechnici;
    private int miPocetZakazniku; 

    public Servis() {
        mZakaznici = new Zakaznik[10]; 
        mTechnici = new Technik[2];    
        miPocetZakazniku = 0;

        // 0 = levný technik, 1 = dražší technik
        mTechnici[0] = new Technik(500); 
        mTechnici[1] = new Technik(1000); 
    }

    public void vytvorZakaznika() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej jmeno noveho zakaznika:");
        String psJmeno = sc.nextLine();
        
        mZakaznici[miPocetZakazniku] = new Zakaznik(psJmeno);
        
        System.out.println("Chces rovnou pridat zarizeni? [1] Ano, [2] Ne");
        if (sc.nextLine().equals("1")) {
            mZakaznici[miPocetZakazniku].pridejZarizeni();
        }
        
        miPocetZakazniku++; 
    }

    public void opravitZarizeni() {
        Scanner sc = new Scanner(System.in);

        if (miPocetZakazniku == 0) {
            System.out.println("Nejdriv musis zaregistrovat zakaznika!");
            return; 
        }

        // 1. Výběr zákazníka
        System.out.println("--- Kdo to prinesl? ---");
        for (int i = 0; i < miPocetZakazniku; i++) {
            System.out.println("[" + i + "] " + mZakaznici[i].vratJmeno());
        }
        int piIndexZakaznika = Integer.parseInt(sc.nextLine());
        Zakaznik pVybranyZakaznik = mZakaznici[piIndexZakaznika];

        // 2. Výběr zařízení
        System.out.println("Jake zarizeni (zadej index 0, 1 nebo 2):");
        int piIndexZarizeni = Integer.parseInt(sc.nextLine());
        Zarizeni pVybraneZarizeni = pVybranyZakaznik.vratZarizeni(piIndexZarizeni);

        // 3. Výběr technika
        System.out.println("Kdo to opravi? [0] Lojza (od 500 Kc), [1] Franta (od 1000 Kc)");
        int piIndexTechnika = Integer.parseInt(sc.nextLine());
        Technik pVybranyTechnik = mTechnici[piIndexTechnika];

        // 4. Akce a zúčtování
        int piCenaZaOpravu = pVybranyTechnik.vratCenuOpravy(pVybraneZarizeni);
        int pNovaUtrata = pVybranyZakaznik.prictiUtratu(piCenaZaOpravu);

        System.out.println("=== HOTOVO ===");
        System.out.println("Zarizeni opraveno! Cena opravy: " + piCenaZaOpravu + " Kc.");
        System.out.println("Zakaznik celkem dluzi: " + pNovaUtrata + " Kc.");
    }

    public void provoz() {
        Scanner sc = new Scanner(System.in);
        boolean pbServisBezi = true;

        while (pbServisBezi) {
            System.out.println("\n--- IT SERVIS MENU ---");
            System.out.println("[1] Prijmout zakaznika");
            System.out.println("[2] Opravit zarizeni");
            System.out.println("[3] Zavrit kram");
            
            String psVolba = sc.nextLine();

            if (psVolba.equals("1")) {
                vytvorZakaznika();
            } else if (psVolba.equals("2")) {
                opravitZarizeni();
            } else if (psVolba.equals("3")) {
                System.out.println("Zavirame, jdeme domu!");
                pbServisBezi = false;
            } else {
                System.out.println("Neplatna volba.");
            }
        }
    }

    public static void main(String[] args) {
        Servis mujServis = new Servis();
        mujServis.provoz(); 
    }
}