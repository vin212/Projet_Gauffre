package src;

import javax.swing.*;

import modele.Gauffre;


public class Fenetre implements Runnable {

	Gauffre g;

	public Fenetre (Gauffre g)
	{
		this.g = g;
	}

	public void run() {

		g.AfficherGauffre_CMD ();
		JFrame frame = new JFrame("Jeu Gauffre");
		frame.add(new AireDeDessin(g));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}

}