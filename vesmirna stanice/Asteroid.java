import java.util.Random;

public class Asteroid {
    private int miVzdalenost;  // Jak moc se dron nalítá
    private int miZnecisteni; // Kolik bláta tam je (10% - 30%)

    public Asteroid() {
        Random rnd = new Random();
        
        // "this" znamená "moje vlastní". 
        // Generujeme číslo od 1 do 4. (rnd.nextInt(4) dá 0 až 3, proto +1)
        this.miVzdalenost = rnd.nextInt(4) + 1; 
        
        // Znečištění (21 čísel od nuly, tzn. 0 až 20... a k tomu + 10, takže 10 až 30)
        this.miZnecisteni = rnd.nextInt(21) + 10;
    }

    // Gettery jsou jen okýnka, aby se ostatní třídy mohly podívat dovnitř
    public int vratVzdalenost() { return miVzdalenost; }
    public int vratZnecisteni() { return miZnecisteni; }
}