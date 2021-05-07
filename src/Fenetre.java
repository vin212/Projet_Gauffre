package src;

import javax.swing.*;

import java.awt.*;

import modele.Gauffre;
import gestion_bouton.ButonReset;

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
		JButton bouton = new JButton("Mon bouton");

		bouton.addActionListener(new ButonReset(this.g));

		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);

		AireDeDessin aire= new AireDeDessin	(g);

		JPanel container = new JPanel();
		container.setPreferredSize(new Dimension(100, 400));
		container.add(bouton);

		frame.add(container, BorderLayout.EAST);
		frame.add(aire, BorderLayout.CENTER);



		aire.addMouseListener(new EcouteurDeSouris(aire));
	}

}