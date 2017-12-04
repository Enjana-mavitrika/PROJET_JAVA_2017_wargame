package wargame;


public class MonMain{

	public static void main(String[] args) {

		FenetreJeu fenetre = new FenetreJeu();
		fenetre.setVisible(true);
		
		/*************************************
	     * 
	     *              Test IA 
	     * 
	     *************************************/
	    JoueurIA r2d2 = new JoueurIA(fenetre.getPanJeu().getConteneurCarte().getMap());
	    JoueurIA darkVador = new JoueurIA(fenetre.getPanJeu().getConteneurCarte().getMap());
	    while(Monstres.nbrMonstres > 0 && Heros.nbrHeros > 0)
	    {
	    	r2d2.jouerHeros(fenetre.getPanJeu());
	    	darkVador.jouerMonstre(fenetre.getPanJeu());
	    }


	}

}
