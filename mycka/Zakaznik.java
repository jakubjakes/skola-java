import java.util.Scanner;

public class Zakaznik {
    private String msJmeno;
    private int miUtrata; // Kolik už u nás celkem projel peněz
    
    // Pole (garáž) pro auta. Znamená to "připrav mi 5 prázdných chlívků pro auta".
    private Auto[] mAuta; 
    
    // Tohle číslo si musíme držet, abychom věděli, kolik aut už v garáži je,
    // a nezačali dávat auta na místa, která neexistují (např. auto číslo 6).
    private int miPocetAut; 

    public Zakaznik(String asJmeno) {
        msJmeno = asJmeno;
        miUtrata = 0; // Nový zákazník začíná s čistým štítem (0 Kč)
        mAuta = new Auto[5]; // Nastavíme velikost garáže na 5
        miPocetAut = 0; // Zatím nemá žádné auto
    }

    // Pomocné metody pro získání informací
    public String vratJmeno() { return msJmeno; }
    public int vratUtratu() { return miUtrata; }
    
    // Když myčka umyje auto, zavolá tuhle metodu a přičte zákazníkovi dluh.
    public void prictiUtratu(int aiCena) { 
        miUtrata += aiCena; 
    }

    public void pridejAuto() {
        // Kontrola: Máme v garáži ještě místo? (je počet aut menší než 5?)
        if (miPocetAut < mAuta.length) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Jake auto pridavame? [1] Osobni, [2] Dodavka");
            
            // Přečteme číslo z klávesnice
            int piTyp = Integer.parseInt(sc.nextLine());
            
            // Vezmeme prázdný chlívek v poli (např. mAuta[0]) a vložíme do něj nové Auto.
            mAuta[miPocetAut] = new Auto(piTyp);
            
            // Zvedneme počítadlo, takže příští auto půjde do chlívku mAuta[1].
            miPocetAut++; 
            System.out.println("Auto zaparkovano do garaze.");
        } else {
            System.out.println("Garaz je plna, vic aut se nevejde!");
        }
    }

    // Tuhle metodu použije Myčka, když si chce ze zákazníkovy garáže "vytáhnout"
    // konkrétní auto na mytí. Zadá index (číslo chlívku) a auto jí to vrátí.
    public Auto vratAuto(int aiIndex) {
        return mAuta[aiIndex];
    }

    // Vypíše všechna auta, aby uživatel v menu viděl, z čeho může vybírat.
    public void vypisAuta() {
        System.out.println("Auta zakaznika " + msJmeno + ":");
        // Smyčka projde jen tolik aut, kolik jich reálně máme (ne všech 5 chlívků)
        for (int i = 0; i < miPocetAut; i++) {
            System.out.println("Auto cislo [" + i + "]");
        }
    }
}