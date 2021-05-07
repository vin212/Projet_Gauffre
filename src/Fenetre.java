package src;

import javax.swing.*;

import modele.Gauffre;
//import src.AireDeDessin;


public class Fenetre implements Runnable {

	Gauffre g;

	public Fenetre (Gauffre g)
	{
		this.g = g;
	}

	public void run() {

		g.AfficherGauffre_CMD ();
		JFrame frame = new JFrame("Jeu Gauffre");
		AireDeDessin aire = new AireDeDessin(this.g);
		frame.add(aire);
		aire.addMouseListener(new EcouteurDeSouris(aire));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}

}