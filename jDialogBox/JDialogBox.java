package jDialogBox;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
public class JDialogBox {
	 private static JDialog d;  
	 JDialogBox() {  
	        JFrame f= new JFrame("frame");  
	        d = new JDialog(f , "Dialog Example", true);  
	        d.setLayout( new FlowLayout() );  
	        JButton b = new JButton ("OK");  
	        b.addActionListener ( new ActionListener()  
	        {  
	            public void actionPerformed( ActionEvent e )  
	            {  
	            	JDialogBox.d.setVisible(false);  
	            }  
	        });  
	        d.add( new JLabel ("Click button to continue."));  
	        d.add(b);   
	        d.setSize(300,300);    
	        d.setVisible(true);  
	    }  
	    public static void main(String args[])  
	    {  
	        new JDialogBox();  
	    }  
}
