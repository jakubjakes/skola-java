import java.util.Scanner;


public class Zakaznik {
    private String msJmeno;
    private int miUtrata;
    private Zarizeni[] mZarizeni;
    private int miPocetZarizeni;

    public Zakaznik(String asJmeno){
        msJmeno = asJmeno;
        miUtrata = 0;
        mZarizeni = new Zarizeni[3];
        miPocetZarizeni = 0;
    }

    public int prictiUtratu(int aiCena){
        miUtrata += aiCena;
        return miUtrata;
    }
    public void pridejZarizeni(){
        if (miPocetZarizeni < mZarizeni.length) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Jake zarizeni pridavame? [1] Notebook, [2] PC, [3] Tiskarna");
            int piTyp = Integer.parseInt(sc.nextLine());
            mZarizeni[miPocetZarizeni] = new Zarizeni(piTyp);
            miPocetZarizeni++;
            System.out.println("Zarizeni pridano do seznamu.");
        } else {
            System.out.println("Seznam zarizeni je plny, vic zarizeni se nevejde!");
        }
    }

    public String vratJmeno(){
        return msJmeno;
    }

    Zarizeni vratZarizeni(int piIndexZarizeni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
