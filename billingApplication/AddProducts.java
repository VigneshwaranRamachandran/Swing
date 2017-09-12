package billingApplication;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.Color;

public class AddProducts extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productName;
	private JTextField productPrice;
	private JTextField productCount;
	private JTextField productTax;
	private JTextField productDiscription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProducts frame = new AddProducts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con =null;
	public void createTable(){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			 con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","root"); 
			//here sonoo is database name, root is username and password 
			 DatabaseMetaData dbm=(DatabaseMetaData) con.getMetaData();
			 ResultSet set=dbm.getTables(null, null, "product_details", null);
			 if(set.next()){
				 //if table exist do nothing...else create a table...
				 //JOptionPane.showMessageDialog(null, "allready have a table");
			  }
			 else{
				 String createTable ="CREATE TABLE billing_software.product_details(productName VARCHAR(100) NOT NULL,"
				 		+ "productPrice Int(100) NOT NULL,"
				 		+ "productCount VARCHAR(100) NOT NULL,"
				 		+ "productTax varchar(100) Not Null,"
				 		+ "productDiscription varchar(100),"
				 		+ "PRIMARY KEY ( productName )  ); ";
				 PreparedStatement statement=(PreparedStatement) con.prepareStatement(createTable);
				 statement.executeUpdate(createTable);
			 }  
			 
			}catch(Exception e){ System.out.println(e);} 
	}
	public void customCursor(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("cursor.png");
		Point point = new Point(0,0);
		Cursor cursor = toolkit.createCustomCursor(img,point,"Cursor");
		setCursor(cursor);
		}
	public AddProducts() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddProduct.setBounds(65, 64, 138, 28);
		contentPane.add(lblAddProduct);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(140, 103, 495, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Product Name");
		label.setBounds(10, 21, 138, 14);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		productName = new JTextField();
		productName.setBounds(218, 11, 261, 38);
		panel.add(productName);
		productName.setToolTipText("Enter the Product Name");
		productName.setColumns(10);
		
		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setBounds(10, 85, 138, 14);
		panel.add(lblProductPrice);
		lblProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		productPrice = new JTextField();
		productPrice.setBounds(218, 75, 261, 38);
		panel.add(productPrice);
		productPrice.setToolTipText("Enter Product Price in Rupee");
		productPrice.setColumns(10);
		
		JLabel lblNoOfProduct = new JLabel("No. Of  Product");
		lblNoOfProduct.setBounds(10, 158, 138, 14);
		panel.add(lblNoOfProduct);
		lblNoOfProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		productCount = new JTextField();
		productCount.setBounds(218, 148, 261, 38);
		panel.add(productCount);
		productCount.setToolTipText("Enter Product count");
		productCount.setColumns(10);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(10, 233, 138, 14);
		panel.add(lblTax);
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		productTax = new JTextField();
		productTax.setBounds(218, 223, 261, 38);
		panel.add(productTax);
		productTax.setToolTipText("Tax per Product");
		productTax.setColumns(10);
		
		JLabel lblProductDiscription = new JLabel("Product Discription");
		lblProductDiscription.setBounds(10, 298, 138, 14);
		panel.add(lblProductDiscription);
		lblProductDiscription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		productDiscription = new JTextField();
		productDiscription.setBounds(218, 298, 261, 38);
		panel.add(productDiscription);
		productDiscription.setColumns(10);
		
		JButton prodcutSubmit = new JButton("Submit");
		prodcutSubmit.setBounds(376, 378, 89, 23);
		panel.add(prodcutSubmit);
		prodcutSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton productRest = new JButton("Reset");
		productRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productName.setText("");
				productPrice.setText("");
				productCount.setText("");
				productTax.setText("");
				productDiscription.setText("");
			}
		});
		productRest.setBounds(233, 378, 89, 23);
		panel.add(productRest);
		productRest.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HomePage().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(38, 483, 89, 23);
		contentPane.add(btnBack);
		
		JLabel label_1 = new JLabel("VN SuperMarket");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_1.setBounds(213, 0, 422, 70);
		contentPane.add(label_1);
		prodcutSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((productName.getText().equals(null)) || (productName.getText().equals("")) || (productName.getText().isEmpty()) || (productPrice.getText().equals(null)) || (productPrice.getText().equals("")) || (productPrice.getText().isEmpty()) || (productCount.getText().equals(null)) || (productCount.getText().equals("")) || (productCount.getText().isEmpty()) || (productTax.getText().equals(null)) || (productTax.getText().equals("")) || (productTax.getText().isEmpty())){
					JOptionPane.showMessageDialog(null, "please fill the fields");
				}
				else{
					try {
						String insertData = "INSERT INTO billing_software.product_details VALUES(?,?,?,?,?)";
						PreparedStatement statement=(PreparedStatement) con.prepareStatement(insertData);
						statement.setString(1,productName.getText());
						statement.setString(2,productPrice.getText());
						statement.setString(3,productCount.getText());
						statement.setString(4,productTax.getText());
						statement.setString(5,productDiscription.getText());
						int returnData=statement.executeUpdate();
						//if sucessfully inserted means it will returns 1 else 0...
						if(returnData>0){
							JOptionPane.showMessageDialog(null, "Sucessfully Inserted");
							productName.setText("");
							productPrice.setText("");
							productCount.setText("");
							productTax.setText("");
							productDiscription.setText("");
						}
						else{
							JOptionPane.showMessageDialog(null, "Unable to Insert");
							productName.setText("");
							productPrice.setText("");
							productCount.setText("");
							productTax.setText("");
							productDiscription.setText("");
							
						}
					}catch (MySQLIntegrityConstraintViolationException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Unable to Insert");
						String s ="Already "+productName.getText()+" have an account";
						JOptionPane.showMessageDialog(null,s);
						productName.setText("");
						productPrice.setText("");
						productCount.setText("");
						productTax.setText("");
						productDiscription.setText("");
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Unable to Insert");
						productName.setText("");
						productPrice.setText("");
						productCount.setText("");
						productTax.setText("");
						productDiscription.setText("");
						e.printStackTrace();
					}
				
				}
			}
		});
		createTable();
		
	}
	
}
