package gestion_bouton;

import modele.Gauffre;
//import controller.Controller;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class ButonReset extends JButton implements ActionListener
{
	Gauffre gauf;
	Controller ctrl;
	
	public ButonReset (Gauffre gauf)
	{
		this.gauf = gauf;
	}

	public void actionPerformed(ActionEvent e) 
	{
 		ctrl.restart(gauf);
	}
}