package controller;

import java.util.ArrayList;
import java.util.Random;

import modele.Gauffre;
//import Controller.controller;
import structure.Point;

public class IANon extends IA {
    Random r;
    Gauffre g;
    //Logger log;

    public IANon(Gauffre gauffre){
        r = new Random((long) 0);
        g = gauffre;
    }

    @Override
    public void initialise(){
        /*log = Configuration.instance().logger();
        log.info("Activation de l'IA Non perdante.");*/
    }

    public Point joue(){
        int hauteur = g.hauteur();
        int longueur = g.longueur();
        boolean ligne = true;
        boolean col = true;
        // Uniformité de la première ligne et colonne
        for (int i = 2; i < hauteur; i++ ){
            ligne = ligne && (g.EstManger(new Point(i-1, 0)) == g.EstManger(new Point(i, 0)) );
        }
        for (int j = 1; j < hauteur; j++ ){
            col = col && (g.EstManger(new Point(0, j-1)) == g.EstManger(new Point(0, j)) );
        }
        // Colonne et ligne manges donc plus de choix
        if ((col && ligne) && g.EstManger(new Point(1, 0)) && g.EstManger(new Point(0, 1))) {
            return new Point(0, 0);
        }    
        // Colonne mange mais pas ligne
        else if ( col && g.EstManger(new Point(0, 1)) ) {
            return new Point(1,0);
        }    
        // Ligne mange mais pas colonne
        else if ( ligne && g.EstManger(new Point(1, 0)) ){
            return new Point(0,1);
        }
        // Ni la ligne ni la colonne n'est mange
        else {
            ArrayList<Point> liste = new ArrayList<Point>(0);
            for (int i = 1; i < hauteur; i++){
                for (int j = 1; j < longueur; j++){
                    Point p = new Point(i, j);
                    if (!g.EstManger(p) && !g.EstPourri(p)){
                        liste.add(p);
                    }
                }
            }
            int taille = liste.size();
            if (taille == 0){
                //log.info("Erreur IA, suicide.");
                return new Point(0, 0);
            }
            return liste.get(r.nextInt(taille));
        }
    }
}
