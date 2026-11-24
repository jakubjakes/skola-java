public class Dron {
    private String msOznaceni;
    private int miPalivo;
    private boolean mbJeVLetu;      // Lítá? (true/false)
    private int miZbyvajiciCesta;   // Kolikrát ještě musím "pohnout časem", než přistanu
    private Asteroid mCilovyAsteroid; // Na který kámen vlastně letím?

    public Dron(String asOznaceni) {
        this.msOznaceni = asOznaceni;
        this.miPalivo = 1000;       // Dáme mu plnou nádrž do začátku
        this.mbJeVLetu = false;     // Zatím sedí v doku
    }

    public void vzlet(Asteroid aAsteroid) {
        this.mCilovyAsteroid = aAsteroid;
        // Cesta tam + cesta zpět. Pokud je vzdálenost 3, let trvá 6 kol.
        this.miZbyvajiciCesta = aAsteroid.vratVzdalenost() * 2;
        this.mbJeVLetu = true;
    }

    // Tuhle metodu volá Stanice v každém kole. 
    // Vrací "false", pokud dron vybouchne (dojde palivo).
    public boolean aktualizujLet() {
        if (mbJeVLetu) {
            miPalivo -= 100;     // Sežral 100 litrů za každé "kolo"
            miZbyvajiciCesta--;  // Urazil kus cesty

            // KONTROLA SMRTI: Pokud má v nádrži nulu a ještě není doma
            if (miPalivo < 0) {
                return false;    // "Umřel jsem, šéfe!"
            }
            
            // KONTROLA NÁVRATU: Pokud už dojel na nulu ve vzdálenosti
            if (miZbyvajiciCesta == 0) {
                mbJeVLetu = false; // "Jsem v doku, vykládejte náklad!"
                return true;
            }
        }
        return true; // "Stále letím, všechno v pohodě."
    }

    // Klasické pomocné "okýnka" (gettery)
    public String vratOznaceni() { return msOznaceni; }
    public int vratPalivo() { return miPalivo; }
    public boolean jeVLetu() { return mbJeVLetu; }
    public Asteroid vratAsteroid() { return mCilovyAsteroid; }
    public void natankuj() { this.miPalivo = 1000; }
}