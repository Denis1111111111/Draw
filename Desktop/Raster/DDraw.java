	import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DDraw extends JPanel implements MouseListener, MouseMotionListener
{
	int x,y,x2,y2;

	BufferedImage bi = new BufferedImage(800,840,BufferedImage.SCALE_DEFAULT);
	Graphics2D gg;
	
	DDraw()
	{
		setBounds(0,0,800,840);
		gg = (Graphics2D) bi.getGraphics();
		gg.setColor(new Color(-1));
		gg.fillRect(0, 0, 800, 840);
		addMouseListener(this);
		addMouseMotionListener(this);
	}


	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.drawImage(bi,0,0,null);
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();	
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		int x2 = e.getX();
		int y2 = e.getY();

		if ( Data.type.equals("curves"))
			return;


		gg.setColor(new Color(Data.clr));
		gg.setStroke(new BasicStroke(Data.width));

		switch (Data.type)
		{
		case "rectangle":
			gg.drawRect(x, y, x2-x, y2-y);
			break;	
		case "roundRect":
			gg.drawRoundRect(x, y, x2-x, y2-y, 30, 30);
			break;	
		case "oval":
			gg.drawOval(x, y, x2-x, y2-y);
			break;	
		case "line":
			gg.drawLine(x, y, x2, y2);
			break;	
		default:
			break;
		}
		repaint();	
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
		x2 = e.getX();
		y2 = e.getY();

		if ( !Data.type.equals("curves"))
			return;
		
			gg.setColor(new Color(Data.clr));
			gg.setStroke(new BasicStroke(Data.width));
			gg.drawLine(x, y, x2, y2);
			x=x2;
			y=y2;
			repaint();			
	}

	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
	}	
}