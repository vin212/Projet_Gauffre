package controller;

import modele.Gauffre;
import structure.Point;
import java.util.List;

public class Controller {

    List<Gauffre> backup;
    
    void restart(Gauffre g){
        g = new Gauffre(g.hauteur(),g.longueur());
    }

    void annulerTour(Gauffre g){
        Gauffre save = g.Clone();
        backup.add(save);
        int tourPrec = g.getTour() -1 ;
        for (int i = 0; i< g.hauteur(); i++){
            for (int j = 0; j<g.longueur(); j++){
                Point p = new Point (i,j);
                if (g.ValeurTourCarre(p) == tourPrec){
                    g.RemettreUnCarre(p);
                }
            }
        }
        g.DecrementeTour();
    }
    

    void retablirTour(Gauffre g){
        g = backup.get(backup.size() -1);
        backup.remove(backup.size() -1);
        g.IncrementeTour();
    }

    boolean Tour(Gauffre g, Point p){
        boolean aPerdu = false;
        if(!g.EstManger(p)){
            backup.clear();
            for(int i = p.getx(); i<g.hauteur(); i++){
                for (int j = p.gety(); j<g.longueur(); j++){
                    Point point = new Point(i,j);
                    if(!g.EstManger(point)){
                        g.MangerUnCarre(point);
                    }
                    if(g.EstPourri(p)){
                        aPerdu = true;
                    }
                }
            }
            g.IncrementeTour();
        }

        else{
            //temp
            System.err.println("Coup invalide");
        }
        return aPerdu;
    }
}
