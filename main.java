import javax.swing.*;

import modele.Gauffre;
import structure.Point;
import src.Fenetre;


public class main 
{

	public static void main(String[] args)

	{
		System.out.println("Hello World !");
		Gauffre g = new Gauffre(5,7);	



		SwingUtilities.invokeLater(new Fenetre(g));
	}
}