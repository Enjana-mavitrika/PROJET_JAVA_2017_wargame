/**
 * Classe qui gère la carte et les éléments qui y figurent
 * @author S.RABONARIJAONA
 * @version 1.0
 * 
 */


/*
 * Historique :
 *   => demande méthode getPosition() de la classe Element
 */


package wargame;
public class Carte implements ICarte, IConfig
{


  /*--------------------------------------
   *                                     *
   *               Data                  *
   *                                     *
   *-------------------------------------*/
  private int carte[]
  private Element elements[] = new Element[]; // tableau contenant tous les élements de la carte
  
  
  /*-------------------------------------
   *                                     *
   *           Constructors              *
   *                                     *
   *-------------------------------------*/
  /**
   * Constructeur : Creation et positionnement aleatoire des soldats et des obstacles
   */ 
  public Carte(){
    
  }
  /*--------------------------------------
   *                                     *
   *             Methods                 *
   *                                     *
   *-------------------------------------*/
  /**
   * Renvoie element de la carte a la position donnee en parametre
   * @param Position
   * @return Element si Position en parametre contient un element
   * @return Exception si Position en parametre est non valide OU ne contient aucun element
   */ 
  Element getElement(Position pos)
  {
    if (!pos.estValide()){throw new Exception("Position non valide !!");}
    for (int i = 0; i < elements.length; i++)
    {
      // parcourirs les élements et renvoyer l'element qui a la même position que pos donné en parametre
      if (pos.getX() >= elements[i].getPosition().getX() && pos.getX() <= elements[i].getPosition().getX() + NB_PIX_CASE && pos.getY() >= elements[i].getPosition().getY() && pos.getY() <= elements[i].getPosition().getY() + NB_PIX_CASE)
	return elements[i];
      throw new Exception("Position vide");
    }
  }

  Position trouvePositionVide()
  {
    
  }

  Position trouvePositionVide()
  {
    
  }

  Heros trouveHeros()
  {
    
  }

  Heros trouveHeros()
  {
    
  }

  boolean deplaceSoldat(Position pos, Soldat soldat)
  {
    
  }

  void mort(Soldat perso)
  {
    
  }

  boolean actionHeros(Position pos, Position pos2)
  {
    
  }

  void jouerSoldats(PanneauJeu pg)
  {
    
  }

  void toutDessiner(Graphics g)
  {
    
  }  
}
