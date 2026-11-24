import java.util.Scanner;

public class AutoServis{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean servisBezi = true;
        
        while(servisBezi){
            System.out.println("Auto k oprave [1] ano [2] jdem dom");
            String volbaAuto = scanner.nextLine();

            if(volbaAuto.equals("1")){
                auto aktualniAuto = new auto();
                boolean opravujeSe = true;
                
                
                while(opravujeSe){
                    aktualniAuto.menu();    
                    String volbaOpravy = scanner.nextLine();

                    if(volbaOpravy.equals("1")){
                        aktualniAuto.opravaBrzd();
                    }else if(volbaOpravy.equals("2")){
                        aktualniAuto.vymenaOleje();
                    }else if(volbaOpravy.equals("3")){
                        aktualniAuto.vymenaSvetel();
                    }else if(volbaOpravy.equals("4")){
                        System.out.println("Dik za navstevu ale radsi ten srot odstav. Zaplat: " + aktualniAuto.vratCelkovouCenu() + "kc");
                        opravujeSe = false;
                    }else{
                        System.out.println("spatna volba");
                    }
                }
            }else if(volbaAuto.equals("2")){
                System.out.println("Dneska volno, zavirame dilnu");
                servisBezi = false;
            }else{
                System.out.println("neplatna volba");
            }
        }
        scanner.close();


}
}
