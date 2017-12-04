package wargame;

import javax.swing.JPanel;

public class JoueurIA implements IConfig{
	private Carte map;
	private Heros [] herosTab = new Heros[NB_HEROS];
	private Monstres [] monstresTab = new Monstres[NB_MONSTRES];
	public Element tab[];

	public JoueurIA(Carte map) 
	{
		this.map = map;
		this.tab = this.map.getTabElements();
		for (int i = 0, j = 0, k = 0; i < tab.length; i++) {
			// rassembler les heros dans herosTab
			if (tab[i] instanceof Heros) {
				herosTab[j] = (Heros)tab[i];
				j++;
			}
			// rassembler les monstres dans monstresTab
			if (tab[i] instanceof Monstres)
			{
				monstresTab[k] = (Monstres)tab[i];
				k++;
			}

		}

	}

	public void jouerHeros(JPanel panel)
	{
		int rand;
		boolean aJouer;
		// pour chaque Heros essayer attaquer un Monstre à sa porté sinon se déplacer d'une case
		for (int i  = 0; i < herosTab.length; i++) 
		{
			aJouer = false;
			Heros hero = herosTab[i];
			System.out.println("Heros "+ i + "est pret son nom : " + hero.getTypeName());
			// parcourir les monstres pour trouver les monstres à la porté du hero
			for (int j = 0; j < monstresTab.length; j++) 
			{
				if (hero.estAPortee(monstresTab[j].getPos())) 
				{
					System.out.println("Il va frappé le monstre : " + monstresTab[j].getTypeName() + " vie : " + monstresTab[j].getVieCourante());
					hero.combat(monstresTab[j]);
					panel.repaint();
					System.out.println("Il a frappé le monstre : " + monstresTab[j].getTypeName() + " vie : " + monstresTab[j].getVieCourante());
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					aJouer = true;
					break; 
				}
			}

			if (aJouer) 
				continue; // passer au heros suivant

			rand = (int)Math.random();
			Position newPos = new Position(hero.getPos().getX(),0);
			System.out.println("entre dans test");
			// verifier que les 3 positions sont vides
			if (map.estVide(newPos = new Position(hero.getPos().getX() + 1, hero.getPos().getY())) && newPos.estValide())
			{
				hero.seDeplace(newPos);
				System.out.println("se deplace sur " + newPos);
			}
			else if (map.estVide(newPos = new Position(hero.getPos().getX() + 1, hero.getPos().getY() - 1)) && newPos.estValide())
			{
				hero.seDeplace(newPos);
				System.out.println("se deplace sur " + newPos);
			}
			else if (map.estVide(newPos = new Position(hero.getPos().getX() + 1, hero.getPos().getY() + 1)) && newPos.estValide())
			{
				hero.seDeplace(newPos);
				System.out.println("se deplace sur " + newPos);
			}
			else
			{
				newPos.setX(hero.getPos().getX());
				if (rand == 1) {
					newPos.setY(hero.getPos().getY() - 1);
					if (map.estVide(newPos) && newPos.estValide())
					{
						hero.seDeplace(newPos);
						System.out.println("se deplace sur " + newPos);
					}
					else {
						newPos.setY(hero.getPos().getY() + 1);
						hero.seDeplace(newPos);
						System.out.println("se deplace sur " + newPos);
					}
				}
				else {
					newPos.setY(hero.getPos().getY() + 1);
					if (map.estVide(newPos) && newPos.estValide())
					{
						hero.seDeplace(newPos);
						System.out.println("se deplace sur " + newPos);
					}
					else {
						newPos.setY(hero.getPos().getY() - 1);
						hero.seDeplace(newPos);
						System.out.println("se deplace sur " + newPos);
					}
				}
			}
			System.out.println("heros position : " + hero.getPos());
			//			tab[i].getPos().setX(1);
			//			tab[i].getPos().setY(1);
			/* redessiner le panneau pour mettre à jour les positions des elements */
			panel.repaint();
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}
	
	
	public void jouerMonstre(JPanel panel)
	{
		int rand;
		boolean aJouer;
		// pour chaque Monstre essayer attaquer un Hero à sa porté sinon se déplacer d'une case
		for (int i  = 0; i < monstresTab.length; i++) 
		{
			aJouer = false;
			Monstres monstre = monstresTab[i];
			System.out.println("Monstre "+ i + "est pret son nom : " + monstre.getTypeName());
			// parcourir les heros pour trouver les heros à la porté du monstre
			for (int j = 0; j < herosTab.length; j++) 
			{
				if (monstre.estAPortee(herosTab[j].getPos())) 
				{
					System.out.println("Il va frappé le hero : " + herosTab[j].getTypeName() + " vie : " + herosTab[j].getVieCourante());
					monstre.combat(herosTab[j]);
					panel.repaint();
					System.out.println("Il a frappé le hero : " + herosTab[j].getTypeName() + " vie : " + herosTab[j].getVieCourante());
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					aJouer = true;
					break; 
				}
			}

			if (aJouer) 
				continue; // passer au heros suivant

			rand = (int)Math.random();
			Position newPos = new Position(monstre.getPos().getX(),0);
			
			// verifier que les 3 positions sont vides
			if (map.estVide(newPos = new Position(monstre.getPos().getX() - 1, monstre.getPos().getY())) && newPos.estValide())
			{
				monstre.seDeplace(newPos);
				System.out.println("se deplace sur " + newPos);
			}
			else if (map.estVide(newPos = new Position(monstre.getPos().getX() - 1, monstre.getPos().getY() - 1)) && newPos.estValide())
			{
				monstre.seDeplace(newPos);
				System.out.println("se deplace sur " + newPos);
			}
			else if (map.estVide(newPos = new Position(monstre.getPos().getX() - 1, monstre.getPos().getY() + 1)) && newPos.estValide())
			{
				monstre.seDeplace(newPos);
				System.out.println("se deplace sur " + newPos);
			}
			else
			{
				newPos.setX(monstre.getPos().getX());
				if (rand == 1) {
					newPos.setY(monstre.getPos().getY() - 1);
					if (map.estVide(newPos) && newPos.estValide())
					{
						monstre.seDeplace(newPos);
						System.out.println("se deplace sur " + newPos);
					}
					else {
						newPos.setY(monstre.getPos().getY() + 1);
						monstre.seDeplace(newPos);
						System.out.println("se deplace sur " + newPos);
					}
				}
				else {
					newPos.setY(monstre.getPos().getY() + 1);
					if (map.estVide(newPos) && newPos.estValide())
					{
						monstre.seDeplace(newPos);
						System.out.println("se deplace sur " + newPos);
					}
					else {
						newPos.setY(monstre.getPos().getY() - 1);
						monstre.seDeplace(newPos);
						System.out.println("se deplace sur " + newPos);
					}
				}
			}
			System.out.println("monstre position : " + monstre.getPos());
			//			tab[i].getPos().setX(1);
			//			tab[i].getPos().setY(1);
			/* redessiner le panneau pour mettre à jour les positions des elements */
			panel.repaint();
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}

}