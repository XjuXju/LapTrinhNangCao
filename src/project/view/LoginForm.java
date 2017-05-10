package project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm implements ILoginForm {

	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtPassword;
	JButton btnLogin ;
	JButton btnCancel;

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblngNhpH = new JLabel("Đăng nhập hệ thống");
		lblngNhpH.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblngNhpH.setBounds(122, 11, 206, 36);
		panel.add(lblngNhpH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 80, 414, 106);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 21, 114, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setBounds(44, 58, 114, 24);
		panel_1.add(lblMtKhu);
		
		txtUserName = new JTextField("admin");
		txtUserName.setBounds(178, 21, 192, 24);
		panel_1.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField("admin");
		txtPassword.setColumns(10);
		txtPassword.setBounds(178, 60, 192, 24);
		panel_1.add(txtPassword);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 192, 414, 58);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setBounds(237, 11, 118, 30);
		panel_2.add(btnCancel);
		
		btnLogin = new JButton("Đăng nhập");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(74, 11, 118, 30);
		panel_2.add(btnLogin);
	}

	@Override
	public void setActionListenerForLoginButtonInLoginForm(ActionListener listener) {
		btnLogin.addActionListener(listener);
	}

	@Override
	public void setActionListenerForCancelButtonInLoginForm(ActionListener listener) {
		btnCancel.addActionListener(listener);
		
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return txtUserName.getText().toString().trim();
	}

	@Override
	public String getPassWord() {
		// TODO Auto-generated method stub
		return txtPassword.getText().toString().trim();
	}

	@Override
	public void closeForm() {
		frame.dispose();
		
	}
}
