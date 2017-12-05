package wargame;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Heros extends Soldat {
	
		// compteur de la classe Heros 
		public static int nbrHeros = 0;
		// numero heros courant
		private final int numHeros;
        /**
         * typeH
         */
        TypesH typeH;
        /**
         * Heros:
         * @param nom
         * @param carte
         */
        public Heros(){
            super.heros=true;
            this.typeH = TypesH.getTypeHAlea();
            this.texture = COULEUR_HEROS;
            try {
				this.img= ImageIO.read(new File("C:\\Users\\Oussema\\eclipse-workspace\\P_F\\src\\wargame\\images\\Capitane.PNG"));
			} catch (IOException e) {
			
				e.printStackTrace();
			}
            vie=getVie();
            this.pointsDeVie=vie;
            numHeros = ++nbrHeros; //mise à jour numéro et compteur
        }
        /**
         * getTypeName
         */
        public String getTypeName() {
            return typeH.name();
        }
        public TypesH getTypeH() {
            return typeH;
        }


        public int getVie() {
            return typeH.getPoints();
        }

        public int getPortee(){
            return typeH.getPortee();
        }
        
        public void setPortee(int p){
             typeH.setPortee(p);
        }
        
        // redefinition methode seDessine()
        public void seDessine(Graphics g){
        	if (enVie)
        	{
        		//super.seDessine(g);
        		
        		g.setColor(COULEUR_TEXTE);
        		int num = 'A' + numHeros - 1; // transformer numero en caractere A-Z
        		g.drawString("" + (char)num, getPos().getX() * NB_PIX_CASE + NB_PIX_CASE / 4, getPos().getY() * NB_PIX_CASE + NB_PIX_CASE - NB_PIX_CASE / 4);
        		
        		g.drawImage(img,pos.getX() * NB_PIX_CASE,pos.getY() * NB_PIX_CASE,NB_PIX_CASE,NB_PIX_CASE,null);
        	}
        }
        
     // redefinition methode baisserVie() pour decrementer le nombre de Heros en cas de mort
        public void baisserVie(int points)
        {
        	super.baisserVie(points);
        	if (pointsDeVie <= 0)
        		nbrHeros --;
        	System.out.println("NBR HEROS  = " + nbrHeros);
        }

}
