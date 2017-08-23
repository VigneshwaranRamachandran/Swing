package jTappedPane;
import javax.swing.*; 
public class JTappedPane {
	JFrame f;  
	JTappedPane(){  
	    f=new JFrame();  
	    JTextArea ta=new JTextArea(200,200);  
//	    JTextArea t=new JTextArea(200,200);  
//	    t.setBounds(100, 100, 100, 100);
	   // ta.setBounds(50,50,200,200);
	   // f.add(ta);
	    JPanel p1=new JPanel();  
	    p1.add(ta);  
	    JPanel p2=new JPanel();  
	    JPanel p3=new JPanel();  
	    JTabbedPane tp=new JTabbedPane();  
	    tp.setBounds(50,50,200,200);  
	    tp.add("main",p1);  
	    tp.add("visit",p2);  
	    tp.add("help",p3);    
	    f.add(tp);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	}  
	public static void main(String[] args) {  
	    new JTappedPane();  
	}
}
