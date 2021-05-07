package controller;

import modele.Gauffre;
import structure.Point;

public class Controller {

    void annulerTour(Gauffre g){
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

    boolean Tour(Gauffre g, Point p){
        boolean aPerdu = false;
        if(!g.EstManger(p)){
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
