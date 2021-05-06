package modele;

import structure.Point;

public class Gauffre 
{
	private int gauffre[][];
	private Point pourri;
	private int hauteur;
	private int longueur;
	private int nb_tour;

	public Gauffre (int hauteur, int longueur)
	{
		this.gauffre = new int [hauteur][longueur];
		this.pourri = new Point (0,0);
		this.hauteur = hauteur;
		this.longueur = longueur;
		nb_tour = 0;


		InitGauffre();
	}

	public Boolean EstPourri (Point p)
	{
		return (p.getx() == pourri.getx() && p.gety() == pourri.gety());
	}

	public Boolean EstManger (Point p)
	{
		return (gauffre[p.gety()][p.getx()] != -1) ;
	}

	public void MangerUnCarre (Point p)
	{
		gauffre[p.gety()][p.getx()] = nb_tour;
	}

	public void RemettreUnCarre (Point p)
	{
		gauffre[p.gety()][p.getx()] = -1;
	}

	public int ValeurTourCarre (Point p)
	{
		return (gauffre[p.gety()][p.getx()]);
	}

	public int getTour ()
	{
		return nb_tour;
	}

	public void IncrementeTour ()
	{
		nb_tour++;
	}

	public int hauteur ()
	{
		return this.hauteur;
	}

	public int longueur ()
	{
		return this.longueur;
	}

	private void InitGauffre ()
	{
		for (int i = 0; i < this.hauteur; i++)
		{
			for (int j = 0; j < this.longueur; j++)
			{
				gauffre[i][j] = -1;
			}
		}
	}

	public void AfficherGauffre_CMD ()
	{

		for (int i = 0; i < this.hauteur; i++)
		{
			for (int j = 0; j < this.longueur; j++)
			{
				System.out.print(gauffre[i][j] + " ");
			}
			System.out.println();
		}
	}

}