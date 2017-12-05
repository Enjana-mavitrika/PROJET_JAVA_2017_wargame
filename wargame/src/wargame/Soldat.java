package wargame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;


/**
     *
     * @version : 1.0
     */
    public abstract class Soldat extends Element implements ISoldat{
        /**
         * num,enVie
         * aJoueCeTour,
         * pointsDeVie,
         * carte
         * combatM
         * deplace
         */
        protected String num;
        protected boolean enVie =true;
        protected boolean aJoueCeTour;
        protected int vie;
        protected int pointsDeVie;
        protected Carte carte;
        boolean combatM=false;
        boolean deplace=false;
        boolean boss=false;
      public  int porteeTotale=0;
        /**
         * Soldat, constructeur Soldat
         * @param nom
         * @param carte
         */
        public Soldat(){
          
            super();
           // this.setClickable(true);
        }
        /**
         *
         */
        public void setPos(Position pos) {
            this.pos = pos;
        }

        public Position getPos() {
            return this.pos;
        }


        /**
         * @param pos position du héros à attaquer/case sur laquelle aller
         * @return boolean -> True si l'attaque/déplacement s'est effectué, false sinon
         */
        /*public boolean actionHeros(Position pos) {
            if(!carte.getElement(pos).vide) {

                if (carte.getElement(pos).estClickable()) {

                    Soldat s = (Soldat) carte.getElement(pos);
                    //si le soldat attaqué est de faction differente
                    if (!(this.estHeros() && s.estHeros())) {
                        aJoueCeTour=true;
                        return this.combat(s);
                    }
                    else
                        return false;
                }
                //si on essaye de se déplacer sur un obstacle
                else
                    return false;
            }

            aJoueCeTour=true;
            return carte.deplaceSoldat(pos,this);
        }
        */


        //@Override
        public int getPoints() {
            // TODO Auto-generated method stub
            return 1;
        }

        //	@Override
        public int getTour() {
            // TODO Auto-generated method stub
            return 0;
        }


        //@Override
        public void joueTour(int tour) {
            // TODO Auto-generated method stub

        }

        /**
         *
         * @param soldat à attaquer
         * @return true si attaque effectuee false si erreur
         */
        //@Override
        public void combat(Soldat soldat) {
            Monstres monstre;
            Heros heros;

            try{
                if(this.heros) {
                    heros = (Heros) this;
                    if(this.estAPortee(soldat.getPos()) && soldat.enVie)
                        soldat.baisserVie((int)(Math.random()*heros.getTypeH().getPuissance())+1);
                }
                else
                {
                    monstre = (Monstres) this;
                    if(this.estAPortee(soldat.getPos()) && soldat.enVie)
                        soldat.baisserVie((int)(Math.random()*monstre.getTypeM().getPuissance())+1);
                    this.combatM=true;
                }

            }catch (Exception e)
            {
                System.out.println(e.getStackTrace());
            }

        }

        //@Override
        /**
         * @param
         */
        public void seDeplace(Position newPos) {
            this.pos = newPos;
        }

        public int getVieCourante(){
            return pointsDeVie;
        }


        public void baisserVie(int points){
            if(this.pointsDeVie > 0)
                this.pointsDeVie-=points;
            if(this.pointsDeVie <= 0) {
                this.enVie = false;
                this.seDeplace(new Position(-150,-150));
                System.out.println("SE DEPLACE EN DEHORS DU CADRE");
            }
            System.out.println("BAISSER VIE de " + points);
        }
        
        
        public void setAJoueCeTour(boolean bool)
        {
            this.aJoueCeTour=bool;
        }

        public boolean getAjoueCeTour(){
            return aJoueCeTour;
        }

        public String getNum() {
            return num;
        }

        public boolean estAPortee(Position posi)
        {
            if (posi.getX()<=(this.getPos().getX()+this.getPortee()) && posi.getX()>=(this.getPos().getX()-this.getPortee()))
                if (posi.getY()<=(this.getPos().getY()+this.getPortee()) && posi.getY()>=(this.getPos().getY()-this.getPortee()))
                    return true;
            return false;
        }

        public boolean estAPorteeDeplacement(Position posi)
        {

            if (posi.getX()<=(this.getPos().getX()+1) && posi.getX()>=(this.getPos().getX()-1))
                if (posi.getY()<=(this.getPos().getY()+1) && posi.getY()>=(this.getPos().getY()-1))
                    return true;
            return false;
        }

        public boolean estEnVie()
        {
            return this.enVie;
        }

        public abstract String getTypeName();
        public abstract int getVie();
        public abstract int getPortee();
        public String toString() 
        {
        	return getPos() + " " + this.getTypeName() + " ( " + this.getVieCourante() + "/" + this.getVie() + " ) PTotale=(" 
        	+this.porteeTotale	+") Boss?("+this.boss+")";
        }
    }
