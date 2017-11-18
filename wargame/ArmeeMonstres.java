package wargame;
/**
 * @author: KOMAH
 * @version : 1.0
 */
public class ArmeeMonstres extends Armee{
    public ArmeeMonstres(){
        super();
//        this.carte=carte;
        for(int i=0;i<NB_MONSTRES;i++){
            this.listeSoldats.add(new Monstres());
        }
    }
}
