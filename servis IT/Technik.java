public class Technik
 {
    private int miSazba;

    public Technik(int aiSazba) {
        miSazba = aiSazba;
    }
    public int vratSazbu() {
        return miSazba;}

    public int vratCenuOpravy(Zarizeni aZarizeni) {
        if (aZarizeni.vratTyp() == 1) { 
            return miSazba + 500; 
        }
        return miSazba; 
    }
}
