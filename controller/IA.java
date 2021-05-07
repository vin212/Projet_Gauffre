import Modele.Gauffre;

abstract class IA {
    private Gauffre gauffre;

	static IA nouvelle(Gauffre g) {
        // Base de création d'une nouvelle IA
        // IA devant être choisi dans le fichier de config. 
		IA instance = null;
		String name = Configuration.instance().lis("IA");
		try {
			instance = (IA) ClassLoader.getSystemClassLoader().loadClass(name).getDeclaredConstructor().newInstance();
			instance.gauffre = g;
		} catch (Exception e) {
			Configuration.instance().logger().severe("Impossible de trouver l'IA : " + name);
		}
		return instance;
	}

	// Fonction a appeler quand l'IA commence
	final void ActiveIA(){
		initialise();
	}

	// Fonction à réécrire
	void initialise(){
	}

	// Fonction à réécrire
	Point joue(){
	}
}
