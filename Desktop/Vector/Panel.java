import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	DDraw draw;
	Data data;
	Panel(Data data)
	{
		this.data = data;
		setLayout(null);
		setBounds(0,21,510,600);
		setBackground(Color.YELLOW);
		draw = new DDraw(data);
		add(draw);
	}
}
