import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Frame extends JFrame
{
	DCommand dc = new DCommand();

	Frame()
	{
		setBounds(300,100,700,600);
		setTitle("RASTER PAINT");

		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Panel pan = new Panel();
		dc.ddraw = pan.draw;
		add(pan);

		DType dtype = new DType();
		add(dtype);

		DColor dcolor = new DColor();
		add(dcolor);

		DWidth dwidth = new DWidth();
		add(dwidth);

		JButton save = new JButton("Save");
		save.setBounds(519,415,160,30);
		add(save);
		save.addActionListener(dc.aSave);

		JButton load = new JButton("Load");
		load.setBounds(519,450,160,30);
		add(load);
		load.addActionListener(dc.aFopen);

		JMenuBar menuBar1 = new JMenuBar();
		setJMenuBar(menuBar1);

		JMenu file = new JMenu("File");
		JMenuItem fload = new JMenuItem("Load", new ImageIcon("images/open.png"));
		JMenuItem fsave = new JMenuItem("Save",  new ImageIcon("images/open.png"));
		file.add(fload);
		fload.addActionListener(dc.aFopen);

		fsave.addActionListener(dc.aSave);
		file.add(fsave);
		menuBar1.add(file);





		JMenu type = new JMenu("Type");
		JMenuItem curves = new JMenuItem("Curves", new ImageIcon("images/open.png"));
		curves.addActionListener(dc.aCurves);

		JMenuItem line = new JMenuItem("Line", new ImageIcon("images/open.png"));
		line.addActionListener(dc.aLine);

		JMenuItem rectangle = new JMenuItem("Rectangle", new ImageIcon("images/open.png"));
		rectangle.addActionListener(dc.aRectangle);

		JMenuItem oval = new JMenuItem("Oval", new ImageIcon("images/open.png"));
		oval.addActionListener(dc.aOval);
		type.add(curves);
		type.add(line);
		type.add(rectangle);
		type.add(oval);
		menuBar1.add(type);

		JMenu color = new JMenu("Color");

		JMenuItem black = new JMenuItem("Black", new ImageIcon("images/open.png"));
		black.addActionListener(dc.aBlack);

		JMenuItem red = new JMenuItem("Red",  new ImageIcon("images/open.png"));
		red.addActionListener(dc.aRed);

		JMenuItem green = new JMenuItem("Green",  new ImageIcon("images/open.png"));	
		green.addActionListener(dc.aGreen);

		JMenuItem yellow = new JMenuItem("Yellow",  new ImageIcon("images/open.png"));
		yellow.addActionListener(dc.aYellow);
		color.add(black);
		color.add(red);
		color.add(green);
		color.add(yellow);
		menuBar1.add(color);

		JMenu width = new JMenu("Width");
		JMenuItem five = new JMenuItem("5", new ImageIcon("images/open.png"));
		five.addActionListener(dc.aWidth5);

		JMenuItem ten = new JMenuItem("10", new ImageIcon("images/open.png"));
		ten.addActionListener(dc.aWidth10);

		JMenuItem fifteen = new JMenuItem("15", new ImageIcon("images/open.png"));
		fifteen.addActionListener(dc.aWidth15);
		width.add(five);
		width.add(ten);
		width.add(fifteen);
		menuBar1.add(width);

		
		JToolBar toolBar = new JToolBar("Instruments");
        toolBar.setBounds(0,0,800,20);
        toolBar.setLayout(null);
        JButton toolBarItem_typeCurves = new JButton("Curves");
        toolBarItem_typeCurves.setBounds(0,0, 55, 20);
        toolBarItem_typeCurves.addActionListener(dc.aCurves);
        toolBar.add(toolBarItem_typeCurves);
        JButton toolBarItem_typeRectangle = new JButton("Rectangle");
        toolBarItem_typeRectangle.setBounds(54,0, 60, 20);
        toolBarItem_typeRectangle.addActionListener(dc.aRectangle);
        toolBar.add(toolBarItem_typeRectangle);
        JButton toolBarItem_typeEllipse = new JButton("Oval");
        toolBarItem_typeEllipse.setBounds(105,0, 60, 20);
        toolBarItem_typeEllipse.addActionListener(dc.aOval);
        toolBar.add(toolBarItem_typeEllipse);
        JButton toolBarItem_typeLine = new JButton("Line");
        toolBarItem_typeLine.setBounds(164,0, 60, 20);
        toolBarItem_typeLine.addActionListener(dc.aLine);
        toolBar.add(toolBarItem_typeLine);
        
        JButton toolBarItem_colorBlack = new JButton();
        toolBarItem_colorBlack.setBounds(224,0, 20, 20);
        toolBarItem_colorBlack.setBackground(Color.BLACK);
        toolBarItem_colorBlack.addActionListener(dc.aBlack);
        toolBar.add(toolBarItem_colorBlack);
        
        JButton toolBarItem_colorRed = new JButton();
        toolBarItem_colorRed.setBounds(244,0, 20, 20);
        toolBarItem_colorRed.setBackground(Color.RED);
        toolBarItem_colorRed.addActionListener(dc.aRed);
        toolBar.add(toolBarItem_colorRed);
        
        JButton toolBarItem_colorGreen = new JButton();
        toolBarItem_colorGreen.setBounds(263,0, 20, 20);
        toolBarItem_colorGreen.setBackground(Color.GREEN);
        toolBarItem_colorGreen.addActionListener(dc.aGreen);
        toolBar.add(toolBarItem_colorGreen);
        
        JButton toolBarItem_colorYellow = new JButton();
        toolBarItem_colorYellow.setBounds(283,0, 20, 20);
        toolBarItem_colorYellow.setBackground(Color.YELLOW);
        toolBarItem_colorYellow.addActionListener(dc.aYellow);
        toolBar.add(toolBarItem_colorYellow);
        
        JButton toolBarItem_widthfive = new JButton("5");
        toolBarItem_widthfive.setBounds(303,0, 25, 20);
        toolBarItem_widthfive.addActionListener(dc.aWidth5);
        toolBar.add(toolBarItem_widthfive);
        
        JButton toolBarItem_widthTen = new JButton("10");
        toolBarItem_widthTen.setBounds(323,0, 25, 20);
        toolBarItem_widthTen.addActionListener(dc.aWidth10);
        toolBar.add(toolBarItem_widthTen);
        
        JButton toolBarItem_widthFifteen = new JButton("15");
        toolBarItem_widthFifteen.setBounds(343,0, 25, 20);
        toolBarItem_widthFifteen.addActionListener(dc.aWidth15);        
        toolBar.add(toolBarItem_widthFifteen);
        add(toolBar);
		setVisible(true);	
	}
}

