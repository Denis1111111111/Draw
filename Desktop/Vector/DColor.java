import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class DColor extends JPanel 
{
	DCommand dc;
	Data data;
	
	DColor(Data data, DCommand dc)
	{
		this.dc = dc;
		this.data = data;
		setBounds(512,147,172,147);
		setBackground(Color.BLACK);
		setLayout(null);

		JButton black = new JButton("Black");
		black.setBounds(7,5,160,30);
		add(black);
		black.addActionListener(dc.aBlack);

		JButton red = new JButton("Red");
		red.setBounds(7,40,160,30);
		add(red);
		red.addActionListener(dc.aRed);

		JButton green = new JButton("Green");
		green.setBounds(7,75,160,30);
		add(green);
		green.addActionListener(dc.aGreen);

		JButton yellow = new JButton("Yellow");
		yellow.setBounds(7,110,160,30);
		add(yellow);
		yellow.addActionListener(dc.aYellow);
	}
}
