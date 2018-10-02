
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class DCommand 
{
	Save aSave = new Save();
	Open aFopen = new Open();
	Black aBlack = new Black();
	Data data;
	DDraw ddraw;
	
	class Save implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String s = "{\"Shapes\":[";
			for (PShape p : ddraw.pp)
			{
				s += "{\"shape\":" + p.getShape() + ",\"x\":" + p.getStartX() + ",\"y\":" + p.getStartY()
				+ ",\"x2\":" + p.getEndX() + ",\"y2\":" + p.getEndY() + ",\"stroke\":" + p.getStroke() + ",\"color\":" + p.getColor() + "},";
			}
			s += "]}";
			
			
			String fileName = null;
			JFileChooser fileOpen = new JFileChooser(".");    
			fileOpen.setFileFilter(new FileNameExtensionFilter("", "json"/*, "xml", "yaml", "csv"*/));


			int ret = fileOpen.showDialog(null, "Save image");                
			if (ret == JFileChooser.APPROVE_OPTION)
			{
				File file = fileOpen.getSelectedFile();
				fileName = file.getName();
			}			

			try
			{
				FileWriter fw = new FileWriter(fileName);
				fw.write(s);
				fw.close();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}		
		}		
	}



	class Open extends JFrame implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ddraw.pp.clear();
			String fileName = null;
			JFileChooser fileOpen = new JFileChooser(".");  
//			fileopen.setCurrentDirectory(new File("C:\\путь\\к_вашей\\папке\\"));
			fileOpen.setFileFilter(new FileNameExtensionFilter("", "json"/*, "xml", "yaml", "csv"*/));
			fileOpen.setAcceptAllFileFilterUsed(false);

			int ret = fileOpen.showDialog(null, "Open image");                
			if (ret == JFileChooser.APPROVE_OPTION)
			{
				File file = fileOpen.getSelectedFile();
				fileName = file.getName();
			}

			String s = "";
			try
			{
				FileReader fr = new FileReader(fileName);
				java.util.Scanner scan = new java.util.Scanner(fr);

				s = scan.nextLine();

				fr.close();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			} 

			String[] shapes = s.split("^\\{\"Shapes\":\\[\\{|\\},\\{|\\},\\]\\}");
			
			for (int i = 1; i < shapes.length; i++)
			{
				//System.out.println(shapes[i]);
				String[] shape = shapes[i].split("(\"shape\":)|(,\"x\":)|(,\"y\":)|(,\"x2\":)|(,\"y2\":)|(,\"stroke\":)|(,\"color\":)");
				PShape p = null;
				switch (shape[1])
				{
				case "PRectangle":
					p = new PRectangle();
					p.init(Integer.parseInt(shape[2]),Integer.parseInt(shape[3]),Integer.parseInt(shape[4]),Integer.parseInt(shape[5]),Integer.parseInt(shape[6]),Integer.parseInt(shape[7]));
					break;
				case "POval":
					p = new POval();
					p.init(Integer.parseInt(shape[2]),Integer.parseInt(shape[3]),Integer.parseInt(shape[4]),Integer.parseInt(shape[5]),Integer.parseInt(shape[6]),Integer.parseInt(shape[7]));
					break;
				case "PLine":
					p = new PLine();
					p.init(Integer.parseInt(shape[2]),Integer.parseInt(shape[3]),Integer.parseInt(shape[4]),Integer.parseInt(shape[5]),Integer.parseInt(shape[6]),Integer.parseInt(shape[7]));
					break;
				}	
				ddraw.pp.add(p);
				ddraw.repaint();
			}
		}		
	}



	class Black implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setColor(-16777216);
		}
	}

	Red aRed = new Red();
	class Red implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setColor(-65536) ;
		}
	}

	Green aGreen = new Green();
	class Green implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setColor(-16711936);
		}
	}


	Yellow aYellow = new Yellow();
	class Yellow implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setColor(-256);
		}
	}

	Widatah5 aWidth5 = new Widatah5();
	class Widatah5 implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setWidth(5);
		}
	}	


	Widatah10 aWidth10 = new Widatah10();
	class Widatah10 implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setWidth(10);
		}
	}

	public Width15 aWidth15 = new Width15();
	class Width15 implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setWidth(15);
		}
	}

	Curves aCurves = new Curves();
	class Curves implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setType("curves");
		}
	}

	Line aLine = new Line();
	class Line implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setType("line");
		}
	}

	Rectangle aRectangle = new Rectangle();
	class Rectangle implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setType("rectangle") ;
		}
	}

	Oval aOval = new Oval();
	class Oval implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			data.setType("oval");	
		}
	}
}	