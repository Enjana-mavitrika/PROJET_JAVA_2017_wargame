import java.awt.Color;
public interface IConfig {
  int LARGEUR_CARTE = 30; int HAUTEUR_CARTE = 30; // en nombre de cases
  int NB_PIX_CASE = 20;
  int POSITION_X = 100; int POSITION_Y = 50; // Position de la fenetre
  int NB_HEROS = 6; int NB_MONSTRES = 15; int NB_OBSTACLES = 20;
  int POLICE_NUMERO_CASE = 16; 	// police du numero de la case en pix
  Color COULEUR_VIDE = Color.white, COULEUR_INCONNU = Color.lightGray;
  Color COULEUR_TEXTE = Color.black, COULEUR_MONSTRES = Color.black;
  Color COULEUR_HEROS = Color.red, COULEUR_HEROS_DEJA_JOUE = Color.pink;
  Color COULEUR_EAU = Color.blue, COULEUR_FORET = Color.green, COULEUR_ROCHER = Color.gray;
}
