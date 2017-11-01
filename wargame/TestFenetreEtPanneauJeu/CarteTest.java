import java.awt.Graphics;
public class CarteTest
{
    private ElementTest elements[] = new ElementTest[3];
    public CarteTest()
    {
	elements[0] = new ElementTest(ElementTest.EAU, new PositionTest(3, 4));
	elements[1] = new ElementTest(ElementTest.MONSTRE, new PositionTest(9, 14));
	elements[2] = new ElementTest(ElementTest.HEROS, new PositionTest(9, 5));
    }
    public void seDessiner(Graphics g)
    {
	// affichage carte vide
	g.setColor(IConfig.COULEUR_VIDE);
	for (int y = 0; y < IConfig.HAUTEUR_CARTE * IConfig.NB_PIX_CASE; y += IConfig.NB_PIX_CASE)
	    {
		for (int x = 0; x <= IConfig.LARGEUR_CARTE * IConfig.NB_PIX_CASE; x += IConfig.NB_PIX_CASE)
		    g.drawRect(x, y, IConfig.NB_PIX_CASE, IConfig.NB_PIX_CASE);
	    }
	for (int i = 0; i < elements.length; i++)
	    {
		elements[i].seDessiner(g);
	    }
    }
}
