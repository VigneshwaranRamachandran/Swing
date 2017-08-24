package basicSwing.titleBarIcon;
import java.awt.*;

import javax.swing.JFrame; 
public class TitleBarIconFix {
	TitleBarIconFix(){     
		JFrame f=new JFrame();     
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\VIGN\\Desktop\\payment.png");    
		f.setIconImage(icon);    
		f.setLayout(null);     
		f.setSize(400,400);     
		f.setVisible(true);  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}     
		public static void main(String args[]){     
		new TitleBarIconFix();     
		}     
}
