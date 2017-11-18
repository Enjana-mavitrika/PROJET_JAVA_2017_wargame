package model;
/**
 * @author: KOMAH
 * @version : 1.0
 */
public class ArmeeHeros extends Armee {
    public ArmeeHeros(Carte carte){
        this.carte=carte;
        for(int i=0;i<NB_HEROS;i++){
            this.listeSoldats.add(new Heros(String.valueOf((char)(i+65)),carte));
        }
    }
}
