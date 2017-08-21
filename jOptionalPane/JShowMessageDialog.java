package jOptionalPane;
import javax.swing.*;  

public class JShowMessageDialog {
	JFrame f;  
	JShowMessageDialog(){  
	    f=new JFrame();  
	    JOptionPane.showMessageDialog(f,"Hello, Welcome to Javatpoint.");  
	}  
	public static void main(String[] args) {  
	    new JShowMessageDialog();  
	}  
}
