package jOptionalPane;
import javax.swing.*;  
public class JShowMessageDialogWithType {
	JFrame f;  
	JShowMessageDialogWithType(){  
	    f=new JFrame();  
	    JOptionPane.showMessageDialog(f,"Successfully Updated.","Alert",JOptionPane.ERROR_MESSAGE);     
	}  
	public static void main(String[] args) {  
	    new JShowMessageDialogWithType();  
	}  
}
