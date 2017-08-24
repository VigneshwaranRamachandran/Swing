package dbConnection;

import java.awt.EventQueue;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import java.awt.event.ActionListener;
import java.security.Provider;
import java.security.Security;
import java.awt.event.ActionEvent;

public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField original_value;
	private JTextField encryted_value;
	private JTextField decrypted_value;
	byte[] input;
	byte[] keyBytes = "95".getBytes();
	byte[] ivBytes = "2795".getBytes();
	SecretKeySpec key = new SecretKeySpec(keyBytes,"DES");
	
	IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
	Cipher cipher;
	byte[] cipherText;
	int ctLenght;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOriginalContent = new JLabel("Original Content:");
		lblOriginalContent.setBounds(78, 82, 101, 14);
		contentPane.add(lblOriginalContent);

		JLabel lblNewLabel = new JLabel("Encrypted _Value :");
		lblNewLabel.setBounds(78, 107, 113, 14);
		contentPane.add(lblNewLabel);

		JLabel lblDecryptedvalue = new JLabel("Decrypted _Value:");
		lblDecryptedvalue.setBounds(78, 132, 101, 27);
		contentPane.add(lblDecryptedvalue);

		original_value = new JTextField();
		original_value.setBounds(201, 79, 112, 20);
		contentPane.add(original_value);
		original_value.setColumns(10);

		encryted_value = new JTextField();
		encryted_value.setBounds(201, 104, 112, 20);
		contentPane.add(encryted_value);
		encryted_value.setColumns(10);

		decrypted_value = new JTextField();
		decrypted_value.setBounds(201, 135, 112, 20);
		contentPane.add(decrypted_value);
		decrypted_value.setColumns(10);

		JButton encrypt = new JButton("Encrypt");
		encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Security.addProvider(new BouncyCastleProvider());
					input = original_value.getText().getBytes();
//				Provider p = Security.getProvider("BC");
//					Provider[] providers = Security.getProviders();
//				      for (int i=0; i < providers.length; i++) {
//				          System.out.println(providers[i].toString());
//				      }
					SecretKeySpec key = new SecretKeySpec(keyBytes,"DES");
					IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
					cipher = Cipher.getInstance("DES/CBC/NoPadding","BC");
					//cipher=Cipher.
					System.out.println(input);
					cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
					cipherText = new byte[cipher.getOutputSize(input.length)];
					ctLenght = cipher.update(input, 0, input.length, cipherText, 0);
					ctLenght += cipher.doFinal(cipherText, ctLenght);
					encryted_value.setText(new String(cipherText));
					System.out.println("cipher:" + new String(cipherText));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		encrypt.setBounds(182, 182, 89, 23);
		contentPane.add(encrypt);

		JButton decrypt = new JButton("Decrypt");
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					cipher.init(Cipher.DECRYPT_MODE,key,ivSpec);
					byte[] plainText = new byte[cipher.getOutputSize(ctLenght)];
					int ptLenght = cipher.update(cipherText,0,ctLenght,plainText,0);
					ptLenght += cipher.doFinal(plainText, ptLenght);
					System.out.println("plain: "+ new String(plainText));
					decrypted_value.setText(new String(plainText));
					}catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
					}
			}
		});
		decrypt.setBounds(277, 182, 89, 23);
		contentPane.add(decrypt);
	}
}
