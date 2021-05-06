public class Morceau {
    
    private boolean poison;
    private boolean mange;
    private int tourMange;

    public Morceau (int x, int y){
        this.poison = false;
        this.mange = false;
        if (x == 0 && y == 0){
            this.poison = true;
        }
        this.tourMange = -1;
    }

    //Définie une case comme mangée (donc jouée)
    void setMange(boolean state){
        this.mange = state;
    }

    //Retoune vrai si la case est mangée, faux sinon
    boolean getMange(){
        return this.mange;
    }

    //Retourne vrai si la case porte le poison 
    //nota : retournera vrai uniquement pour la case 1,1
    boolean getPoison(){
        return this.poison;
    }

    //Retoune le tour où la case fut mangée, -1 si elle ne l'est pas
    int getTour(){
        return this.tourMange;
    }

    //Défine le tour auquel la case est mangée
    //-1 est passé en argument lors de l'annulation d'un tour
    void setTour(int tour){
        this.tourMange = tour;
    }

}
