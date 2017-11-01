import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
public class ElementTest
{
    public static final char MONSTRE = 'M';
    public static final char HEROS = 'H';
    public static final char EAU = 'E';
    public static final char ROCHER = 'R';
    public static final char FORET = 'F';
    public static int nbrElement = 0;
    private int numero;
    private char type ;
    private PositionTest pos;

    public ElementTest(char type, PositionTest pos)
    {
	nbrElement++;
	numero = nbrElement;
	this.type = type;
	this.pos = pos;
    }

    public void setType(char type){this.type = type;}
    public void setPos(PositionTest pos){this.pos = pos;}
    public char getType(){return type;}
    public PositionTest getPos(){return pos;}
    public void seDessiner(Graphics g)
    {
	Font font = new Font("courier",  Font.BOLD, IConfig.POLICE_NUMERO_CASE);
	switch(type)
	    {
	    case MONSTRE:
		g.setColor(IConfig.COULEUR_MONSTRES);
		g.fillRect( (pos.getPosX() - 1) * IConfig.NB_PIX_CASE, (pos.getPosY() - 1) * IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);
		g.setFont(font);
		g.setColor(IConfig.COULEUR_VIDE);
		g.drawString(""+ numero, (pos.getPosX() - 1) * IConfig.NB_PIX_CASE + IConfig.NB_PIX_CASE / 4, (pos.getPosY() - 1) * IConfig.NB_PIX_CASE + IConfig.NB_PIX_CASE - IConfig.NB_PIX_CASE / 4);
		break;
	    case HEROS:
		g.setColor(IConfig.COULEUR_HEROS);
		g.fillRect((pos.getPosX() - 1) * IConfig.NB_PIX_CASE, (pos.getPosY() - 1) * IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);
		g.setColor(IConfig.COULEUR_TEXTE);
		g.drawString("" + numero, (pos.getPosX() - 1) * IConfig.NB_PIX_CASE + IConfig.NB_PIX_CASE / 4, (pos.getPosY() - 1) * IConfig.NB_PIX_CASE + IConfig.NB_PIX_CASE - IConfig.NB_PIX_CASE / 4);
		break;
	    case EAU:
		g.setColor(IConfig.COULEUR_EAU);
		g.fillRect( (pos.getPosX() - 1) * IConfig.NB_PIX_CASE, (pos.getPosY() - 1) * IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);
		break;
	    case FORET:
		g.setColor(IConfig.COULEUR_FORET);
		g.fillRect((pos.getPosX() - 1) * IConfig.NB_PIX_CASE, (pos.getPosY() - 1) * IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);
		break;
	    case ROCHER:
		g.setColor(IConfig.COULEUR_ROCHER);
		g.fillRect((13 - 1) * IConfig.NB_PIX_CASE, (10 - 1) * IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);
		break;
	    }
    }
}
