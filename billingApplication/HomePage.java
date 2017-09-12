package billingApplication;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(new Color(245, 245, 245));
		optionPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		optionPanel.setBounds(131, 137, 745, 272);
		contentPane.add(optionPanel);
		optionPanel.setLayout(null);
		
		JButton addProduct = new JButton("Add Product");
		addProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			new AddProducts().setVisible(true);
			
			}
		});
		addProduct.setBounds(85, 77, 128, 35);
		optionPanel.add(addProduct);
		
		JButton generateInvoice = new JButton("Generate Invoice");
		generateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new GenerateInvoice().setVisible(true);
			}
		});
		generateInvoice.setBounds(320, 77, 128, 35);
		optionPanel.add(generateInvoice);
		
		JButton cusPayments = new JButton("Payments");
		cusPayments.setBounds(553, 77, 128, 35);
		optionPanel.add(cusPayments);
		
		JButton cusReport = new JButton("Report");
		cusReport.setBounds(199, 165, 128, 35);
		optionPanel.add(cusReport);
		
		JButton cusHistory = new JButton("History");
		cusHistory.setBounds(446, 165, 128, 35);
		optionPanel.add(cusHistory);
		
		JLabel label = new JLabel("VN SuperMarket");
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(341, 11, 422, 70);
		contentPane.add(label);
	}
}
