import java.util.Scanner;

public class Tamagochi{
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pojmenuj svoje zviratko");
        Zvire bobina = new Zvire(scanner.nextLine());
        System.out.println("tve zviratko se jmenuje: "+ bobina.vratJmeno());
        int cas = 0;

       while(bobina.smrt() != true){
           bobina.vypisStav();
           bobina.volby();
           System.out.println("Zadej volbu [1],[2],[3]");
           String volba = scanner.nextLine();
           if(volba != null){
               if(volba.equals("1")){
                   bobina.nakrmit();
               }else if(volba.equals("2")){
                   bobina.ulozitSpat();
               }else if(volba.equals("3")){
                   System.out.println("rozhol ses nic nedelat");
               }else{
                   System.out.println("Neplatna volba");
               }
           }
           System.out.println("uplynula dalsi hodina");
           cas++;
           bobina.tikCasu();
       }

       System.out.println("--- Konec hry! ---");
       scanner.close();        
    }
}