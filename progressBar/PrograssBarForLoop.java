package progressBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class PrograssBarForLoop extends Frame {
	 JProgressBar jb;    
	JFrame f=new JFrame("IP Address"); 
	int i=0,num=0;  
	
	    
	PrograssBarForLoop(){ 
		
	f.setSize(450,450);    
	f.setLayout(null);   
	 f.setVisible(true);   
	}    
	public void iterate(){ 
		jb=new JProgressBar(0,2000);    
		jb.setBounds(40,40,160,30);         
		jb.setValue(0);    
		jb.setStringPainted(true);   
		f.add(jb); 
	while(i<=2000){    
	  jb.setValue(i);    
	  i=i+20;    
	  try{Thread.sleep(10);}catch(Exception e){}    
	} 
	
		
	} 
	public void display(){
		JLabel l1,l2;  
	    l1=new JLabel("sucessfully .");  
	    l1.setBounds(40,40, 160,30);  
	    l2=new JLabel("<html><font color=red size=4><b>RUNNED</b></html>");
	   l1.setFont(new java.awt.Font("Arial", Font.ITALIC, 16));
	   l1.setOpaque(true);
	   l1.setBackground(Color.WHITE);
	   l1.setForeground(Color.BLUE);
	    l2.setBounds(60,60, 170,40);  
	    f.add(l1); f.add(l2);
	    f.getContentPane().remove(jb);;
		f.getContentPane().repaint();
		
	}
	public static void main(String[] args) {    
		PrograssBarForLoop m=new PrograssBarForLoop();    
	    
	    m.iterate();  
	   
	   m.display();
	}    
}
