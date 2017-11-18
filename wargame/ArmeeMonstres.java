package model;
/**
 * @author: KOMAH
 * @version : 1.0
 */
public class ArmeeMonstres extends Armee{
    public ArmeeMonstres(Carte carte){
        super();
        this.carte=carte;
        for(int i=0;i<NB_MONSTRES;i++){
            this.listeSoldats.add(new Monstre(String.valueOf(i+1),carte));
        }
    }
}
