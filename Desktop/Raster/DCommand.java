import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	DDraw ddraw;
	
	class Save implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser fc = new JFileChooser();  
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
			fc.addChoosableFileFilter(filter);
			fc.setCurrentDirectory(new File("C:\\Users\\Denis\\Pictures\\"));
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
			{  
				System.out.println(fc.getSelectedFile());
				try {  
					switch(fc.getTypeDescription(fc.getSelectedFile()))
					{
					case "Generic File":
					{
						ImageIO.write(ddraw.bi,"JPEG",new File(""+fc.getSelectedFile()+".jpg"));
						break;
					}
					case"Файл \"JPG\"":
					{
						ImageIO.write(ddraw.bi,"JPEG",new File(""+fc.getSelectedFile()));
						break;
					}
					default:
					{
						JOptionPane.showMessageDialog(fc, "The file format must be \"jpg\"", null, 0);
					}
					}
				} 
				catch (Exception a) 
				{
					System.out.println("Что-то пошло не так...");
				}  
			} 
		}	
	}



	class Open extends JFrame implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg", "gif");
			fc.setFileFilter(filter);
			fc.setCurrentDirectory(new File("C:\\Users\\Denis\\Pictures\\"));
			int returnVal = fc.showOpenDialog(getParent());
			if(returnVal == JFileChooser.APPROVE_OPTION) 
			{
				try 
				{
					ddraw.bi = ImageIO.read(new File(""+fc.getSelectedFile()));
					ddraw.gg = (Graphics2D) ddraw.bi.getGraphics();
					ddraw.repaint();
				} 
				catch (IOException h) 
				{
					System.out.println("Error");
				}
			}	
		}
	}



	class Black implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.clr = -16777216;
		}
	}

	Red aRed = new Red();
	class Red implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.clr = -65536;
		}
	}

	Green aGreen = new Green();
	class Green implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.clr = -16711936;
		}
	}


	Yellow aYellow = new Yellow();
	class Yellow implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.clr = -256;
		}
	}

	Widatah5 aWidth5 = new Widatah5();
	class Widatah5 implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.width = 5;
		}
	}	


	Widatah10 aWidth10 = new Widatah10();
	class Widatah10 implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.width = 10;
		}
	}

	Width15 aWidth15 = new Width15();
	class Width15 implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.width = 15;
		}
	}

	Curves aCurves = new Curves();
	class Curves implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.type = "curves";
		}
	}

	Line aLine = new Line();
	class Line implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.type = "line";
		}
	}

	Rectangle aRectangle = new Rectangle();
	class Rectangle implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.type = "rectangle";
		}
	}

	Oval aOval = new Oval();
	class Oval implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Data.type = "oval";	
		}
	}
}	