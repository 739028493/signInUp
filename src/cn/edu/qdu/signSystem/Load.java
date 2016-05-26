package cn.edu.qdu.signSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Load extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2607723839373703211L;
	SignIn sign = new SignIn();
	private JPanel contentPane;
	private JTextField userName;
	private JTextField passWord;
	private String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Load frame = new Load();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("static-access")
	public void denglu() {
		String n = userName.getText();
		String p = passWord.getText();
		for (int i = 0; i < sign.sizes(); i++) {

			if (n.equals(sign.getUserInformation().get(i).getUserName())
					&& p.equals(sign.getUserInformation().get(i).getPassWord())) {
				email = "ÓÊÏäÊÇ£º" + sign.getUserInformation().get(i).getEmail();
				JOptionPane.showMessageDialog(null, email);
				i=sign.sizes();
			}else if (i==sign.sizes()-1) {
				email = "ÃÜÂë»òÕËºÅ´íÎó";
				JOptionPane.showMessageDialog(null, email);
			}
			
		}
	}

	/**
	 * Create the frame.
	 */
	public Load() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		userName = new JTextField();
		userName.setColumns(10);

		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");

		passWord = new JTextField();
		passWord.setColumns(10);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");

		JButton button = new JButton("\u767B\u5F55");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				denglu();
			}
		});

		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {

				sign.main();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(70, Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(label)
														.addComponent(label_1))
										.addGap(6)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								userName,
																								GroupLayout.DEFAULT_SIZE,
																								214,
																								Short.MAX_VALUE)
																						.addComponent(
																								passWord,
																								GroupLayout.DEFAULT_SIZE,
																								214,
																								Short.MAX_VALUE))
																		.addContainerGap(
																				72,
																				Short.MAX_VALUE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				button)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				53,
																				Short.MAX_VALUE)
																		.addComponent(
																				button_1)
																		.addGap(107)))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(74)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																userName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label))
										.addGap(26)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																passWord,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_1))
										.addPreferredGap(
												ComponentPlacement.RELATED, 98,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(button_1)
														.addComponent(button))
										.addGap(91)));
		contentPane.setLayout(gl_contentPane);
	}
}
