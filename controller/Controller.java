package controller;

import modele.Gauffre;
import structure.Point;
import java.util.*;

public class Controller {

    List<Gauffre> backup;
    Gauffre g;

    public Controller (Gauffre g)
    {
        this.g = g;
        backup = new ArrayList<Gauffre>();
    }
    
    public void restart(){
        g.AfficherGauffre_CMD ();
        System.out.println("rest");

        Point p;
        for (int i = 0; i < g.hauteur(); i++)
        {
            for (int j = 0; j < g.longueur(); j++)
            {
                p = new Point(i,j);
                this.g.RemettreUnCarre(p);
            }
        }

        while (this.g.getTour() > 0)
        {
            this.g.DecrementeTour();
        }

        

        System.out.println(this.g.getNbRestant ());
        g.AfficherGauffre_CMD ();
    }

    public void annulerTour(){
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
    

    public void retablirTour(){
        g = backup.get(backup.size() -1);
        backup.remove(backup.size() -1);
        g.IncrementeTour();
    }

    public boolean Tour(Point p){
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
