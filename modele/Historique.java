package modele;

import structure.Point;

public class Historique{
    Gauffre gMax;
    Gauffre gDepl;
    boolean A;
    boolean R;

    public Historique(Gauffre gauffre){
        gMax = gauffre.Clone();
        gDepl = gauffre.Clone();
        R = true;
        A = false;
    }

    // Utiliser après chaque coup fait sur la gauffre de jeu
    // Surtout ne pas appeler lors des retours et avancer dans l'historique
    // Permet d'avoir la version la plus recente de la gauffre
    public void Actualiser(Gauffre gauffre){
        gMax = gauffre.Clone();
        gDepl = gauffre.Clone();
        R = true;
        A = false;
    }

    // Fait un retour
    public Gauffre Revenir(){
        if(!R){
            return gDepl;
        }
        gDepl.Retour();
        if(gDepl.getTour() == 0){
            R = false;
        }
        A = true;
        return gDepl;
    }

    // Avance vers le tour dans l'historique
    public Gauffre Avancer(){

        if(!A){
            return gDepl;
        }
        Gauffre gTemp = gMax.Clone();
        Point p;
        int val;
        for(int i=0;i < gTemp.hauteur();i++){
            for(int j=0;j < gTemp.longueur();j++){
                p = new Point(j,i);
                val = gTemp.ValeurTourCarre(p);
                if (val >= ((gDepl.getTour())+1)){
                    gTemp.RemettreUnCarre(p);
                }
            }
        }
        while(gTemp.getTour() != (gDepl.getTour() + 1)){
            gTemp.DecrementeTour();
        }
        gDepl = gTemp;
        if(gDepl.getTour() == gMax.getTour()){
            A = false;
        }
        R = true;
        return gTemp;
    }

    // Retour directement a l'etat du dernier coup jouer
    public Gauffre Retour(){
        gDepl = gMax.Clone();
        return gMax;
    }
}