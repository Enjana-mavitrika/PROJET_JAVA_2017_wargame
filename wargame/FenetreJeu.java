package wargame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class FenetreJeu
{
  public static void main(String args[])
  {
    // creation fenetre
    JFrame fenetre = new JFrame();
    PanneauJeu conteneurBody = new PanneauJeu(new Carte());
    JLabel messageHeader = new JLabel();
    JLabel infoFooter = new JLabel();
    JPanel conteneurHeader = new JPanel();
    JPanel conteneurPrincipale = new JPanel();
    JButton boutonFinTour = new JButton("Fin du tour");
    GridLayout glConteneurHeader = new GridLayout(1, 2);

    // panneau HEADER
    conteneurHeader.setLayout(glConteneurHeader);
    glConteneurHeader.setHgap(10);
    conteneurHeader.add(boutonFinTour);
    conteneurHeader.add(messageHeader);


    // panneau BODY
    conteneurBody.setSize(IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE, IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE);

    // conteneur MAIN
    conteneurPrincipale.setLayout(new BorderLayout());
    conteneurPrincipale.add(conteneurHeader, BorderLayout.NORTH);
    conteneurPrincipale.add(conteneurBody, BorderLayout.CENTER);
    conteneurPrincipale.add(infoFooter, BorderLayout.SOUTH);
    
    
    
    fenetre.setTitle("Wargame");
    fenetre.setSize(IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE, IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE + 50); 
    fenetre.setLocation(IConfig.POSITION_X, IConfig.POSITION_Y);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setAlwaysOnTop(true);
    fenetre.setResizable(false);
    fenetre.setContentPane(conteneurPrincipale);
    // affichage fenetre
    fenetre.setVisible(true);
    

    //*** mise à jour fenetre****

    int heros = 6, monstres = 15;
    String persos[] = {"HOBBIT", "ELF", "ORC", "NAIN"};
    int PV[] =        {  5,       25,     15,   20   };
    int PVTotal[] =   {  5,       25,     15,   20   };
    // mise à jour footer
    infoFooter.setText("(" + 15 + "," + 14 + ") " + persos[0] + "(" + PV[0] + "PV/" + PVTotal[0] + ")");
    infoFooter.repaint();
    // mise à jour header
    messageHeader.setText("Il reste " + heros + " héros et " + monstres + " monstres");
    messageHeader.repaint();

    // exemple d'éxécution pour voir changement header
    while (heros > 0 || monstres > 0)
    {
      // mise à jour header
      messageHeader.setText("Il reste " + heros + " héros et " + monstres + " monstres");
      messageHeader.repaint();
      
      // suspendre pendant 1 s
      try{
	Thread.sleep(1000);
      }catch(InterruptedException e)
      {
	e.printStackTrace();
      }
      
      if (monstres > 0)
	monstres--;
      if (heros > 0)
	heros--;
    }

    // Exemple execution pour voir changement Footer
    for (int i = 0; i < persos.length; i++)
    {
      // mise à jour footer
      infoFooter.setText("(" + 15 + "," + 14 + ") " + persos[i] + "(" + PV[i] + "PV/" + PVTotal[i] + ")");
      infoFooter.repaint();
      // suspendre pendant 1 s
      try{
	Thread.sleep(1000);
      }catch(InterruptedException e)
      {
	e.printStackTrace();
      }
    }
    

  }
}
