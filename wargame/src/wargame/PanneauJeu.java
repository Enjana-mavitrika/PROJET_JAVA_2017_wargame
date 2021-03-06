package wargame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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
	
	private Position p = new Position(0,0); // utiliser pour sauvegarder la position du souris
	private Soldat s; // utiliser pour sauvegarder le soldat courant
	
	int px;
	int py;
	int ind;

	Heros H;
	Monstres M;
	
	
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
		JButton boutonBack = new JButton("Changer-Background") ;
		

		
		GridLayout glConteneurHeader = new GridLayout(1, 9);

		// panneau HEADER
		conteneurHeader.setLayout(glConteneurHeader);
		glConteneurHeader.setHgap(10);
		conteneurHeader.add(boutonFinTour);
		conteneurHeader.add(boutonEnregistrement);
		conteneurHeader.add(boutonRestauration);
		
		conteneurHeader.add(boutonBack);
		
		conteneurHeader.add(messageHeader);
		
		this.setLayout(new BorderLayout());
		
		// insertion conteneur carte
		this.add(conteneurCarte, BorderLayout.CENTER);
		this.add(conteneurHeader, BorderLayout.NORTH);
		this.add(infoFooter, BorderLayout.SOUTH);
		
		// gestion affichage info footer
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				p.setX(e.getX());p.setY(e.getY());
				try {
					if ((conteneurCarte.getMap().getElement(p)) instanceof Soldat)
					{
					s = (Soldat)conteneurCarte.getMap().getElement(p);
					}
					} catch (MonException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				// mise à jour footer
				if (s!=null ) {
				infoFooter.setText(s.toString());
				infoFooter.repaint();
				}
			}
		});
		

		// mise à jour header
		messageHeader.setText("Il reste " + Heros.nbrHeros + " héros et " + Monstres.nbrMonstres + " monstres");
		messageHeader.repaint();
		
		
		
		
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
				
				// action changer la background
				boutonBack.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent agr){
						
						Carte carte=conteneurCarte.getMap();
						carte.setBack();
						
					}
				});
				
				
				addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e){
						int x = e.getX();
						int y = e.getY();
						
						System.out.println("P: X=   "+x/IConfig.NB_PIX_CASE+"||| Y=   "+y/IConfig.NB_PIX_CASE);
						
					Position p=new Position(x,y);
					
					px=p.getX();
					py=p.getY();
					
					Carte carte=conteneurCarte.getMap();
					//Get lhero a la position pressed
					
					try {
						if (carte.getElement(p) instanceof Soldat)
						{
						H=(Heros)carte.getElement(p);
						}
					
						
						//System.out.println("Pelm: X=   "+Elm.getPos().getX()+"||| Y=   "+Elm.getPos().getY());
						
					} catch (MonException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					}
					
					public void mouseReleased(MouseEvent e) {
						
						int x = e.getX()/ IConfig.NB_PIX_CASE;
						int y = e.getY()/ IConfig.NB_PIX_CASE-1;
						
						
						Position p= new Position(x,y);
						
				Carte carte=conteneurCarte.getMap();
			
				//Chercher le monstre M dans la table Elements avec la position p Realeased 
				Element tab[]=carte.getTabElements();
			
				//System.out.println("----------------------   "+M.getPos().getX());
				
				for (int k=0;k<tab.length;k++)
				{
					if (tab[k].getPos().getX()==p.getX() &&tab[k].getPos().getY()==p.getY()  )
					{  
						if (tab[k] instanceof Monstres)
						{
						M=(Monstres) tab[k];
						}
					}
					
				}
				
				System.out.println("--------------"+M);
						//On fait combat entre H et M
				if (M!=null)
				{
				H.combat(M);	
				M=null;
				}
				else
				{
				if (p.estValide()&& p.estVoisine(H.getPos()) && carte.estVide(p)&&(H.dejaJouee==0))	
				{
						H.getPos().setX(x);
						H.getPos().setY(y);
						H.dejaJouee=1;
						
						
				}	
				
				
				}
			
				
				
		
				
						repaint();
				
						

					
				}
					
					
				});	
				
		
				
				
				
				
				
				
				
				
	}
	
	public PanneauCarte getConteneurCarte() {return conteneurCarte;}
	

	
	
	
}

