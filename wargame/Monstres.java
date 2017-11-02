package wargame;

import java.awt.Graphics;

public class Monstres extends Soldat{
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
            vie=getVie();
            this.pointsDeVie=vie;
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
        
    
    }
