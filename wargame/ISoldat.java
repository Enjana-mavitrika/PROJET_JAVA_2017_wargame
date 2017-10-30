package wargame;
public interface ISoldat {
   static enum TypesH {
      HUMAIN (40,3,10,2), NAIN (80,1,20,0), ELF (70,5,10,6), HOBBIT (20,3,5,2);
      private final int POINTS_DE_VIE, PORTEE_VISUELLE, PUISSANCE, TIR;
      TypesH(int points, int portee, int puissance, int tir) {
POINTS_DE_VIE = points; PORTEE_VISUELLE = portee;
PUISSANCE = puissance; TIR = tir;
      }
      public int getPoints() { return POINTS_DE_VIE; }
      public int getPortee() { return PORTEE_VISUELLE; }
      public int getPuissance() { return PUISSANCE; }
      public int getTir() { return TIR; }
      public static TypesH getTypeHAlea() {
         return values()[(int)(Math.random()*values().length)];
      }
   }
   public static enum TypesM {
      TROLL (100,1,30,0), ORC (40,2,10,3), GOBELIN (20,2,5,2);
      private final int POINTS_DE_VIE, PORTEE_VISUELLE, PUISSANCE, TIR;
      TypesM(int points, int portee, int puissance, int tir) {
POINTS_DE_VIE = points; PORTEE_VISUELLE = portee;
PUISSANCE = puissance; TIR = tir;
      }
      public int getPoints() { return POINTS_DE_VIE; }
      public int getPortee() { return PORTEE_VISUELLE; }
      public int getPuissance() { return PUISSANCE; }
      public int getTir() { return TIR; } 
      public static TypesM getTypeMAlea() {
         return values()[(int)(Math.random()*values().length)];
      }
   }
   int getPoints(); int getTour(); int getPortee();
   void joueTour(int tour);
   void combat(Soldat soldat);
   void seDeplace(Position newPos);
}