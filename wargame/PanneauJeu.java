package wargame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;

public class PanneauJeu extends JPanel
{
    private Carte map ;		// la carte à dessiner

    public PanneauJeu(Carte carte)
    {
	map = carte;
    }
    
  public void paintComponent(Graphics g)
  {
      map.toutDessiner(g);
  }
}
