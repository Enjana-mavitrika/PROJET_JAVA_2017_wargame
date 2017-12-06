package wargame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MonMenuAccueul extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonMenuAccueul() {
		super();
		JMenu monMenu = new JMenu("Menu");
		setAutoscrolls(true);
		setBackground(Color.BLUE);
		add(monMenu);
		JMenuItem Demarer = new JMenuItem(" nouvelle partie") ;
		
		JMenuItem Ouvrir = new JMenuItem(" Commencer") ;
		
		JMenuItem Quitter = new JMenuItem (" Quitter") ;
		
		
		monMenu.add(Quitter);
		monMenu.add(Ouvrir);
		monMenu.add(Demarer);
		
		
		Quitter.addActionListener(new ActionListener() {
			public void  actionPerformed (ActionEvent ev) {
				System.exit(0);
			}
		});
		
		Ouvrir.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		Demarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// il faut relancer le jeu quand on a fini un partie
				redemarrerPartie();
			}
		});
		
	}
	
	 public void redemarrerPartie(){
	    	Partie partie1 = new Partie();
	    	partie1.lancerPartie();
	    }
	
}
