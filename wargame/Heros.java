package wargame;

import java.awt.Graphics;

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
        
        // redefinition methode seDessine()
        public void seDessine(Graphics g){
        	if (enVie)
        	{
        		super.seDessine(g);
        		g.setColor(COULEUR_TEXTE);
        		int num = 'A' + numHeros - 1; // transformer numero en caractere A-Z
        		g.drawString("" + (char)num, getPos().getX() * NB_PIX_CASE + NB_PIX_CASE / 4, getPos().getY() * NB_PIX_CASE + NB_PIX_CASE - NB_PIX_CASE / 4);
        	}
        }
        
     // redefinition methode baisserVie() pour decrementer le nombre de Heros en cas de mort
        public void baisserVie(int points)
        {
        	super.baisserVie(points);
        	if (pointsDeVie <= 0)
        		nbrHeros --;
        }

}
