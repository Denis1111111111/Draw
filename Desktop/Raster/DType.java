import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DType extends JPanel
{
	
	DType()
	{
	
		DCommand dc = new DCommand();
 setBounds(512,0,172,147);
 setBackground(Color.BLUE);
 setLayout(null);
 
 JButton curves = new JButton("Curves");
 curves.setBounds(7,5,160,30);
 add(curves);
 curves.addActionListener(dc.aCurves);
 
 JButton line = new JButton("Line");
 line.setBounds(7,40,160,30);
 add(line);
 line.addActionListener(dc.aLine);
 
 JButton rectangle = new JButton("Rectangle");
 rectangle.setBounds(7,75,160,30);
 add(rectangle);
 rectangle.addActionListener(dc.aRectangle);
 
 JButton oval = new JButton("Oval");
 oval.setBounds(7,110,160,30);
 add(oval);
 oval.addActionListener(dc.aOval);
	}
}
