package gestion_bouton;

import modele.Gauffre;
import controller.Controller;
import components.AireDeDessin;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class ButonReset extends JButton implements ActionListener
{
	Gauffre gauf;
	Controller ctrl;
	AireDeDessin aire;
	JLabel mort;
	JLabel label;

	
	public ButonReset (Gauffre gauf, AireDeDessin aire,JLabel mort,JLabel label)
	{
		this.mort = mort;
		this.gauf = gauf;
		this.aire = aire;
		this.label = label;
		ctrl = new Controller(this.gauf);
	}

	public void actionPerformed(ActionEvent e) 
	{
 		ctrl.restart();
 		aire.repaint();

 		mort.setText("");
 		mort.repaint();

 		label.setText("Au joueur " + 1 + " de jouer");
 		label.repaint();
	}
}