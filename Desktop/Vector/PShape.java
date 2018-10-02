import java.awt.Color;
import java.awt.Graphics2D;

public interface PShape 
{
	void init (int x,int y,int x1, int y1, int clr,int width);
	void draw(Graphics2D gg);
	int getStartX();
	int getStartY();
	int getEndX();
	int getEndY();
	int getStroke();
	int getColor();
	String getShape();
}
