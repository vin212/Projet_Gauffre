package src;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.*;

import src.AireDeDessin;

public class EcouteurDeSouris extends MouseAdapter {
	AireDeDessin aire;

	EcouteurDeSouris(AireDeDessin a) {
		aire = a;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX() + "," + e.getY());
		aire.MangerMorceau(e.getX(), e.getY());
		//aire.repaint();
	}
}
