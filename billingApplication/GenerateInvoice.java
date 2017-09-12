package billingApplication;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class GenerateInvoice extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField productPrice;
	private JTextField productCount;
	private JComboBox<String> productItem ;
	private JLabel productLeft;
	static String proLeft=null; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateInvoice frame = new GenerateInvoice();
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
	Connection con = null;
	public void productDropDown(){
		
		try {
			String product = "select * from billing_software.product_details;";
			Statement statement=(Statement) con.createStatement();
			ResultSet set=statement.executeQuery(product);
			while(set.next()){
				productItem.addItem(set.getString("productName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public GenerateInvoice() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","root"); 
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HomePage().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(27, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("VN SuperMarket");
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(346, 0, 422, 70);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 183, 916, 368);
		contentPane.add(scrollPane);
		
		productItem = new JComboBox<String>();
		productItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String fetchRow = "Select * from billing_software.product_details where productName=?;";
					PreparedStatement statement = (PreparedStatement) con.prepareStatement(fetchRow);
					statement.setString(1, (String) productItem.getSelectedItem());
					ResultSet set=statement.executeQuery();
					while(set.next()){
						productPrice.setText(set.getString("productPrice"));
						productLeft.setText(set.getString("productCount"));
						proLeft=set.getString("productCount");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		productItem.setBounds(41, 124, 190, 23);
		contentPane.add(productItem);
		
		productLeft = new JLabel("");
		productLeft.setFont(new Font("Tahoma", Font.PLAIN, 13));
		productLeft.setBounds(261, 124, 53, 23);
		contentPane.add(productLeft);
		
		productPrice = new JTextField();
		productPrice.setBounds(365, 121, 206, 26);
		contentPane.add(productPrice);
		productPrice.setColumns(10);
		
		productCount = new JTextField();
		productCount.setColumns(10);
		productCount.setBounds(627, 121, 206, 26);
		contentPane.add(productCount);
		
		JButton bttSubmit = new JButton("Sumbit");
		bttSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(proLeft) >= Integer.valueOf(productCount.getText())){
					JOptionPane.showMessageDialog(null, "please wait Invoice will be generated");
				}
				else{
					JOptionPane.showMessageDialog(null, "Enter below or equal product count");
				}
				
			}
		});
		bttSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bttSubmit.setBounds(868, 120, 89, 27);
		contentPane.add(bttSubmit);
		
		JLabel lblSelectProduct = new JLabel("Select Product");
		lblSelectProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectProduct.setBounds(41, 89, 122, 19);
		contentPane.add(lblSelectProduct);
		
		JLabel lblUnitsLeft = new JLabel("Units Left");
		lblUnitsLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnitsLeft.setBounds(243, 89, 75, 19);
		contentPane.add(lblUnitsLeft);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(369, 91, 66, 19);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(622, 89, 104, 19);
		contentPane.add(lblQuantity);
		productDropDown();
	}
}
