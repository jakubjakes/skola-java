public class Zvire {
    private String msJmeno;
    private int hodinyOdKrmeni;
    private int jeVzhuru;
    private boolean spi = false;
    private int zbyleHodinySpanku;
    private final int hlad_limit = 3;
    private final int unava_limit = 6;
    private final int smrt_limit = 6;
    //static boolean smrt = false;
    private final int DOBA_SPANKU = 6;
   public Zvire(String asJmeno){
   msJmeno = asJmeno;
   }
   public String vratJmeno(){
       return msJmeno;
}
   public void nakrmit(){
    hodinyOdKrmeni = 0;
    System.out.println("nakrmil jsi zviratko");
}
 
    public void ulozitSpat(){
        if(!spi){
        spi = true;
        zbyleHodinySpanku = DOBA_SPANKU;
        jeVzhuru = 0;
        System.out.println(msJmeno + "slo spat, bude spat : " + DOBA_SPANKU);
        }else {
        System.out.println("uz spi");
        }   
    }
    public boolean smrt(){
    if (hodinyOdKrmeni >= smrt_limit || jeVzhuru >= smrt_limit) {
        System.out.println("!! " + msJmeno + " bohuzel zemrelo! Bylo hladové nebo prilid unavenr.");
        return true;
    }
    return false;
}
   public void volby(){
    System.out.println("Co chces delat?");
    if(hodinyOdKrmeni >= hlad_limit) {
        System.out.println("[1] Nakrmit (" + msJmeno + " je hladove!)");
    } else {
        System.out.println("[1] Nakrmit");
    }
    // Volba 2: Spánek (dostupná, když je zvíře vzhůru a unavené)
    if(jeVzhuru >= unava_limit && !spi) {
        System.out.println("[2] Dat spat (" + msJmeno + " je unavena!)");
    } else if (!spi){
        System.out.println("[2] Dat spat");
    }
    System.out.println("[3] Nic (Uplyne hodina)"); 
}
   public void tikCasu(){
    if (spi) {
        zbyleHodinySpanku--; 
        System.out.println(msJmeno + " spí. Zbývá " + zbyleHodinySpanku + " hodin.");
        if (zbyleHodinySpanku <= 0) {
            spi = false; 
            jeVzhuru = 0; 
            System.out.println(msJmeno + " se probudilo a je odpočaté!");
        }
    } else {
        hodinyOdKrmeni++; 
        jeVzhuru++;     
    }
    }

    public void vypisStav() {
    System.out.println("--- Stav " + msJmeno + " ---");
    System.out.println("Hlad: " + hodinyOdKrmeni + "/" + hlad_limit);
    System.out.println("Únava: " + jeVzhuru + "/" + unava_limit);
    if (spi) {
        System.out.println("Stav: Spí (" + zbyleHodinySpanku + " h do probuzení)");
    } else {
        System.out.println("Stav: Vzhůru");
    }
}
}
