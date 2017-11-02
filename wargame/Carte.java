package wargame;
import java.awt.Graphics;
import java.lang.Math;

import wargame.ISoldat.TypesM;
public class Carte implements ICarte, IConfig
{
	private Element tabElements[] = new Element[NB_HEROS + NB_MONSTRES + NB_OBSTACLES] ;


	public Carte()
	{ 
		for(int x=0;x<tabElements.length;x++)
		{
			tabElements[x]=new Element(); 
		}

		// creer aleatoirement 41 elements different type : 6 h�ros, 15 monstres, 20 obstacles et les positionner aléatoirem
		for (int i = 0; i < NB_HEROS ; i++) {
			tabElements[i] = new Heros();
			Position pos = trouvePositionVide();
			tabElements[i].getPos().setX(pos.getX());
			tabElements[i].getPos().setY(pos.getY());
		}
		for (int k = NB_HEROS; k < NB_HEROS + NB_MONSTRES; k++) {
			tabElements[k] = new Monstres();
			Position pos = trouvePositionVide();
			tabElements[k].getPos().setX(pos.getX());
			tabElements[k].getPos().setY(pos.getY());
		}
		for (int j = NB_HEROS + NB_MONSTRES; j < tabElements.length; j++)
		{
			tabElements[j] = new Obstacle();
			Position	p = trouvePositionVide();
			tabElements[j].getPos().setX(p.getX());
			tabElements[j].getPos().setY(p.getY());
		}
		
		// debug 
		for (int i = 0; i < tabElements.length; i++)
		{
			System.out.println("( " + tabElements[i].getPos().getX() + ", " + tabElements[i].getPos().getY() + ")");
		}

	}
	
	public Element []getTabElements(){
		return tabElements;
	}


	public Position trouvePositionVide()
	{
		boolean trouveVide = false;
		int i=0, j=0;
		while (!trouveVide)
		{
			i = (int)(Math.random()*LARGEUR_CARTE);
			j = (int)(Math.random()*HAUTEUR_CARTE);

			trouveVide = true;
			for (int k = 0; k < tabElements.length; k++)
			{
				if (i == tabElements[k].getPos().getX() && j == tabElements[k].getPos().getY())
					trouveVide = false;
			}
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
		perso.seDeplace(new Position(-1, -1)); // deplacer perso hors de la carte
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


		// dessine tout les elements sur la carte
		for (int i = 0; i < tabElements.length; i++)
			tabElements[i].seDessine(g);
	}  
}