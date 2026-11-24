public class obchod_s_kouzly {
    public static void main(String[] args) {
        

        int brneni = 1;
        int mec = 1;
        int lahvicka = 1;
        int kouzlo = 1;
        int inventar = {0,0};
        boolean sklad = {true,true,true}
        volba = Integer.parseInt(System.console().readLine());


        while (volba != 0) {
            System.out.println("Vytej v obchode co pro tebe muzu udelat?");
            System.out.println("Chces kupovat(1) nebo prodavat(2)?");
            volba = Integer.parseInt(System.console().readLine());
            if (volba == 1) {
                System.out.println("Tohle tu mam.");
                System.out.println("brneni(1)");
                System.out.println("mec(2)");
                System.out.println("lahvicku(3)");
                System.out.println("kouzlo(4)");
                System.out.println("Co by jsi rad?");
            }
            
            
            
        }

    }
}
