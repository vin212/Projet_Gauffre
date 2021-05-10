package src;

import javax.swing.*;

import java.awt.*;

import modele.Gauffre;
import gestion_bouton.*;
import controller.*;

//import src.AireDeDessin;


public class Fenetre implements Runnable {

	Gauffre g;
	IA iaaleatoire;
	IA ia;
	IA ianon;

	public Fenetre (Gauffre g)
	{
		this.g = g;
	}

	public void run() {

		g.AfficherGauffre_CMD ();
		JFrame frame = new JFrame("Jeu Gauffre");

		JLabel label = new JLabel("Au joueur " + (g.getTour() %2 + 1) + " de jouer");
		JLabel mort = new JLabel("");
		JButton bouton = new JButton("Reset");

		//ia.MettreGauffre(this.g);
		//ia = null;
		//System.out.println(ia);

		

		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 400);
		frame.setVisible(true);

		AireDeDessin aire= new AireDeDessin	(this.g);
		bouton.addActionListener(new ButonReset(this.g,aire,mort,label));

		JPanel container = new JPanel();
		container.setPreferredSize(new Dimension(150, 400));
		container.add(bouton);

		bouton = new JButton("Retour");
		bouton.addActionListener(new ButonRetour(this.g,aire));
		container.add(bouton);

		bouton = new JButton("Retablir");
		bouton.addActionListener(new ButonRetablir(this.g,aire));
		container.add(bouton);

		bouton = new JButton("ActiverIA");
		bouton.addActionListener(new ButonActiverIA(this.g,aire,ia));
		container.add(bouton);


		System.out.println(g.getTour());
	
		container.add(label);

		
		container.add(mort);







		frame.add(container, BorderLayout.EAST);
		frame.add(aire, BorderLayout.CENTER);



		aire.addMouseListener(new EcouteurDeSouris(aire,label,mort,ia));
	}

}