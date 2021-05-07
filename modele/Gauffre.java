package modele;

import structure.Point;

public class Gauffre 
{
	private int gauffre[][];
	private Point pourri;
	private int hauteur;
	private int longueur;
	private int nb_tour;
	private int nb_restant;

	public Gauffre (int hauteur, int longueur)
	{
		this.gauffre = new int [hauteur][longueur];
		this.pourri = new Point (0,0);
		this.hauteur = hauteur;
		this.longueur = longueur;
		nb_tour = 0;

		this.nb_restant = hauteur * longueur;


		InitGauffre();
	}

	public Boolean EstPourri (Point p)
	{
		return (p.getx() == pourri.getx() && p.gety() == pourri.gety());
	}

	public Boolean EstManger (Point p)
	{
		return (gauffre[p.getx()][p.gety()] != -1) ;
	}

	public void MangerUnCarre (Point p)
	{
		this.nb_restant --;
		gauffre[p.getx()][p.gety()] = nb_tour;
	}

	public void RemettreUnCarre (Point p)
	{
		this.nb_restant ++;
		gauffre[p.getx()][p.gety()] = -1;
	}

	public int ValeurTourCarre (Point p)
	{
		return (gauffre[p.getx()][p.gety()]);
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

	public int getNbRestant ()
	{
		return this.nb_restant;
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

	public Gauffre Clone ()
	{
		Gauffre gauf = new Gauffre (this.hauteur,this.longueur);
		gauf.nb_tour = this.nb_tour;
		gauf.nb_restant = this.nb_restant;

		ClonerValeursGauffre(gauf);

		return gauf;
	}

	private void ClonerValeursGauffre (Gauffre gauf)
	{
		for (int i = 0; i < this.hauteur; i++)
		{
			for (int j = 0; j < this.longueur; j++)
			{
				gauf.gauffre[i][j] = this.gauffre[i][j];
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