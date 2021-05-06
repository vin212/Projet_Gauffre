import java.util.*;

public class Gauffre{

    private Morceau[][] map = new Morceau [5][4];
    private int tour;

    public Gauffre(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 4; j++){
                map[i][j] = new Morceau(i,j);
            }
        }
        this.tour = 0;
    }

    //Joue à un coup à la case ij
    boolean coup(int i,int j){
        boolean aPerdu = false;
        for (int k = i-1; k < 5; k++){
            for (int v = j-1; v < 4; v++){
                if(!(map[k][v].getMange())){
                    map[k][v].setMange(true);
                    map[k][v].setTour(this.tour);
                    if (map[k][v].getPoison()){
                        aPerdu = true;
                    }
                }
            }
        }
        this.tour++;
        return aPerdu;
    }

    //Annule le dernier our joué
    void annulerTour(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 4; j++){
                if (map[i][j].getMange() && map[i][j].getTour() == (this.tour -1)){
                    map[i][j].setMange(false);
                    map[i][j].setTour(-1);
                }
            }
        }
        this.tour--;
    }

    //fonction de test pour la construction
    void afficheGauffre(){
        for (int k = 0; k < 4; k++){
            for (int v = 0; v < 5; v++){
                if (this.map[v][k].getMange()){
                    System.out.print("M ");
                }
                else{
                    if(this.map[v][k].getPoison()){
                        System.out.print("X ");
                    }
                    else{
                        System.out.print("O ");
                    }
                }
            }
            System.out.println();
        }
    }
}
