import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Mavenproject1 {
    // final je stejne jako const v c++
    static final int VELIKOST_POLE = 26;
    static char abeceda[] = new char[VELIKOST_POLE];
    static Scanner scanner = new Scanner(System.in);

    static void naplnAbecedu(char apAbeceda[], int aiVelikost){
        for(int index = 0; index < aiVelikost; index++){
            apAbeceda[index] = (char)(97 + index);
        }
    }

    static void vypisAbecedu(char apAbeceda[], int aiVelikost){
        for(int index = 0; index < aiVelikost; index++){
            System.out.println(apAbeceda[index]);
        }
    }

    static char vratZnakNaPozici(char apAbeceda[], int aiVelikost, int aiPozice){
        char pZnak = (char)(0);
        if(aiPozice >= 0 && aiPozice < aiVelikost){
            pZnak = apAbeceda[aiPozice];
        }
        return pZnak;
    }

    static int vratIndexZnaku(char apAbeceda[], int aiVelikost, char acZnak){
        int pIndex = -1;
        boolean pbNalezeno = false;
        int piIndex = 0;
        while(!pbNalezeno && piIndex < aiVelikost){
            if(apAbeceda[piIndex] == acZnak){
                pbNalezeno = true;
                pIndex = piIndex;
            }else{
                piIndex++;
            }
        }
        return pIndex;
    }

    static boolean jeVAbecede(char apAbeceda[], int aiVelikost, char acZnak){
        int piIndexAbeceda = 0;
        boolean pbNalezeno = false;
        while(piIndexAbeceda < aiVelikost && !pbNalezeno){
            if(apAbeceda[piIndexAbeceda] == acZnak){
                pbNalezeno = true;
            }else{
               piIndexAbeceda++;
            }
        }
        return pbNalezeno;
    }

    static String vratPlatnyVstup(char apAbeceda[], int aiVelikost){
        String psVstup = "";
        boolean pbVstupOK = false;
        int piIndexVstup;
        boolean pbChyba;
        while(!pbVstupOK){
            System.out.println("Zadej prosim vstupni retezec (male pismena a-z): ");
            psVstup = scanner.nextLine().trim();
            pbChyba = false;
            piIndexVstup = 0;
            while(piIndexVstup < psVstup.length() && !pbChyba){
                pbChyba = !jeVAbecede(apAbeceda, aiVelikost, psVstup.charAt(piIndexVstup));
                piIndexVstup++;
            }
            if(pbChyba || psVstup.length() == 0){
               System.out.println("Chyba vstupu! Pouzij jen mala pismena bez mezer.");
            }else{
                pbVstupOK = true;
            }
        }
        return psVstup;
    }

    static int vratPlatnyPosun(int aiMaxValue){
        String psVstup;
        Pattern pattern = Pattern.compile("^[0-9]{1,2}$", Pattern.CASE_INSENSITIVE);
        int piPosun = 0;
        boolean pbVstupOK = false;
        while(!pbVstupOK){
            System.out.println("Zadej prosim posun (1.." + (aiMaxValue-1) + "): ");
            psVstup = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(psVstup);
            if(matcher.find()){
                piPosun = Integer.parseInt(psVstup);
                if(piPosun > 0 && piPosun < aiMaxValue){
                    pbVstupOK = true;
                }else{
                    System.out.println("Neplatny vstup. Zadej cislo v rozsahu 1.." + (aiMaxValue-1));
                }
            } else {
                System.out.println("Neplatny vstup. Zadej jen kladne cislo.");
            }
        }
        return piPosun;
    }

    static char vratPosunutyZnak(char poleAbeceda[], int velikost, char achZnak, int aiPosun){
        return vratZnakNaPozici(poleAbeceda, velikost, (vratIndexZnaku(poleAbeceda, velikost, achZnak) + aiPosun) % velikost);
    }

    // novy: pro desifrovani - posunujeme zpet
    static char vratPosunutyZnakZpet(char poleAbeceda[], int velikost, char achZnak, int aiPosun){
        int originIndex = vratIndexZnaku(poleAbeceda, velikost, achZnak);
        int novyIndex = (originIndex - aiPosun) % velikost;
        if(novyIndex < 0) novyIndex += velikost;
        return vratZnakNaPozici(poleAbeceda, velikost, novyIndex);
    }

    static void zasifruj(char apAbeceda[], int aiVelikost){
        naplnAbecedu(apAbeceda, aiVelikost);
        String psRetezec = vratPlatnyVstup(apAbeceda, aiVelikost);
        int posun = vratPlatnyPosun(aiVelikost);
        StringBuilder psZasifrovanyRetezec = new StringBuilder();
        for(int index = 0; index < psRetezec.length(); index++){
            psZasifrovanyRetezec.append(vratPosunutyZnak(apAbeceda, aiVelikost, psRetezec.charAt(index), posun));
        }
        System.out.println("Zasifrovany text je: " + psZasifrovanyRetezec.toString());
    }

    static void desifruj(char apAbeceda[], int aiVelikost){
        naplnAbecedu(apAbeceda, aiVelikost);
        String psRetezec = vratPlatnyVstup(apAbeceda, aiVelikost);
        int posun = vratPlatnyPosun(aiVelikost);
        StringBuilder psDesifrovanyRetezec = new StringBuilder();
        for(int index = 0; index < psRetezec.length(); index++){
            psDesifrovanyRetezec.append(vratPosunutyZnakZpet(apAbeceda, aiVelikost, psRetezec.charAt(index), posun));
        }
        System.out.println("Desifrovany text je: " + psDesifrovanyRetezec.toString());
    }

    public static void main(String[] args) {
        boolean konec = false;
        while(!konec){
            System.out.println("\n--- Caesarova sifra ---");
            System.out.println("1) Sifrovat");
            System.out.println("2) Desifrovat");
            System.out.println("3) Konec");
            System.out.print("Vyber volbu (1-3): ");
            String volba = scanner.nextLine().trim();
            switch(volba){
                case "1":
                    zasifruj(abeceda, VELIKOST_POLE);
                    break;
                case "2":
                    desifruj(abeceda, VELIKOST_POLE);
                    break;
                case "3":
                    konec = true;
                    break;
                default:
                    System.out.println("Neplatna volba, zkus to znovu.");
            }
        }
        System.out.println("Program ukoncen.");
        scanner.close();
    }
}

