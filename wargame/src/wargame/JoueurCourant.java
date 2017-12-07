package wargame;

public abstract class JoueurCourant {

	protected Armee armee;

	//protected Partie partie;
	/**
	 * AbstractJoueur
	 * @param p
	 */
	public JoueurCourant(	)
	{
		//this.partie = p;
	}
	
	
	
	 //Appele chaque tour d'un joueur
	
	public abstract void jouerTour();
	
	
	/**
	 * notifierFinDeTour
	 */
	
	public void notifierFinDeTour(){
		//this.partie.notificationFinDeJeu();
	}

	public Armee getArmee() {
		return armee;
	}


	
	

}



