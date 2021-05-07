package controller;

import modele.Gauffre;
import structure.Point;
import controller.*;

public abstract class IA {
    private Gauffre gauffre;
    private boolean active = false;

	public static IA nouvelle(Gauffre g) {
        // Base de création d'une nouvelle IA
        // IA devant être choisi dans le fichier de config. 
		IA instance = null;
		//String name = Configuration.instance().lis("IA");
		try {
			instance = (IA) ClassLoader.getSystemClassLoader().loadClass("controller.IAA").getDeclaredConstructor().newInstance();
			instance.gauffre = g;
		} catch (Exception e) {
			//Configuration.instance().logger().severe("Impossible de trouver l'IA : " + name);
			System.out.println(e);
		}
		return instance;
	}

	// Fonction a appeler quand l'IA commence
	public final void ActiveIA(){
		initialise();
		this.active = true;
	}

	public void DesactiverIA (){
		this.active = false;
	}

	public boolean estActive () {
		return this.active;
	}

	// Fonction à réécrire
	public void initialise(){
	}

	// Fonction à réécrire
	public Point joue(){
		return null;
	}

	public void MettreGauffre(Gauffre g){

	}
}
