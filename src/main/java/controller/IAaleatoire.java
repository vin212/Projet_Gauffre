package controller;

import java.util.ArrayList;
import java.util.Random;

import modele.Gauffre;
//import Controller.controller;
import structure.Point;

public class IAaleatoire extends IA {
    Random r;
    //Logger log;

    public IAaleatoire(Gauffre gauffre){
        r = new Random((long) 0);
        g = gauffre;
    }

    public IAaleatoire(){
        r = new Random((long) 0);
    }


    // Fonction de démarage de l'IA
    @Override
    public void initialise(){
        /*log = Configuration.instance().logger();
        log.info("Activation de l'IA Aléatoire.");*/
    }

    @Override
    


    // Joue un coup de façon aléatoire.
    public Point joue(){
        int hauteur = g.hauteur();
        int longueur = g.longueur();
        ArrayList<Point> liste = new ArrayList<Point>(0);
        for (int i = 0; i < hauteur; i++){
            for (int j = 0; j < longueur; j++){
                Point p = new Point(i, j);
                if (false == g.EstManger(p) && false == g.EstPourri(p)){
                    liste.add(p);
                }
            }
        }

        int taille = liste.size();
        if (taille == 0){
            return new Point(0, 0);
        }
        return liste.get(r.nextInt(taille));
    }
}
