import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class IAA {
    Random r;
    Gauffre g;
    Logger log;
    
    public IAA(Gauffre gauffre){
        g = gauffre;
    }

    @Override
    public void initialise(){
        log = Configuration.instance().logger();
        log.info("Activation de l'IA.");
    }

    public Point Joue(){
        Controller control = new Controller(g);
        ArrayList<Point> coup = successeur(g);
        ArrayList<Point> gagnant = new ArrayList<Point>();
        Iterator<Point> I = coup.Iterator();
        Random r;
        boolean trouve = false;
        boolean feuille;
        Point p;

        // On a une feuille et donc que le poison de mangeable
        // defaite inevitable
        if (successeur.size() == 1){
            return I.next();
        }
        // Sinon
        while(I.hasNext()){
            p = I.next();
            control.Tour(g,p);
            trouve = Calcul_toi(g);
            if (trouve){
                gagnant.add(p);
            }
            control.annulerTour();
        }
        return gagnant.get(r.nextInt(gagnant.size()));
    }

    private boolean Calcul_moi(Gauffre g){
        Controller control = new Controller(g);
        ArrayList<Point> coup = successeur(g);
        ArrayList<Point> gagnant = new ArrayList<Point>();
        Iterator<Point> I = coup.Iterator();
        boolean trouve = false;
        Point p;

        // Si config final
        if (g.EstManger(new Point(1, 0)) && g.EstManger(new Point(0, 1))) {
            return false;
        }
        while(!trouve && I.hasNext()){
            p = I.next();
            control.Tour(g,p);
            trouve = Calcul_toi(g);
            control.annulerTour();
        }
        return trouve;
    }

    private boolean Calcul_toi(Gauffre g){
        Controller control = new Controller(g);
        ArrayList<Point> coup = successeur(g);
        ArrayList<Point> gagnant = new ArrayList<Point>();
        Iterator<Point> I = coup.Iterator();
        boolean trouve = true;
        Point p;

        // Si config final
        if (g.EstManger(new Point(1, 0)) && g.EstManger(new Point(0, 1))){
            return true;
        }
        while(I.hasNext()){
            p = I.next();
            control.Tour(g,p);
            trouve = trouve && Calcul_moi(g);
            control.annulerTour();
        }
        return trouve;
    }

    // Liste des points selectionnables lors d'une config g
    private ArrayList<Point> successeur(Gauffre g){
        int hauteur = g.hauteur;
        int longueur = g.longueur;
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
