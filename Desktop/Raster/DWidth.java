import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DWidth extends JPanel 
{
	
	DWidth()
	{
		DCommand dc = new DCommand();
		setBounds(512,294,172,112);
		 setBackground(Color.RED);
		 setLayout(null);
		 
		 JButton five = new JButton("5");
		 five.setBounds(7,5,160,30);
		 add(five);
		 five.addActionListener(dc.aWidth5);
		 
		 JButton ten = new JButton("10");
		 ten.setBounds(7,40,160,30);
		 add(ten);
		 ten.addActionListener(dc.aWidth10);
		 
		 JButton fifteen = new JButton("15");
		 fifteen.setBounds(7,75,160,30);
		 add(fifteen);
		 fifteen.addActionListener(dc.aWidth15);
	}
}
