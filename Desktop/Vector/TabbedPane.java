import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JFrame
{
	int i = 0;
	
	TabbedPane()
	{
	 Font font = new Font("Verdana", Font.PLAIN, 10);
     final JTabbedPane tabbedPane = new JTabbedPane();
     tabbedPane.setFont(font);

     JPanel content = new JPanel();
     content.setLayout(new BorderLayout());

     JPanel buttons = new JPanel();
     content.add(buttons, BorderLayout.NORTH);

     JButton add = new JButton("Добавить");
     add.setFont(font);
     add.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             tabbedPane.addTab("Вкладка " + i++, new JPanel());
         }
     });
     buttons.add(add);

     JButton remove = new JButton("Удалить");
     remove.setFont(font);
     remove.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             int select = tabbedPane.getSelectedIndex();
             if (select >= 0) {
                 tabbedPane.removeTabAt(select);
             }
         }
     });
     buttons.add(remove);

     content.add(tabbedPane, BorderLayout.CENTER);

     getContentPane().add(content);

     setPreferredSize(new Dimension(260, 220));
     pack();
     setLocationRelativeTo(null);
     setVisible(true);
 }
	}

