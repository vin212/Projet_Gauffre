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

	// Creer histo
	public void DecrementeTour ()
	{
		nb_tour--;
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

	// Creer histo
	public void Retour(){
		for(int i = 0; i < hauteur(); i++){
            for(int j = 0; j < longueur(); j++){
                if(gauffre[i][j] == (getTour()-1)){
					gauffre[i][j] = -1;
				}
            }
        }
		DecrementeTour();
	}

    public Gauffre Clone ()
    {
        Gauffre gauf = new Gauffre (this.hauteur,this.longueur);
        gauf.nb_tour = this.nb_tour;

        RemplaceGauffre(gauf);
		return gauf;
    }

    private void RemplaceGauffre (Gauffre gauf)
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