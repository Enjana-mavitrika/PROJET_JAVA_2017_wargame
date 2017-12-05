package wargame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
public class Element implements IConfig, Serializable
{

protected Color texture;
protected Position pos;
protected boolean vide;
protected boolean heros;
protected boolean monstre;
protected boolean obstacle;
protected Image img;

public Element()
{
	pos = new Position(-1, -1);
	vide = true;
	texture = Color.WHITE;
}

  
  public Position getPos() {return pos;}
  public boolean estHero() {
	  return heros;
  }
  
  public boolean estMonstre() {
	  return monstre;
  }
  
  public boolean estObstacle() {
	  return obstacle;
  }
  
  
  public void seDessine(Graphics g)
  {
  	g.setColor(texture);
  	g.fillRect(pos.getX() * NB_PIX_CASE, pos.getY() * NB_PIX_CASE, NB_PIX_CASE, NB_PIX_CASE);
  }

  
}
