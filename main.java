import javax.swing.*;

import modele.Gauffre;
import structure.Point;
import src.Fenetre;


public class main 
{
	public static void main (String[] argc)
	{
		System.out.println("Hello World !");
		Gauffre g = new Gauffre(5,7);	

		g.AfficherGauffre_CMD ();

		Point p = new Point(3,3);
		g.MangerUnCarre(p);
		System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();

		p = new Point(0,0);
		System.out.println(g.EstPourri(p));

		System.out.println();
		Gauffre gauf = g.Clone();

		gauf.AfficherGauffre_CMD ();
		p = new Point(2,2);
		gauf.MangerUnCarre(p);

		System.out.println();
		g.AfficherGauffre_CMD ();
		System.out.println();
		System.out.println();
		gauf.AfficherGauffre_CMD ();
		System.out.println();



		SwingUtilities.invokeLater(new Fenetre(g));
		SwingUtilities.invokeLater(new Fenetre(gauf));
	}
}