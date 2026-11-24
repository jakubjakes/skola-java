public class auto{
    private boolean brzdyHotovo = false;
    private boolean olejHotovo = false;
    private boolean svetlaHotovo = false;

}


public void opravaBrzd(){
    if(!brzdyHotovo1){
        celkovaCena += 2500;
        brzdyHotovo = true;
        System.out.println("Brzdy jsou ready. Momentalne jsi dluzny: " + celkovaCena + "kc");
    }
}
public void vymenaOleje(){
    if(!olejHotovo){
        celkovaCena += 1500;
        olejHotovo = true;
        System.out.println("Olej je vymeneny. Momentalne jsi dluzny: " + celkovaCena + "kc");
    }
}
public void vymenaSvetel(){
    if(!svetlaHotovo){
        celkovaCena += 600;
        svetlaHotovo = true;
        System.out.println("Svetla zase sviti. Momentalne jsi dluzny: " celkovaCena + "kc");
    }
}

public void menu(){
    System.out.println("Dobrej shit jsi to privezl s cim ti muzu pomoci");
    System.out.println("[1] - Oprava brzd (2500kc)");
    System.out.println("[2] - Vymena oleje (1500kc)");
    System.out.println("[3] - Vymena svetel (600)");
    System.out.println("[4] - Zabalit to a odjet");
}

public int  vratCelkovouCenu(){
    return celkovaCena;
}

