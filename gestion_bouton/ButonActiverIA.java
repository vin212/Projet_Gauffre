package gestion_bouton;

import modele.Gauffre;
import controller.Controller;
import src.AireDeDessin;
import controller.IA;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class ButonActiverIA extends JButton implements ActionListener
{
	Gauffre gauf;
	Controller ctrl;
	AireDeDessin aire;
	IA ia;
	
	public ButonActiverIA (Gauffre gauf, AireDeDessin aire, IA ia)
	{
		
		this.gauf = gauf;
		this.aire = aire;
		this.ia = ia;
		ctrl = new Controller(this.gauf);
	}

	public void actionPerformed(ActionEvent e) 
	{
 		ia.ActiveIA();
	}
}