public class Stanice {
    // Vlastnosti stanice podle tvého UML diagramu.
    // boolean znamená pravda/nepravda (má šampon? ano/ne).
    private boolean mbMyti;
    private boolean mbSampon;
    private boolean mbOplach;
    private int miCena; // Základní cena stanice (např. 100 Kč)
    private int miDobaMyti;

    // KONSTRUKTOR: Když v Myčce stavíme novou stanici, musíme jí rovnou
    // říct, co všechno umí a kolik stojí v základu.
    public Stanice(boolean abMyti, boolean abSampon, boolean abOplach, int aiCena, int aiDobaMyti) {
        mbMyti = abMyti;    //abMyti prinese informaci(postak) mbMyti ji uchovava a pracuje s ni
        mbSampon = abSampon;  
        mbOplach = abOplach;
        miCena = aiCena;
        miDobaMyti = aiDobaMyti;
    }

    // HLAVNÍ METODA STANICE: Tady se děje ta nejdůležitější logika!
    // Všimni si, že v závorce je "(Auto aAuto)". To znamená, že Stanice 
    // vyžaduje, abys jí "podal" konkrétní auto, jinak nic nespočítá.
    public int vratCenuZaMyti(Auto aAuto) {
        
        // Zeptáme se auta na jeho typ. Pokud je to 2 (Dodávka)...
        if (aAuto.vratTyp() == 2) { 
            // ...tak k základní ceně přirazíme 150 Kč navíc a výsledek vrátíme (return).
            return miCena + 150; 
        }
        
        // Pokud to byla 1 (Osobák), tenhle řádek vrátí jen tu základní cenu bez příplatku.
        return miCena; 
    }
}