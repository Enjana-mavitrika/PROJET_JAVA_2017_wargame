package wargame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauCarte extends JPanel implements IConfig {
	
	    private Carte map ;		// la carte à dessiner

	    public PanneauCarte(Carte carte)
	    {
	    	setSize(new Dimension(IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE, IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE ));
		map = carte;
	    }
	    
	  public void paintComponent(Graphics g)
	  {
	      map.toutDessiner(g);
	  }
	  public Carte getMap(){ return map; }

	  public void setMap(Carte map) {this.map = map;}


}
