package billingApplication;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class BillingApplication {

	private JFrame frame;
	private JTextField userName;
	private JTextField newName;
	private JTextField newUserName;
	private JTextField newUserAge;
	private JTextField newUserDOB;
	private JTextField newUserMobile;
	private JTextField newUserMail;
	private JPanel createUserPanel;
	private JPasswordField newUserPassword;
	private JPasswordField newUserRePassword;
	private JPasswordField userPassword;
	private JPasswordField adminPassword;
	private JLabel welocmeLabel;
	static String administrationPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillingApplication window = new BillingApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillingApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection con=null;
	public void createNewTable(){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","root"); 
			//here sonoo is database name, root is username and password 
			 DatabaseMetaData dbm=(DatabaseMetaData) con.getMetaData();
			 ResultSet set=dbm.getTables(null, null, "user_details", null);
			 if(set.next()){
				 //if table exist do nothing...else create a table...
				 
				 //get an admin password...
				 String query = "SELECT * FROM billing_software.user_details WHERE cus_mobile=9788835216";

			      // create the java statement
			      Statement st = con.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs = st.executeQuery(query);
			     
			      if (rs.next())
			       {
			    	  administrationPassword =  rs.getString("cus_password");
			        }

			   //   JOptionPane.showMessageDialog(null, administrationPassword.toString() ,"Alert",JOptionPane.ERROR_MESSAGE);
			      
			 }
			 else{
				 String createTable ="CREATE TABLE billing_software.user_details(cus_mobile BIGINT NOT NULL,"
				 		+ "cus_name VARCHAR(100) NOT NULL,"
				 		+ "cus_userName VARCHAR(100) NOT NULL,"
				 		+ "cus_age varchar(100) Not Null,"
				 		+ "cus_password varchar(100) not null,"
				 		+ "cus_dateOfBirth varchar(100),"
				 		+ "cus_emailId varchar(100) not null,"
				 		+ "PRIMARY KEY ( cus_mobile )  ); ";
				 PreparedStatement statement=(PreparedStatement) con.prepareStatement(createTable);
				 statement.executeUpdate(createTable);
			 }  
			 
			}catch(Exception e){ System.out.println(e);} 
	}
	 
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.setBackground(new Color(0, 204, 204));
		frame.setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VN SuperMarket");
		lblNewLabel.setBounds(351, 26, 422, 70);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel newUserPannel = new JPanel();
		newUserPannel.setBackground(new Color(245, 245, 245));
		newUserPannel.setBorder(new LineBorder(new Color(0, 0, 0)));
		newUserPannel.setBounds(86, 160, 264, 141);
		frame.getContentPane().add(newUserPannel);
		newUserPannel.setLayout(null);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setBounds(68, 11, 137, 30);
		newUserPannel.add(lblNewUser);
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(10, 44, 247, 86);
		newUserPannel.add(btnCreateAccount);
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newUserMobile.setText("");
				newName.setText("");
				newUserName.setText("");
				newUserAge.setText("");
				newUserPassword.setText("");
				newUserDOB.setText("");
				newUserMail.setText("");
				newUserRePassword.setText("");
				adminPassword.setText("");
				createUserPanel.setVisible(true);
				welocmeLabel.setVisible(false);
			}
		});
		btnCreateAccount.setToolTipText("Create New Account");
		
		JPanel userLoginPanel = new JPanel();
		userLoginPanel.setBackground(new Color(245, 245, 245));
		userLoginPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		userLoginPanel.setBounds(583, 128, 328, 198);
		frame.getContentPane().add(userLoginPanel);
		userLoginPanel.setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(135, 60, 184, 20);
		userLoginPanel.add(userName);
		userName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userName.setToolTipText("Enter username");
		userName.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(10, 61, 115, 14);
		userLoginPanel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setToolTipText("");
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 127, 98, 14);
		userLoginPanel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		userPassword = new JPasswordField();
		userPassword.setBounds(135, 123, 184, 23);
		userLoginPanel.add(userPassword);
		userPassword.setToolTipText("Enter Your Password");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(230, 164, 89, 23);
		userLoginPanel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if((userName.getText().isEmpty()) || (userPassword.getText().isEmpty()) || (userName.getText().equals("")) || (userPassword.getText().equals("")))
				{
					//if the field is empty..
					JOptionPane.showMessageDialog(null, "please fill the fields");
				}
				else{
					try {
						String login="SELECT * FROM billing_software.user_details where cus_userName=? and cus_Password=?";
						PreparedStatement statement=(PreparedStatement) con.prepareStatement(login);
						statement.setString(1, userName.getText());
						statement.setString(2, userPassword.getText());
						ResultSet set=statement.executeQuery();
						if(set.next()){
							//JOptionPane.showMessageDialog(null, "Login Sucessfull");
							
							new HomePage().setVisible(true);
							userName.setText("");
							userPassword.setText("");
						}
						else{
							JOptionPane.showMessageDialog(null, "Invalid User Details");
							userName.setText("");
							userPassword.setText("");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		btnLogin.setToolTipText("Login");
		
		JLabel lblAlreadyUser = new JLabel("Already User");
		lblAlreadyUser.setBounds(87, 11, 150, 30);
		userLoginPanel.add(lblAlreadyUser);
		lblAlreadyUser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		createUserPanel = new JPanel();
		createUserPanel.setBackground(new Color(245, 245, 245));
		createUserPanel.setBounds(146, 340, 555, 188);
		createUserPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		createUserPanel.setVisible(false);
		frame.getContentPane().add(createUserPanel);
		createUserPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 46, 14);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(lblName);
		
		newName = new JTextField();
		newName.setBounds(83, 10, 149, 20);
		newName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newName.setToolTipText("Enter Your Name");
		createUserPanel.add(newName);
		newName.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("UserName");
		lblUsername_1.setBounds(287, 13, 78, 14);
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(lblUsername_1);
		
		newUserName = new JTextField();
		newUserName.setBounds(391, 10, 140, 20);
		newUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newUserName.setToolTipText("Enter User Name");
		createUserPanel.add(newUserName);
		newUserName.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(287, 46, 78, 14);
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(lblPassword_1);
		
		JLabel lblConformpassword = new JLabel("RePassword");
		lblConformpassword.setBounds(287, 81, 78, 14);
		lblConformpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(lblConformpassword);
		
		JLabel lblAdminpassword = new JLabel("AdminPassword");
		lblAdminpassword.setBounds(287, 121, 91, 14);
		lblAdminpassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		createUserPanel.add(lblAdminpassword);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(466, 159, 79, 23);
		btnCreate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if((newUserMobile.getText().isEmpty()) || (newName.getText().isEmpty()) ||(newUserName.getText().isEmpty()) || (newUserAge.getText().isEmpty()) || (newUserPassword.getText().isEmpty()) || (newUserDOB.getText().isEmpty()) || (newUserMail.getText().isEmpty()) || (newUserRePassword.getText().isEmpty()) || (adminPassword.getText().isEmpty()) || (newUserMobile.getText().equals(null)) || (newName.getText().equals(null)) ||(newUserName.getText().equals(null)) || (newUserAge.getText().equals(null)) || (newUserPassword.getText().equals(null)) || (newUserDOB.getText().equals(null)) || (newUserMail.getText().equals(null)) || (newUserRePassword.getText().equals(null)) || (adminPassword.getText().equals(null)))
				{
					//if the field is empty
					JOptionPane.showMessageDialog(null, "please fill the fields");
				}
				else{
					if(adminPassword.getText().equals(administrationPassword)){
				try {
					String insertData = "INSERT INTO billing_software.user_details VALUES(?,?,?,?,?,?,?)";
					PreparedStatement statement=(PreparedStatement) con.prepareStatement(insertData);
					statement.setString(1,newUserMobile.getText());
					statement.setString(2,newName.getText());
					statement.setString(3,newUserName.getText());
					statement.setString(4,newUserAge.getText());
					statement.setString(5,newUserPassword.getText());
					statement.setString(6,newUserDOB.getText());
					statement.setString(7,newUserMail.getText());
					int returnData=statement.executeUpdate();
					//if sucessfully inserted means it will returns 1 else 0...
					if(returnData>0){
						JOptionPane.showMessageDialog(null, "Sucessfully Inserted");
						createUserPanel.setVisible(false);
						welocmeLabel.setVisible(true);
						//con.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "Unable to Insert");
						newUserMobile.setText("");
						newName.setText("");
						newUserName.setText("");
						newUserAge.setText("");
						newUserPassword.setText("");
						newUserDOB.setText("");
						newUserMail.setText("");
						createUserPanel.setVisible(true);
					}
				}catch (MySQLIntegrityConstraintViolationException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Unable to Insert");
					String s ="Already "+newUserMobile.getText()+" have an account";
					JOptionPane.showMessageDialog(null,s);
					newUserMobile.setText("");
					newName.setText("");
					newUserName.setText("");
					newUserAge.setText("");
					newUserPassword.setText("");
					newUserDOB.setText("");
					newUserMail.setText("");
					newUserRePassword.setText("");
					adminPassword.setText("");
					createUserPanel.setVisible(true);
					
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Unable to Insert");
					newUserMobile.setText("");
					newName.setText("");
					newUserName.setText("");
					newUserAge.setText("");
					newUserPassword.setText("");
					newUserDOB.setText("");
					newUserMail.setText("");
					newUserRePassword.setText("");
					adminPassword.setText("");
					createUserPanel.setVisible(true);
					e.printStackTrace();
				}
			}
					else{
						JOptionPane.showMessageDialog(null, "Admin Password is Wrong","Alert",JOptionPane.ERROR_MESSAGE);
						adminPassword.setText("");
					}
				}
			}
		});
		btnCreate.setToolTipText("Create Your Account");
		createUserPanel.add(btnCreate);
		
		JButton bttCancel = new JButton("Cancel");
		bttCancel.setBounds(378, 159, 78, 23);
		bttCancel.setToolTipText("");
		bttCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bttCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUserPanel.setVisible(false);
				welocmeLabel.setVisible(true);
			}
		});
		createUserPanel.add(bttCancel);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 43, 46, 20);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(lblAge);
		
		newUserAge = new JTextField();
		newUserAge.setBounds(83, 41, 149, 20);
		newUserAge.setToolTipText("Enter Your Age");
		newUserAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(newUserAge);
		newUserAge.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Date Of Birth");
		lblPhoneNumber.setBounds(10, 83, 70, 14);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		createUserPanel.add(lblPhoneNumber);
		
		newUserDOB = new JTextField();
		newUserDOB.setBounds(83, 80, 149, 20);
		newUserDOB.setToolTipText("Enter Your Date Of Birth");
		newUserDOB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(newUserDOB);
		newUserDOB.setColumns(10);
		
		JLabel lblE = new JLabel("Mobile");
		lblE.setBounds(10, 122, 52, 14);
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(lblE);
		
		newUserMobile = new JTextField();
		newUserMobile.setBounds(83, 119, 149, 20);
		newUserMobile.setToolTipText("Enter Your Mobile Number");
		newUserMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(newUserMobile);
		newUserMobile.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 159, 46, 14);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(lblEmail);
		
		newUserMail = new JTextField();
		newUserMail.setBounds(83, 160, 149, 20);
		newUserMail.setToolTipText("Enter Your Email Id");
		createUserPanel.add(newUserMail);
		newUserMail.setColumns(10);
		
		newUserPassword = new JPasswordField();
		newUserPassword.setBounds(391, 41, 140, 20);
		newUserPassword.setToolTipText("Enter Your Password");
		newUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(newUserPassword);
		
		newUserRePassword = new JPasswordField();
		newUserRePassword.setBounds(391, 80, 140, 20);
		newUserRePassword.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent arg0) {
				if(newUserRePassword.getText().equals(newUserPassword.getText())){
					//nothing to do
				}
				else{
					JOptionPane.showMessageDialog(null, "Password was not match ","Alert",JOptionPane.ERROR_MESSAGE);
					newUserRePassword.setText("");
					newUserPassword.setText("");
				}
			}
		});
		newUserRePassword.setToolTipText("ReEnter Your Password");
		newUserRePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newUserRePassword.setText("");
		createUserPanel.add(newUserRePassword);
		
		adminPassword = new JPasswordField();
		adminPassword.setBounds(391, 119, 140, 23);
		adminPassword.setToolTipText("Admin Password");
		adminPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createUserPanel.add(adminPassword);
		
	    welocmeLabel = new JLabel(" WELCOME TO VN SUPER MARKET ");
	    welocmeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	    welocmeLabel.setBounds(351, 532, 255, 19);
	    frame.getContentPane().add(welocmeLabel);
	    welocmeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		createNewTable();
		
	}
}
