import modele.Gauffre;
import modele.Historique;
import structure.Point;
import src.Fenetre;


public class TestHistorique {
    public static void main (String[] argc){
        System.out.println("Hello World !");

        System.out.println("gauffre de depart :");
		Gauffre g = new Gauffre(4,5);
        Historique H = new Historique(g);
		g.AfficherGauffre_CMD ();

        // enleve (3,3)
        System.out.println("On mange (3,3) :");
		Point p = new Point(3,3);
		g.MangerUnCarre(p);
        g.IncrementeTour();
        H.Actualiser(g);
		System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

        // enleve (2,3)
        System.out.println("On mange (2,3) :");
        p = new Point(2,3);
		g.MangerUnCarre(p);
        g.IncrementeTour();
        H.Actualiser(g);
        System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

        System.out.println("On revient en arriere :");
        g = H.Revenir();
        System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

        System.out.println("On revient en arriere :");
        g = H.Revenir();
        System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

        System.out.println("On retourne en arriere mais on peut pas alors on bouge pas :");
        g = H.Revenir();
        System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

        System.out.println("On revient en avant :");
        g = H.Avancer();
        System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

        System.out.println("On revient en avant :");
        g = H.Avancer();
        System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

        System.out.println("On avance mais on peut pas alors on bouge pas :");
        g = H.Avancer();
        System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

        System.out.println("On recule et revient avec retour :");
        g = H.Revenir();
        g = H.Revenir();
        g = H.Retour();
        System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

		p = new Point(0,0);
		System.out.println(g.EstPourri(p));
    }
}
