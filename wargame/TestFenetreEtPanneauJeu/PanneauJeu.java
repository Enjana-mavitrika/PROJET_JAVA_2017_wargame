import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;

public class PanneauJeu extends JPanel
{
    private CarteTest map ;		// la carte à dessiner

    public PanneauJeu(CarteTest carte)
    {
	map = carte;
    }
    
  public void paintComponent(Graphics g)
  {
      map.seDessiner(g);
  }
}
