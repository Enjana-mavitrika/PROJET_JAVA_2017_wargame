package wargame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauJeu extends JPanel {
	private JLabel messageHeader;
	
	private JLabel infoFooter ;
	
	private JPanel conteneurHeader ;
	
	private JPanel conteneurPrincipale;
		
	private PanneauCarte conteneurCarte ;

	public PanneauJeu() {
		super();
		
		setSize(IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE, IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE + 200);
		 messageHeader = new JLabel();
		 messageHeader.setSize(new Dimension(IConfig.LARGEUR_CARTE , 100));
		 infoFooter = new JLabel();
		 infoFooter.setSize(new Dimension(IConfig.LARGEUR_CARTE , 100));
		 conteneurHeader = new JPanel(); 
		conteneurCarte = new PanneauCarte( new Carte() );
		/**
		 * les boutons
		 */
		JButton boutonFinTour = new JButton("Fin du tour");
		JButton boutonEnregistrement = new JButton(" Sauvegarder-Partie");
		JButton boutonRestauration = new JButton(" Restauration-Partie") ;
		
		GridLayout glConteneurHeader = new GridLayout(1, 2);

		// panneau HEADER
		conteneurHeader.setLayout(glConteneurHeader);
		glConteneurHeader.setHgap(10);
		conteneurHeader.add(boutonFinTour);
		conteneurHeader.add(boutonEnregistrement);
		conteneurHeader.add(boutonRestauration);
		conteneurHeader.add(messageHeader);
		
		this.setLayout(new BorderLayout());
		
		// insertion conteneur carte
		this.add(conteneurCarte, BorderLayout.CENTER);
		this.add(conteneurHeader, BorderLayout.NORTH);
		this.add(infoFooter, BorderLayout.SOUTH);
		
		int heros = 6, monstres = 15;
		
		String persos[] = {"HOBBIT", "ELF", "ORC", "NAIN"};
		int PV[] =        {  5,       25,     15,   20   };
		int PVTotal[] =   {  5,       25,     15,   20   };
		// mise à jour footer
		infoFooter.setText("(" + 15 + "," + 14 + ") " + persos[0] + "(" + PV[0] + "PV/" + PVTotal[0] + ")");
		infoFooter.repaint();

		// mise à jour header
		messageHeader.setText("Il reste " + Heros.nbrHeros + " héros et " + Monstres.nbrMonstres + " monstres");
		messageHeader.repaint();
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
		
		
		
		// action performed du bouton restaurer
				boutonRestauration.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent agr){
						FileInputStream fichier;
						try {
							fichier = new FileInputStream("wargame.ser");
							ObjectInputStream var = new ObjectInputStream(fichier);
							Object lect = var.readObject();
							conteneurCarte.setMap((Carte) lect);
							var.close();
							repaint();
						//crt.SeDessiner();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				
				// action performed du bouton sauvegarde
				boutonEnregistrement.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent agr){
						try {
							FileOutputStream fichierEntree = new FileOutputStream("wargame.ser");
							ObjectOutputStream fichierSorti = new ObjectOutputStream(fichierEntree);

							fichierSorti.writeObject(conteneurCarte.getMap());

							fichierSorti.flush();
							fichierSorti.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						};
					}
				});
				
				
				
	}
	
	public PanneauCarte getConteneurCarte() {return conteneurCarte;}

}

