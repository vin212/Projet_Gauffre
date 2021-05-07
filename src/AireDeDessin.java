package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.util.Scanner;

import modele.Gauffre;
import structure.Point;


class AireDeDessin extends JComponent {
	int counter;
	Image plein;
	Image poison;
	Image vide;
	Gauffre gauf;

	public AireDeDessin(Gauffre g) {
		this.gauf = g;
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

	//@Override
	public void paintComponent(Graphics g) {
		Graphics2D drawable = (Graphics2D) g;

		int width = getSize().width;
		int height = getSize().height;

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