package wargame;
import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class FenetreJeu extends JFrame {

	PanneauJeu panJeu;
	public  FenetreJeu() {
		panJeu = new PanneauJeu();
		setTitle("Wargame");
		setSize(IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE, IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE + 200); 
		setLocation(IConfig.POSITION_X, IConfig.POSITION_Y);
		setContentPane(panJeu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		
	}
}
