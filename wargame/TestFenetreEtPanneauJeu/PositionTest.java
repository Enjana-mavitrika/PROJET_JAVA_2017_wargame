public class PositionTest
{
  private int posX = 0;
  private int posY = 0;

  public PositionTest(int x, int y){posX = x; posY = y;}
  public void setPosX(int x){posX = x;}
  public void setPosY(int y){posY = y;}
  public int getPosX(){return posX;}
  public int getPosY(){return posY;}
}
