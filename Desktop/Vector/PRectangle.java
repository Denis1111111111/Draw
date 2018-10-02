import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PRectangle implements PShape
{
	int x,y,x1,y1,width,clr;
	String type;
	
	
	@Override
	public void init(int x, int y, int x1, int y1, int clr, int width) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.x1 = x1;
		this.y1 = y1;
		this.clr = clr;
		
	}
	
	@Override
	public void draw(Graphics2D gg)
	{
		gg.setColor(new Color(clr));
		gg.setStroke(new BasicStroke(width));
		gg.drawRect(x, y, x1-x, y1-y);
	}

	@Override
	public int getStartX()
	{
		return x;
	}

	@Override
	public int getStartY()
	{
		return y;
	}

	@Override
	public int getEndX()
	{
		return x1;
	}

	@Override
	public int getEndY()
	{
		return y1;
	}

	@Override
	public int getStroke()
	{
		return width;
	}

	@Override
	public int getColor()
	{
		return clr;
	}

	@Override
	public String getShape()
	{
		return this.getClass().getName();		
	}
}
