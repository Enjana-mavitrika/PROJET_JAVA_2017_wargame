package wargame;

public class MonException extends Exception {
	public MonException(Element tabElement[], Position pos) {
		for (int i = 0; i < tabElement.length; i++) {
			if (tabElement[i].getPos().getX() == pos.getX() && tabElement[i].getPos().getY() == pos.getY())
			{
			}
			else {
				System.out.println("case vide !!");
			}
		}
	}
}
