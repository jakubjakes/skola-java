public class tamagochi {
    public static void main(String[] args) {
        System.out.println("cau");




        System.out.println("Zadej jmeno potvory");
      String jmeno = "Nezadano";
      jmeno = System.console().readLine();
      System.out.println(jmeno + " se narodil/a");  

      int hodina = 1;
      int hlad = 0;
      int spani = 0;
      int volba = 0;

      while(hlad < 6){/* kdyz spi*/
          System.out.println("------------------"+hodina+" hodina----------------");
      if(spani > 0){
          System.out.println(jmeno +" spi musis pockat. Probudi se za" + spani);
          System.out.println("co chces delat");
          System.out.println("nic(3)");
          volba = Integer.parseInt(System.console().readLine());
        spani--;
      }else{
      System.out.println("co chces udelat");
      if(hlad >=3){
        System.out.println("nakrmit(1)");
        System.out.println("spat(2)");
        System.out.println("nic(3)");
      }else{
        System.out.println("spat(2)");
        System.out.println("nic(3)");
        }
      volba = Integer.parseInt(System.console().readLine());
      if(hlad>=3){
          if(volba==1){
            hlad = 0;
            System.out.println("Nakrmil jsi " + jmeno +" Ted mas 3 hodky laces.");
          }else if(volba==2){
            spani=6;
            System.out.println(jmeno+ " bude spat dalsich 6 hodin");
          }
      }else{
          if(volba==1){
              spani=6;
              System.out.println(jmeno+" bude chrapat 6 hodin");
          }
      }
      if(spani==0){
        hlad++;
      }
      }
      if(hlad>=6){
          System.out.println(jmeno + "umrel/a");
          /*break;*/
      } 
      hodina++;
      }
    }
    
}
