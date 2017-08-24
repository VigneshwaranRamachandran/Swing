package basicSwing.jOptionalPane;

import javax.swing.*;

public class JShowInputDialog {
	JFrame f;
	JLabel j=new JLabel();

	JShowInputDialog() {
		f = new JFrame();
		String name = JOptionPane.showInputDialog(f, "Enter Name");
j.setText(name);
j.setBounds(100, 50,50, 50);
f.add(j);
f.setSize(300,300);  
f.setLayout(null);  
f.setVisible(true); 
	}

	public static void main(String[] args) {
		new JShowInputDialog();
	}
}
