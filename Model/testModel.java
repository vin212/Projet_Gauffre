public class testModel {
    
    public static void main(String []args){
        Gauffre maGauffre = new Gauffre();
        maGauffre.afficheGauffre();

        boolean statusGame;

        statusGame =  maGauffre.coup(2,3);
        System.out.println();
        maGauffre.afficheGauffre();

        if(statusGame){
            System.out.println("perdu!");
        }
        else{
            System.out.println("ok");
        }

        statusGame = maGauffre.coup(1,2);
        System.out.println();
        maGauffre.afficheGauffre();

        if(statusGame){
            System.out.println("perdu!");
        }
        else{
            System.out.println("ok");
        }

        maGauffre.annulerTour();
        System.out.println();
        maGauffre.afficheGauffre();

        maGauffre.annulerTour();
        System.out.println();
        maGauffre.afficheGauffre();

        statusGame = maGauffre.coup(1,1);
        System.out.println();
        maGauffre.afficheGauffre();

        if(statusGame){
            System.out.println("perdu!");
        }
        else{
            System.out.println("ok");
        }

    }

}
