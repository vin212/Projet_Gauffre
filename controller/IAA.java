package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import modele.Gauffre;
import structure.Point;

public class IAA extends IA{
    Random r;
    //Logger log;
    
    public IAA()
    {

    }

    public IAA(Gauffre gauffre){
        g = gauffre;
    }

    /*@Override
    public void initialise(){
        log = Configuration.instance().logger();
        log.info("Activation de l'IA.");
    }*/

    @Override
    public Point joue(){

        System.out.println("debut affiche");

        g.AfficherGauffre_CMD ();

        System.out.println("fin affiche");
        Controller control = new Controller(this.g);
        ArrayList<Point> coup = successeur(g);
        ArrayList<Point> gagnant = new ArrayList<Point>();
        Iterator<Point> I = coup.iterator();
        Random r = new Random();
        boolean trouve = false;
        boolean feuille;
        Point p;

        // On a une feuille et donc que le poison de mangeable
        // defaite inevitable
        if (coup.size() == 1){
            return I.next();
        }
        // Sinon
        while(I.hasNext()){
            p = I.next();
            System.out.println(p.getx() + " " + p.gety());
            control.Tour(p);
            trouve = Calcul_toi(g);
            if (trouve){
                gagnant.add(p);
            }
            control.annulerTour();
        }
        System.out.println(gagnant);
        return gagnant.get(r.nextInt(gagnant.size()));
    }

    private boolean Calcul_moi(Gauffre g){
        Controller control = new Controller(g);
        ArrayList<Point> coup = successeur(g);
        ArrayList<Point> gagnant = new ArrayList<Point>();
        Iterator<Point> I = coup.iterator();
        boolean trouve = false;
        Point p;

        // Si config final
        if (g.EstManger(new Point(1, 0)) && g.EstManger(new Point(0, 1))) {
            if (g.EstManger(new Point(0,0)))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        while(!trouve && I.hasNext()){
            p = I.next();
            control.Tour(p);
            trouve = Calcul_toi(g);
            control.annulerTour();
        }
        return trouve;
    }

    private boolean Calcul_toi(Gauffre g){
        Controller control = new Controller(g);
        ArrayList<Point> coup = successeur(g);
        ArrayList<Point> gagnant = new ArrayList<Point>();
        Iterator<Point> I = coup.iterator();
        boolean trouve = true;
        Point p;

        // Si config final
        if (g.EstManger(new Point(1, 0)) && g.EstManger(new Point(0, 1))){
            if (g.EstManger(new Point(0,0)))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        while(I.hasNext()){
            p = I.next();
            control.Tour(p);
            trouve = trouve && Calcul_moi(g);
            control.annulerTour();
        }
        return trouve;
    }

    // Liste des points selectionnables lors d'une config g
    private ArrayList<Point> successeur(Gauffre g){
        int hauteur = g.hauteur();
        int longueur = g.longueur();
        ArrayList<Point> liste = new ArrayList<Point>(0);
        for (int i = 0; i < hauteur; i++){
            for (int j = 0; j < longueur; j++){
                Point p = new Point(i, j);
                if (false == g.EstManger(p)){
                    liste.add(p);
                }
            }
        }
        return liste;
    }

}
