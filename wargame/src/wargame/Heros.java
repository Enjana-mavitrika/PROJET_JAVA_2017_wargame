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
            int rd;
            try {
            	
            	if (this.typeH==TypesH.HUMAIN) {
            		
            	rd=(int)(Math.random() * (2));
            	if(rd==0) {this.img= ImageIO.read(new File("images/Heros/Humain1.png"));}
            	if(rd==1) {this.img= ImageIO.read(new File("images/Heros/Humain2.png"));}
            	if(rd==2) {this.img= ImageIO.read(new File("images/Heros/Humain3.png"));}
            	
            	}
            	
            	if (this.typeH==TypesH.ELF) {
            		rd=(int)(Math.random() * (1));
                	if(rd==0) {this.img= ImageIO.read(new File("images/Heros/Elf1.png"));}
                	if(rd==1) {this.img= ImageIO.read(new File("images/Heros/Elf2.png"));}
                
            	
            	}
            	if (this.typeH==TypesH.NAIN) {
            		rd=(int)(Math.random() * (1));
                	if(rd==0) {this.img= ImageIO.read(new File("images/Heros/Nain1.png"));}
                	if(rd==1) {this.img= ImageIO.read(new File("images/Heros/Nain2.png"));}
                	
            	}
            	if (this.typeH==TypesH.HOBBIT) {this.img= ImageIO.read(new File("images/Heros/Hobbit1.png"));}
				
            	
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
