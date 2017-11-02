package wargame;

import java.awt.Graphics;

public class Heros extends Soldat {
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
        
       

}
