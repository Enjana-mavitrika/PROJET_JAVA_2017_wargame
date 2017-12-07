package wargame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.Math;

import javax.imageio.ImageIO;


public class Carte implements ICarte, IConfig, Serializable
{
	Element tabElements[] = new Element[NB_HEROS + NB_MONSTRES + NB_OBSTACLES] ;
	private ArmeeHeros armH=new ArmeeHeros();
	private ArmeeMonstres armM=new ArmeeMonstres(); 
	private boolean indmap=false;
	private Image img = null;

	public Carte()
	{  
		for(int x=0;x<tabElements.length;x++)
		{
			tabElements[x]=new Element(); 
		}

		// creer aleatoirement 41 elements different type : 6 h�ros, 15 monstres, 20 obstacles et les positionner aléatoirem
	
		
		placeSoldat(armH);
		
		placeSoldat(armM);
		
		choisirBoss();
		
		for (int j = NB_HEROS + NB_MONSTRES; j < tabElements.length; j++)
		{
			tabElements[j] = new Obstacle();
			Position	p = trouvePositionVide();
			tabElements[j].getPos().setX(p.getX());
			tabElements[j].getPos().setY(p.getY());
		}
	/*	
		// debug 
		for (int i = 0; i < tabElements.length; i++)
		{
			System.out.println("( " + tabElements[i].getPos().getX() + ", " + tabElements[i].getPos().getY() + ")");
		}
*/
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

	public Position trouvePositionVide(int type)
	{
		boolean trouveVide = false;
		int i=0, j=0;
		
		
		
		while (!trouveVide)
		{	if (type==1)
			{
			i = (int)(Math.random()*LARGEUR_CARTE/2);
			j = (int)(Math.random()*HAUTEUR_CARTE);
			}
		else
		{	
			i = (int)(Math.random()*LARGEUR_CARTE/2+(LARGEUR_CARTE/2));
			j = (int)(Math.random()*HAUTEUR_CARTE);	
		}
			trouveVide = true;
			for (int k = 0; k < tabElements.length; k++)
			{
				if (i == tabElements[k].getPos().getX() && j == tabElements[k].getPos().getY())
					trouveVide = false;
			}
		}

		return (new Position(i,j));
	}
	
	public boolean estVide(Position pos) 
	{
		boolean vide = true;
		for (int i = 0; i  < tabElements.length; i++) {
			if (tabElements[i].getPos().getX() == pos.getX() && tabElements[i].getPos().getY() == pos.getY())
				vide = false;
		}
		
		return vide;
	}

	public Position trouvePositionVide(Position pos)
	{
		return pos;
	}


	public void placeSoldat(ArmeeHeros Arm)
	{
		
		for (int i = 0; i < Arm.getListeSoldats().size() ; i++) {
			
			tabElements[i] =Arm.getListeSoldats().get(i);
			Position pos = trouvePositionVide(1);
			tabElements[i].getPos().setX(pos.getX());
			tabElements[i].getPos().setY(pos.getY());
		}
		
	}
	
	public void placeSoldat(ArmeeMonstres Arm)
	{
		
		for (int i = 0; i < Arm.getListeSoldats().size() ; i++) {
			System.out.println("i="+i);
			
			tabElements[NB_HEROS+i] =Arm.getListeSoldats().get(i);
			Position pos = trouvePositionVide(2);
			tabElements[NB_HEROS+i].getPos().setX(pos.getX());
			tabElements[NB_HEROS+i].getPos().setY(pos.getY());
			
		}
		
	}

	







	public Element getElement(Position pos) throws MonException
	{
		for (int i=0; i < tabElements.length; i++)
		{
			if (pos.getX() >= tabElements[i].getPos().getX() * NB_PIX_CASE && pos.getX() <= tabElements[i].getPos().getX() * NB_PIX_CASE + NB_PIX_CASE && 
					pos.getY() >= tabElements[i].getPos().getY() * NB_PIX_CASE + NB_PIX_CASE && pos.getY() <= tabElements[i].getPos().getY() * NB_PIX_CASE + (NB_PIX_CASE * 2))
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
		perso.seDeplace(new Position(-150, -150)); // deplacer perso hors de la carte
	}

	public boolean actionHeros(Position pos, Position pos2)
	{
		return true;
	}

	public void jouerSoldats(PanneauJeu pg)
	{

	}

	public void setBack()
	{
	this.indmap=false;
	}
	
	public void toutDessiner(Graphics g)
	{	int rd;
		
			
		if (this.indmap==false) {
		try {
			rd=(int)(Math.random() * (5));
			if (rd==0) {this.img= ImageIO.read(new File("images/Background/Desert1.png"));this.indmap=true;}
			if (rd==1) {this.img= ImageIO.read(new File("images/Background/Gazon1.png"));this.indmap=true;}
			if (rd==2) {this.img= ImageIO.read(new File("images/Background/Gazon2.png"));this.indmap=true;}
			if (rd==3) {this.img= ImageIO.read(new File("images/Background/Gazon4.png"));this.indmap=true;}
			if (rd==4) {this.img= ImageIO.read(new File("images/Background/Gazon5.png"));this.indmap=true;}
			if (rd==5) {this.	img= ImageIO.read(new File("images/Background/Piere1.png"));this.indmap=true;}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		// affichage carte vide
		g.setColor(IConfig.COULEUR_VIDE);
		for (int y = 0; y < IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE; y += IConfig.NB_PIX_CASE)
		{
			for (int x = 0; x <= IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE; x += IConfig.NB_PIX_CASE)
			{
				g.drawRect(x, y, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);	
			g.drawImage(img,x, y,IConfig.NB_PIX_CASE,IConfig.NB_PIX_CASE,null);
			}	
		}


		// dessine tout les elements sur la carte
		for (int i = 0; i < tabElements.length; i++) 
		{
			if (tabElements[i] instanceof Soldat)
			{
				Soldat soldat = (Soldat)tabElements[i];
				if (!soldat.enVie)
					this.mort(soldat);
			}
			tabElements[i].seDessine(g);
		}
	}
	
	
	public void choisirBoss()
	{
		int	maxH=0;
		int maxM=0;
		int indBH=0;
		int indBM=0;
		int sommeVH=0;
		int sommeVM=0;
		
		Heros H;
		Monstres M;
		
		for (int i = 0; i < tabElements.length; i++) 
		{ 	
				System.out.println("ici"+i+":----"+tabElements[i].getPos());
				
				
				
				if (tabElements[i] instanceof Soldat)
			{ 	
				Soldat soldat = (Soldat)tabElements[i];
				if (soldat instanceof Heros)	{ 
					sommeVH +=soldat.getPortee();
					
					if (soldat.getPortee()>=maxH) { maxH=soldat.getPortee(); indBH=i; }
				}

				if (soldat instanceof Monstres) {
					sommeVM +=soldat.getPortee();
					if (soldat.getPortee()>=maxM) { maxM=soldat.getPortee(); indBM=i; }
				}

			}

		}

		System.out.println("indBH"+indBH);
		System.out.println("indBM"+indBM);

		
		if (tabElements[indBH] instanceof Heros)
		{ 	
			H=(Heros)tabElements[indBH];
			H.boss=true;
			H.porteeTotale=sommeVH;

		}

		if (tabElements[indBM] instanceof Monstres)
		{ 	
			M=(Monstres)tabElements[indBM];
			M.boss=true;
			M.porteeTotale=sommeVM;

		}

	
		
		
		

	}

	
	
	
}