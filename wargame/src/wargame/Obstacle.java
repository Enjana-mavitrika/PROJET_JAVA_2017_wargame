package wargame;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import wargame.ISoldat.TypesH;
import wargame.ISoldat.TypesM;


public class Obstacle extends Element {

	
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
	private int rd;

	
	
	public Obstacle(){
        this.heros = false;
        this.monstre=false;
        this.TYPE = TypeObstacle.getObstacleAlea();
        this.texture = TYPE.COULEUR;
        rd = 0;
        try {
        	
        	if (this.TYPE==TypeObstacle.FORET) {
        		rd=(int)(Math.random() * (5));
        		if (rd==0) {this.img= ImageIO.read(new File("images/Obstacles/Foret1.png"));}
        		if (rd==1) {this.img= ImageIO.read(new File("images/Obstacles/Foret2.png"));}
        		if (rd==2) {this.img= ImageIO.read(new File("images/Obstacles/Foret3.png"));}
        		if (rd==3) {this.img= ImageIO.read(new File("images/Obstacles/Foret4.png"));}
        		if (rd==4) {this.img= ImageIO.read(new File("images/Obstacles/Foret5.png"));}
        		}
        	if (this.TYPE==TypeObstacle.EAU) {
        		
        		rd=(int)(Math.random() * (5));
        		if (rd==0) {this.img= ImageIO.read(new File("images/Obstacles/Eau1.png"));}
        		if (rd==1) {this.img= ImageIO.read(new File("images/Obstacles/Eau2.png"));}
        		if (rd==2) {this.img= ImageIO.read(new File("images/Obstacles/Eau3.png"));}
        		if (rd==3) {this.img= ImageIO.read(new File("images/Obstacles/Eau4.png"));}
        		if (rd==4) {this.img= ImageIO.read(new File("images/Obstacles/Eau5.png"));}
        		
        	}
        	if (this.TYPE==TypeObstacle.ROCHER) {
        		rd=(int)(Math.random() * (5));
        		if (rd==0) {this.img= ImageIO.read(new File("images/Obstacles/Rocher1.png"));}
        		if (rd==1) {this.img= ImageIO.read(new File("images/Obstacles/Rocher2.png"));}
        		if (rd==2) {this.img= ImageIO.read(new File("images/Obstacles/Rocher3.png"));}
        		if (rd==3) {this.img= ImageIO.read(new File("images/Obstacles/Rocher4.png"));}
        		if (rd==4) {this.img= ImageIO.read(new File("images/Obstacles/Rocher5.png"));}
        	}
        	
        	} catch (IOException e) {
		
			e.printStackTrace();
		}
    }
	
	public Obstacle(TypeObstacle type, Position pos) { TYPE = type; this.pos = pos; super.obstacle = true; texture = type.COULEUR;}
	public String toString() { return ""+TYPE; }

	 


}