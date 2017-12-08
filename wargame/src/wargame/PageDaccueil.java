package wargame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PageDaccueil extends JPanel implements IConfig {
	Image img ; 
	
	public PageDaccueil() throws IOException {
		
		img = ImageIO.read(new File("image/backgound.png"));
		//img.getScaledInstance(LARGEUR_CARTE, HAUTEUR_CARTE, 0);
		
		setBackground(Color.GRAY);
		setPreferredSize( new Dimension(IConfig.LARGEUR_CARTE+100, IConfig.HAUTEUR_CARTE+100));
		Font font = new Font("SansSerif", Font.ITALIC, 30);
		
		JLabel text1 = new JLabel(" Bienvenu dans le jeux WARGAME");
		text1.setForeground(Color.RED);
		text1.setVerticalAlignment(SwingConstants.CENTER);
		text1.setFont(font);

		JLabel text2 = new JLabel( " Pour commencer le jeux aller dans le menu ") ;
		text2.setForeground(Color.GREEN);
		text2.setVerticalAlignment(SwingConstants.CENTER);
		text2.setFont(font);
		
		
		JLabel text3 = new JLabel( " 1-(nlle-partie) you start new Game ") ;
		text3.setForeground(Color.GREEN);
		text3.setVerticalAlignment(SwingConstants.CENTER);
		text3.setFont(font);
		
		JLabel text4 = new JLabel( " 2- (Mode) You choose Game Mode ") ;
		text4.setForeground(Color.GREEN);
		text4.setVerticalAlignment(SwingConstants.CENTER);
		text4.setFont(font);
		
		JLabel text5 = new JLabel( "3- (Quitter)  quit the Game  ") ;
		text5.setForeground(Color.GREEN);
		text5.setVerticalAlignment(SwingConstants.CENTER);
		text5.setFont(font);
		
		this.add(text1);
		this.add(text2);
		this.add(text3);
		this.add(text4);
		this.add(text5);
		
		
		
		
	}
	
	public void paintComponent( Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, IConfig.LARGEUR_CARTE*NB_PIX_CASE, IConfig.HAUTEUR_CARTE*NB_PIX_CASE, null);
	}
}
