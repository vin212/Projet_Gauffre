package components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import components.AireDeDessin;
import controller.IA;
import structure.Point;

public class EcouteurDeSouris extends MouseAdapter {
	AireDeDessin aire;
	JLabel label;
	JLabel mort;
	IA ia;

	EcouteurDeSouris(AireDeDessin a,JLabel label, JLabel mort, IA ia) {
		aire = a;
		this.label = label;
		this.mort = mort;
		this.ia = ia;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX() + "," + e.getY());
		boolean estMort = aire.MangerMorceau(e.getX(), e.getY());

		label.setText("Au joueur " + (aire.gauf.getTour() %2 + 1) + " de jouer");
		label.repaint();

		aire.repaint();

		System.out.println("id : " + ia);
		if (ia != null && (aire.gauf.getTour() %2 + 1) == 2 && ia.estActive() && !estMort)
		{
			System.out.println("je joue"); 
			Point p = ia.joue();
			System.out.println("fin joue");
			estMort = aire.MangerMorceauIA(p);
			
			try 
			{
				TimeUnit.SECONDS.sleep(1);
			}
		    catch (Exception err)
			{
				System.out.println("Erreur");
			}
		} 

		label.setText("Au joueur " + (aire.gauf.getTour() %2 + 1) + " de jouer");
		label.repaint();

		if (estMort)
		{
			mort.setText("RIP Tu es mort : " + ((aire.gauf.getTour() %2 + 1) % 2 + 1 ));
		}

		mort.repaint();
	}
}
