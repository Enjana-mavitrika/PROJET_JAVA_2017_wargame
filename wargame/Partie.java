package wargame;

public class Partie {
	
	public Partie() {
		initPartie();
	}
	
	public void initPartie() {
		this.carte = new Carte();
		this.joueurIA2 = new JoueurIA2(carte);
	}
	
	public void lancerPartie() {
		this.carte.placeSoldat(Arm);
	}
	
	private boolean  partieEncours = false ;
	private JoueurIA2 joueurIA2 ;
	private Carte carte ;
	ArmeeMonstres Arm;
}
