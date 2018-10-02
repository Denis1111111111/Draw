import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	DDraw draw;
	
	Panel()
	{
		setBounds(0,21,510,600);
		setBackground(Color.YELLOW);
		setLayout(null);
		draw = new DDraw();
		add(draw);
	}
}
