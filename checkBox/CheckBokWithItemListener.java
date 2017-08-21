package checkBox;
import javax.swing.*;  
import java.awt.event.*;    
public class CheckBokWithItemListener implements ActionListener {
	JCheckBox checkbox1;
    JCheckBox checkbox2;
    final JLabel label;
	CheckBokWithItemListener(){    
	        JFrame f= new JFrame("CheckBox Example");    
	       label = new JLabel();            
	        label.setHorizontalAlignment(JLabel.CENTER);    
	        label.setSize(400,100);    
	     checkbox1 = new JCheckBox("C++");    
	        checkbox1.setBounds(150,100, 50,50);    
	     checkbox2 = new JCheckBox("Java");    
	        checkbox2.setBounds(150,150, 50,50);   
	        JButton b = new JButton("click");
	        b.setBounds(10,100,100, 40); 
	        f.add(checkbox1); f.add(checkbox2); f.add(label);  
	        
	        checkbox1.addItemListener(new ItemListener() {    
	             public void itemStateChanged(ItemEvent e) {                 
	                label.setText("C++ Checkbox: "     
	                + (e.getStateChange()==1?"checked":"unchecked"));    
	             }    
	          });    
	        checkbox2.addItemListener(new ItemListener() {    
	             public void itemStateChanged(ItemEvent e) {                 
	                label.setText("Java Checkbox: "     
	                + (e.getStateChange()==1?"checked":"unchecked"));    
	             }    
	          });  
	        
	        b.addActionListener(this);
	        f.add(b);
	    	
	        f.setSize(400,400);    
	        f.setLayout(null);    
	        f.setVisible(true);    
	     }    
	public void actionPerformed(ActionEvent e) {
		checkbox1.getAccessibleContext();
		label.setText(""+checkbox1.isSelected());
	}  
	public static void main(String args[])    
	{    
	    new CheckBokWithItemListener();    
	}
	  
}
