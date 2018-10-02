import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DDraw extends JPanel implements MouseListener, MouseMotionListener
{
	Data data = null;
	int x,y,x2,y2;
	ArrayList<PShape> pp = new ArrayList<PShape>();

	public DDraw(Data data)
	{
		this.data = data;
		setBounds(0,0,800,840);
		setLayout(null);
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);	
//		TabbedPane tabbed = new TabbedPane();
//		add(tabbed);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		for (PShape shape : pp)
		{
			shape.draw(gg);
		}		
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
		
			int x1 = e.getX();
			int y1 = e.getY();

			if(data.getType().equals("curves"))
				return;

			Graphics2D gg = (Graphics2D) getGraphics();
			gg.setColor(new Color(data.getColor()));
			gg.setStroke(new BasicStroke(data.getWidth()));

			switch (data.getType())
			{
			case "rectangle":
				PRectangle rect = new PRectangle();
				rect.init(x, y, x1, y1, data.getColor(), data.getWidth());
				pp.add(rect);
				rect.draw(gg);
				break;	
				
			case "oval":
				POval ellipse = new POval();
				ellipse.init(x, y, x1, y1, data.getColor(), data.getWidth());
				pp.add(ellipse);
				ellipse.draw(gg);
				break;	
			case "line":
				PLine line = new PLine();
				line.init(x, y, x1, y1, data.getColor(), data.getWidth());
				pp.add(line);			
				line.draw(gg);
				break;	
			default:
				break;
			}	
		}
	

	@Override
	public void mouseDragged(MouseEvent e)
	{
		if ((e.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK)) return;

		int x1 = e.getX();
		int y1 = e.getY();

		if(!data.getType().equals("curves"))
			return;

		Graphics2D gg = (Graphics2D) getGraphics();
		gg.setColor(new Color(data.getColor()));
		gg.setStroke(new BasicStroke(data.getWidth()));
		gg.drawLine(x, y, x1, y1);
		x = x1;
		y = y1;	
	}	

	@Override
	public void mouseMoved(MouseEvent e)
	{

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}
}
