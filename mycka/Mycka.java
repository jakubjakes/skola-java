import java.util.Scanner;

public class Mycka {
    // Myčka musí znát všechny své zákazníky a všechny své stanice.
    private Zakaznik[] mZakaznici;
    private Stanice[] mStanice;
    private int miPocetZakazniku; // Hlídá, kolik už máme lidí v systému

    public Mycka() {
        mZakaznici = new Zakaznik[10]; // Kapacita myčky je 10 lidí
        mStanice = new Stanice[2]; // Myčka má 2 mycí boxy
        miPocetZakazniku = 0;

        // Abychom měli kde mýt, rovnou tu "postavíme" dvě stanice.
        // Parametry jsou: mytí, šampon, oplach, cena, čas.
        mStanice[0] = new Stanice(true, false, false, 100, 5);  // Obyčejná
        mStanice[1] = new Stanice(true, true, true, 300, 15);   // VIP
    }

    public void vytvorZakaznika() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej jmeno noveho zakaznika:");
        String psJmeno = sc.nextLine();
        
        // Vytvoříme nového zákazníka a uložíme ho do pole
        mZakaznici[miPocetZakazniku] = new Zakaznik(psJmeno);
        
        // Zákazník se sám zeptá, jestli si chce hned přidat auto
        mZakaznici[miPocetZakazniku].pridejAuto();
        
        // Zvedneme počítadlo lidí, aby další zákazník nepřepsal toho prvního
        miPocetZakazniku++;
    }

    // TADY SE VŠE PROPOJUJE
    public void umytAuto() {
        Scanner sc = new Scanner(System.in);

        // Ošetření chyby: Nemůžeme mýt, když tu nikdo není
        if (miPocetZakazniku == 0) {
            System.out.println("Nejdriv musis někoho registrovat!");
            return; // Ukončí metodu a vrátí nás do menu
        }

        // 1. VÝBĚR ZÁKAZNÍKA
        // Vypíšeme seznam lidí
        for (int i = 0; i < miPocetZakazniku; i++) {
            System.out.println("[" + i + "] " + mZakaznici[i].vratJmeno());
        }
        System.out.println("Vyber zakaznika (napis jeho cislo):");
        int piIndexZakaznika = Integer.parseInt(sc.nextLine());
        
        // "Vytáhneme" si vybraného zákazníka z pole do pomocné proměnné
        Zakaznik pVybranyZakaznik = mZakaznici[piIndexZakaznika];

        // 2. VÝBĚR AUTA
        // Řekneme vybranému zákazníkovi, ať ukáže svá auta
        pVybranyZakaznik.vypisAuta();
        System.out.println("Ktere auto umyjeme? (napis cislo auta):");
        int piIndexAuta = Integer.parseInt(sc.nextLine());
        
        // Zákazník nám "podá" vybrané auto
        Auto pVybraneAuto = pVybranyZakaznik.vratAuto(piIndexAuta);

        // 3. VÝBĚR STANICE
        System.out.println("Vyber stanici: [0] Zakladni (100 Kc), [1] VIP (300 Kc)");
        int piIndexStanice = Integer.parseInt(sc.nextLine());
        
        // Vytáhneme si stanici z pole
        Stanice pVybranaStanice = mStanice[piIndexStanice];

        // 4. KONEČNÁ AKCE A PLATBA
        // Stanici dáme do závorky naše auto. Stanice si ho prohlédne, 
        // zjistí typ, spočítá cenu a tu nám vrátí do proměnné.
        int piVyslednaCena = pVybranaStanice.vratCenuZaMyti(pVybraneAuto);
        
        // Řekneme zákazníkovi, ať si tuto cenu přičte na svůj účet
        pVybranyZakaznik.prictiUtratu(piVyslednaCena);

        System.out.println("Auto umyto! Cena byla: " + piVyslednaCena + " Kc.");
    }

    // HLAVNÍ MENU PROGRAMU
    public void provoz() {
        Scanner sc = new Scanner(System.in);
        // Proměnná, která drží smyčku při životě (jako u Tamagochiho)
        boolean pbMyckaBezi = true;

        while (pbMyckaBezi) {
            System.out.println("\n--- HLAVNI MENU MYCKY ---");
            System.out.println("[1] Registrovat zakaznika");
            System.out.println("[2] Umyt auto");
            System.out.println("[3] Ukoncit program");
            
            String psVolba = sc.nextLine();

            // Podle toho, co uživatel napsal, zavoláme příslušnou metodu
            if (psVolba.equals("1")) {
                vytvorZakaznika();
            } else if (psVolba.equals("2")) {
                umytAuto();
            } else if (psVolba.equals("3")) {
                System.out.println("Zavirame!");
                pbMyckaBezi = false; // Tohle ukončí while smyčku
            } else {
                System.out.println("Spatna volba, zkus to znova.");
            }
        }
    }

    // Tady úplně celý program startuje, když ho pustíš v NetBeans/IntelliJ
    public static void main(String[] args) {
        // Vyrobíme naši myčku...
        Mycka hlavniMycka = new Mycka();
        // ...a spustíme její menu.
        hlavniMycka.provoz();
    }
}