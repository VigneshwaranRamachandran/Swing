import javax.swing.JButton;
import javax.swing.JFrame;

public class ExdendsFromJFrame extends  JFrame{
	JFrame f;  
	ExdendsFromJFrame(){  
	JButton b=new JButton("click");//create button  
	b.setBounds(130,100,100, 40);  
	          
	add(b);//adding button on frame  
	setSize(400,500);  
	setLayout(null);  
	setVisible(true);  
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	}  
	public static void main(String[] args) {
		new ExdendsFromJFrame();

	}

}
