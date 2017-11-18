package wargame;
import java.awt.Color;
import java.awt.Graphics;
<<<<<<< HEAD
public class Obstacle  {
=======

import wargame.ISoldat.TypesM;
public class Obstacle extends Element {
>>>>>>> 7f43ae79166c23ddb1ca5e0d466989027490b953
	public enum TypeObstacle {
		ROCHER (COULEUR_ROCHER), FORET (COULEUR_FORET), EAU (COULEUR_EAU);

		private final Color COULEUR;

		TypeObstacle(Color couleur) {
			COULEUR = couleur;
		}

		public static TypeObstacle getObstacleAlea() {

			return values()[(int)(Math.random()*values().length)];
		}
	}
	private TypeObstacle TYPE;
<<<<<<< HEAD
	Obstacle(TypeObstacle type, Position pos) {
		TYPE = type; this.pos = pos;
	}
	public String toString() {
		return ""+TYPE;
	}
=======
	
	public Obstacle(){
        this.heros = false;
        this.monstre=false;
        this.TYPE = TypeObstacle.getObstacleAlea();
        this.texture = TYPE.COULEUR;
    }
	
	public Obstacle(TypeObstacle type, Position pos) { TYPE = type; this.pos = pos; super.obstacle = true; texture = type.COULEUR;}
	public String toString() { return ""+TYPE; }

	 

>>>>>>> 7f43ae79166c23ddb1ca5e0d466989027490b953
}