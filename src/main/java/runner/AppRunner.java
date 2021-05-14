package runner;
import javax.swing.*;

import modele.Gauffre;
import structure.Point;
import components.Fenetre;


public class AppRunner 
{

	public static void main(String[] args)

	{
		System.out.println("Hello World !");
		Gauffre g = new Gauffre(4,4);	


		SwingUtilities.invokeLater(new Fenetre(g));
	}
}