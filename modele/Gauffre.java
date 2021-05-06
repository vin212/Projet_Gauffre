package modele;

import structure.Point;
//import structure.Point;

public class Gauffre 
{
	private boolean gauffre[][];
	private Point pourri;
	private int hauteur;
	private int longueur;


	public Gauffre (int hauteur, int longueur)
	{
		this.gauffre = new boolean [hauteur][longueur];
		this.pourri = new Point (0,0);
		this.hauteur = hauteur;
		this.longueur = longueur;


		InitGauffre();
	}

	public Boolean EstPourri (Point p)
	{
		return (p.getx() == pourri.getx() && p.getx() == pourri.gety());
	}

	public Boolean EstManger (Point p)
	{
		return ( !gauffre[p.gety()][p.getx()]) ;
	}

	public void MangerUnCarre (Point p)
	{
		gauffre[p.gety()][p.getx()] = false;
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
				gauffre[i][j] = true;
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