package wargame;
import java.awt.Color;
import java.awt.Graphics;

import wargame.ISoldat.TypesM;
public class Obstacle extends Element {
	public enum TypeObstacle {
		ROCHER (COULEUR_ROCHER), FORET (COULEUR_FORET), EAU (COULEUR_EAU);
		private final Color COULEUR;
		TypeObstacle(Color couleur) { COULEUR = couleur; }
		public static TypeObstacle getObstacleAlea() {
			return values()[(int)(Math.random()*values().length)];
		}
	}
	private TypeObstacle TYPE;
	
	public Obstacle(){
        this.heros = false;
        this.monstre=false;
        this.TYPE = TypeObstacle.getObstacleAlea();
        this.texture = TYPE.COULEUR;
    }
	
	public Obstacle(TypeObstacle type, Position pos) { TYPE = type; this.pos = pos; super.obstacle = true; texture = type.COULEUR;}
	public String toString() { return ""+TYPE; }

	 

}