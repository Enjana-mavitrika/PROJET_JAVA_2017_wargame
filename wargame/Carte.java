package wargame;
import java.awt.Graphics;
import java.lang.Math;

import wargame.ISoldat.TypesM;
public class Carte implements ICarte, IConfig
{
    private Element tabElements[] ;


    public Carte()
    { tabElements = new Element[41];
     	for(int x=0;x<41;x++)
     	{
     		tabElements[x]=new Element(); 
     	}
    
    	// creer aleatoirement 41 elements different type : 6 héros, 15 monstres, 20 obstacles et les positionner alÃ©atoirem
    	for (int i = 0; i < NB_HEROS ; i++) {
    		tabElements[i] = new Heros();
    		deplaceSoldat(trouvePositionVide(),(Soldat) tabElements[i]);
    	}
    	for (int k = NB_HEROS; k < NB_HEROS + NB_MONSTRES; k++) {
    		tabElements[k] = new Monstres();
    		deplaceSoldat(trouvePositionVide(),(Soldat) tabElements[k]);
    	}
    	for (int j = NB_HEROS + NB_MONSTRES; j < tabElements.length; j++)
    	{
    		tabElements[j] = new Obstacle();
    	Position	p=trouvePositionVide();
    	tabElements[j].getPos().setX(p.getX());
    	tabElements[j].getPos().setY(p.getY());
    	}    	
    	
    }


    public Position trouvePositionVide()
    {
	boolean trouveVide = false;
	int i=0, j=0;
	while (!trouveVide)
	    {
		i = (int)(Math.random()*LARGEUR_CARTE);
		j = (int)(Math.random()*HAUTEUR_CARTE);
		
		for (int k = 0; k < tabElements.length; k++)
		    {
			if (i == tabElements[k].getPos().getX() && j == tabElements[k].getPos().getY())
			    trouveVide = false;
		    }
		trouveVide = true;
	    }
	
	return (new Position(i,j));
    }

    
    public Position trouvePositionVide(Position pos)
    {
      return pos;
    }

  
    public boolean estVide(Position pos)
    {
    	for(int i = 0; i < tabElements.length; i++) {
    		if (tabElements[i].getPos().getX() == pos.getX() && tabElements[i].getPos().getY() == pos.getY())
    			return false;
    	}
    	return true;
    }
    
    /*
    public boolean estVide(Position pos)
    {
    	Element el = new Element();
    	try {
    		el = getElement(pos);
    		return false;
    	}
    	catch(MonException e) {
    		return true;
    	}
    }
    
*/

    
    // dessine chaque element sur la carte 
    public void seDessiner(Graphics g)
    {
	
	// affichage carte vide

	// grille vide
	g.setColor(IConfig.COULEUR_VIDE);
	for (int y = 0; y < IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE; y += IConfig.NB_PIX_CASE)
	    {
		for (int x = 0; x <= IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE; x += IConfig.NB_PIX_CASE)
		    g.drawRect(x, y, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);
	    }

	// grille fin 


	for (int i = 0; i < tabElements.length; i++)
	    
		tabElements[i].seDessine(g);
	    
    }





  public Element getElement(Position pos) throws MonException
  {
	for (int i=0; i < tabElements.length; i++)
	{
		if (tabElements[i].getPos().getX() == pos.getX() && tabElements[i].getPos().getX() == pos.getX())
			return tabElements[i]; 
	}
	throw new MonException(tabElements, pos);
	
  }


 

  public Heros trouveHeros()
  {
	  int i = 0;
	  boolean trouve = false;
	  while(!trouve)  
	  {	
		  i = (int)(Math.random() * 40);
		  if(tabElements[i].estHero())
			  trouve = true;
	  }
	  
	  return (Heros)tabElements[i];
  }

  public Heros trouveHeros(Position pos)
  {
    return new Heros();
  }

 public boolean deplaceSoldat(Position pos, Soldat soldat)
  {
    if (pos.estValide() && !estVide(pos)) {
    	soldat.seDeplace(pos);
    	return true;
    }
    return false;
  }

  public void mort(Soldat perso)
  {
    perso.setPos(new Position(-1, -1));
  }

  public boolean actionHeros(Position pos, Position pos2)
  {
    return true;
  }

  public void jouerSoldats(PanneauJeu pg)
  {
    
  }

  public void toutDessiner(Graphics g)
  {
	// affichage carte vide
		g.setColor(IConfig.COULEUR_VIDE);
		for (int y = 0; y < IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE; y += IConfig.NB_PIX_CASE)
		    {
			for (int x = 0; x <= IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE; x += IConfig.NB_PIX_CASE)
			    g.drawRect(x, y, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);
		    }
		
	    
	  
	  for (int i = 0; i < tabElements.length; i++)
		  tabElements[i].seDessine(g);
  }  
  }