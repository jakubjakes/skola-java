public class Auto {
    // PRIVATE znamená, že tuto proměnnou nikdo zvenčí nemůže tajně přepsat.
    // "miTyp" uchovává číslo: 1 = Osobni, 2 = Dodavka.
    private int miTyp; 

    // KONSTRUKTOR: Volá se jen jednou, přesně ve chvíli, kdy napíšeme "new Auto(1)".
    // Slouží k tomu, abychom autu hned při výrobě vtiskli jeho typ.
    public Auto(int aiTyp) {
        miTyp = aiTyp;
    }

    // GETTER: Protože je "miTyp" private, ostatní třídy (třeba Stanice) 
    // si o něj musí slušně poprosit přes tuto metodu.
    public int vratTyp() {
        return miTyp;
    }
}