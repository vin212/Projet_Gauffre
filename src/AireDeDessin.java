package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.util.Scanner;

import modele.Gauffre;
import structure.Point;
import controller.Controller;


public class AireDeDessin extends JComponent {
	int counter;
	Image plein;
	Image poison;
	Image vide;
	Gauffre gauf;
	Controller contr;

	public AireDeDessin(Gauffre g) {
		this.gauf = g;
		contr = new Controller(g);
		try {
			InputStream in = new FileInputStream("ressource/texture/plein.png");
			plein = ImageIO.read(in);
			in = new FileInputStream("ressource/texture/poison.png");
			poison = ImageIO.read(in);
			in = new FileInputStream("ressource/texture/vide.png");
			vide = ImageIO.read(in);
		} catch (Exception e) {
			System.out.print("erreur \n");
			System.exit(1);
		}
		counter = 1;
	}

	public boolean MangerMorceau (int x, int y)
	{
		boolean estMort;
		int taille_x =  getSize().height / (gauf.hauteur() ) ;
		int taille_y =  getSize().width / (gauf.longueur() ) ;

		Point p = new Point(y/taille_x,x/taille_y);
		System.out.print("\n" + p.getx() + " " + p.gety() + "\n");
		estMort = contr.Tour(p);
		this.repaint();

		return estMort;
	}

	public boolean MangerMorceauIA (Point p)
	{
		boolean estMort;

		System.out.println("\n ici \n"); 
		System.out.print("\n ia joueur : " + p.getx() + " " + p.gety() + "\n");
		estMort = contr.Tour(p);
		this.repaint();

		return estMort;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D drawable = (Graphics2D) g;




		int width = getSize().width;
		int height = getSize().height;

		System.out.println(width + " " + height + "\n");

		Point center = new Point(width/2, height/2);

		int taille_x = height / (gauf.hauteur() ) ;
		int taille_y =  width / (gauf.longueur() ) ;


		Point p;

		drawable.clearRect(0, 0, width, height);


		for (int i = 0; i < gauf.hauteur(); i++)
		{
			
			for (int j = 0; j < gauf.longueur(); j++)
			{
				p = new Point(i,j);

				if (gauf.EstPourri(p))
				{
					drawable.drawImage(poison, j * taille_y , i * taille_x , taille_y , taille_x , null);
				}
				else if (!gauf.EstManger(p))
				{
					drawable.drawImage(plein, j * taille_y , i * taille_x , taille_y , taille_x , null);
				}
				else
				{
					drawable.drawImage(vide, j * taille_y , i * taille_x , taille_y , taille_x , null);
				}
			}

		}

		for (int i = 0; i < gauf.hauteur(); i++)
		{
			drawable.drawLine(0 ,(i+1) * taille_x  , gauf.longueur() * taille_y  ,(i+1) * taille_x );
			for (int j = 0; j < gauf.longueur(); j++)
			{
				drawable.drawLine((j+1) * taille_y, 0 ,(j+1) * taille_y, gauf.hauteur() * taille_x );
			}
		}
	}
}