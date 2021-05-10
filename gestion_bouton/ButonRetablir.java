package gestion_bouton;

import modele.Gauffre;
import controller.Controller;
import src.AireDeDessin;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class ButonRetablir extends JButton implements ActionListener
{
	Gauffre gauf;
	Controller ctrl;
	AireDeDessin aire;
	
	public ButonRetablir (Gauffre gauf, AireDeDessin aire)
	{
		
		this.gauf = gauf;
		this.aire = aire;
		ctrl = new Controller(this.gauf);
	}

	public void actionPerformed(ActionEvent e) 
	{
 		ctrl.retablirTour();
 		aire.repaint();
	}
}