package actionListener;
import java.awt.event.*;  
import javax.swing.*;
public class ButtonClickWelcomeMsg extends Thread{

	public static void main(String[] args) {
		  JFrame f=new JFrame("Button Example");  
		    final JTextField tf=new JTextField(); 
		    JLabel l = new JLabel();
		    tf.setBounds(50,50, 150,20);  
		    JButton b=new JButton("Click Here");  
		    b.setBounds(50,100,95,30);  
		    b.addActionListener(new ActionListener(){  
		public void actionPerformed(ActionEvent e){  
					
		            tf.setText("Welcome to Javatpoint.");  
		            f.add(tf);
		           // String s=tf.getText();
		            l.setText(tf.getText());
		            l.setBounds(100, 200, 95, 30);
		        }  
		    });  
		    f.add(b); 
//		    try {
//				sleep(2000);
//				f.remove(tf);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		    f.setSize(400,400);  
		    f.setLayout(null);  
		    f.setVisible(true);   

	}

}
