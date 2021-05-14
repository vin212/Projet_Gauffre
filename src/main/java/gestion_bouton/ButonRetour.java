package gestion_bouton;

import modele.Gauffre;
import controller.Controller;
import components.AireDeDessin;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class ButonRetour extends JButton implements ActionListener
{
	Gauffre gauf;
	Controller ctrl;
	AireDeDessin aire;
	
	public ButonRetour (Gauffre gauf, AireDeDessin aire)
	{
		
		this.gauf = gauf;
		this.aire = aire;
		ctrl = new Controller(this.gauf);
	}

	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("retour");
 		ctrl.annulerTour();
 		aire.repaint();
	}
}