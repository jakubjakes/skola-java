public class Farmig_simulator {
 
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int volba = 0;
        int mesic = 1;
        int pole1 = -1;
        int pole2 = -1;

        while(volba != 4){
            System.out.println("----------------" + mesic +" mesic");
            if(pole1 == -1) System.out.println("pole 1 prazdne");
            else if(pole1 >= 5) System.out.println("pole 1 shnilo");
            else if(pole1 >= 3) System.out.println("pole 1 zrale");
            else System.out.println("pole 1 roste "+ pole1 + " mesic");
            if(pole2 == -1)System.out.println("pole 2 prazdne");
            else if(pole2 >= 5) System.out.println("pole 2 shnilo");
            else if(pole2 >= 3) System.out.println("pole 2 zrale");
            else System.out.println("pole 2 roste " + pole2 +" mesic" );



            System.out.println("zasit(1) sklidit(2)  nic(3) konec(4)");
            volba = Integer.parseInt(System.console().readLine());
            if(volba == 1) {
            System.out.println("na ktere pole 1/2?");
            volba = Integer.parseInt(System.console().readLine());
                if(volba == 1 && pole1 == -1){
                pole1=0;
                System.out.println("zaseto na pole 1");
                }
                if(volba == 2 && pole2 == -1){
                pole2=0;
                System.out.println("zaseto na pole 2");
                }else System.out.println("pole neni volne");
            }else if(volba ==2) {
            System.out.println("ktere pole chces sklidit 1/2 ?");
            volba = Integer.parseInt(System.console().readLine());
                if(volba == 1 && pole1 >= 3 && pole1 <5){
                pole1=-1;
                System.out.println("sklizeno pole 1");
                }
                if(volba == 2 && pole2 >= 3 && pole2 <5 ){
                pole2=-1;
                System.out.println("sklizeno na poli 2");
                }
            }else if(volba ==3) {System.out.println("tenhle mesic nic nedelas");
            }else {System.out.println("neplatna volba");}

            if(pole1 >=0) pole1++;
            if(pole2 >=0) pole2++;
            if(pole1 >= 5){
            System.out.println("pole 1 zhnilo");
            pole1 = -1;
            }
            if(pole2 >= 5){
            System.out.println("pole 2 zhnilo");
            pole2 = -1;
            }
         mesic++; 
        }


    }
}