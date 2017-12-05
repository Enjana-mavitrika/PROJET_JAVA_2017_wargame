package wargame;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import wargame.ISoldat.TypesH;

public class Monstres extends Soldat{
		// compteur de monstres
		public static int nbrMonstres = 0;
		// numero monstres courant
		private final int numMonstres;
        /**
         * typeM
         */
        private TypesM typeM;
        /**
         * Monstre:
         * @param nom
         * @param carte
         */

        public Monstres(){
            this.heros = false;
            this.monstre=true;
            this.typeM = TypesM.getTypeMAlea();
            this.texture = COULEUR_MONSTRES;
            try {
            	if (this.typeM==TypesM.GOBELIN) {this.img= ImageIO.read(new File("images/Monstres/Gobbelin1.png"));}
            	if (this.typeM==TypesM.ORC) {this.img= ImageIO.read(new File("images/Monstres/Orc1.png"));}
            	if (this.typeM==TypesM.TROLL) {this.img= ImageIO.read(new File("images/Monstres/Troll1.png"));}
            	
				
            	
            	} catch (IOException e) {
			
				e.printStackTrace();
			}
            
            vie=getVie();
            this.pointsDeVie=vie;
            numMonstres = ++nbrMonstres; //mise à jour compteur et numero monstres
        }

        @Override
        /**
         *
         */
        public String getTypeName() {
            return typeM.name();
        }
        public TypesM getTypeM() {
            return typeM;
        }

        @Override
        public int getVie() {
            return typeM.getPoints();
        }

        public int getPortee(){
            return typeM.getPortee();
        }
        
     
        public void setPortee(int p){
            typeM.setPortee(p);
       }
        
        // redefinition methode seDessine() pour dessiner son numero
        public void seDessine(Graphics g){
        	if (enVie)
        	{
        		//super.seDessine(g);
        		g.setColor(COULEUR_VIDE);
        		g.drawString("" + numMonstres, getPos().getX() * NB_PIX_CASE + NB_PIX_CASE / 8, getPos().getY() * NB_PIX_CASE + + NB_PIX_CASE - NB_PIX_CASE / 4);
        		g.drawImage(img,pos.getX() * NB_PIX_CASE,pos.getY() * NB_PIX_CASE,NB_PIX_CASE,NB_PIX_CASE,null);
        	}
        }
        
        // redefinition methode baisserVie() pour decrementer le nombre de Monstre en cas de mort
        public void baisserVie(int points)
        {
        	super.baisserVie(points);
        	if (pointsDeVie <= 0)
        		nbrMonstres --;
        	System.out.println("NBR MONSTRES  = " + nbrMonstres);
        }

    
    }
