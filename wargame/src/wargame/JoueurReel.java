package wargame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;




public class JoueurReel implements IConfig{
	private Carte map;
	private Heros [] herosTab = new Heros[NB_HEROS];
	private Monstres [] monstresTab = new Monstres[NB_MONSTRES];
	public Element tab[];


	
	
	public JoueurReel(Carte map){
		
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
		
		
		
	}

	

			
	
}
