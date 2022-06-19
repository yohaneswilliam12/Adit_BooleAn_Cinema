import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.lang.NullPointerException;
public class Register implements ActionListener {
	private JFrame frame;
	private JLabel name, gender, male, female, pass, rePass;
	private JTextField nameField, passField, rePassField;
	private JButton signup, reset;
	private JRadioButton maleBtn, femaleBtn;
	private ButtonGroup genderBtn;
	
	public Register() {
		System.setProperty("Brown", "#3b1d13");
		System.setProperty("Orange", "#ba5f41");
		
		JFrame frame = new JFrame();
		frame.setSize(800, 500);
		frame.setTitle("BooleAn Cinema");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JPanel header = new JPanel();
		//header.setBounds(0, 0, 800, 50);
		header.setBackground(Color.getColor("Orange"));
		header.setLayout(new BorderLayout());
		frame.add(header, BorderLayout.NORTH);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setBackground(Color.getColor("Orange"));
		header.add(titlePanel, BorderLayout.WEST);
		
		JLabel LogoIcon = new JLabel(getIcon("src/Assets/image/logo.png"));
		titlePanel.add(LogoIcon);
		JLabel title = new JLabel("BOOLEAN CINEMA", JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Verdana", Font.PLAIN, 20));
		titlePanel.add(title);
		
		JPanel content = new JPanel();
		//content.setLayout(new GridLayout(2, 2));
		//content.setBounds(0, 50, 800, 400);
		content.setLayout(new BorderLayout());
		content.setBorder(new EmptyBorder(20, 200, 100,200));
		content.setBackground(Color.getColor("Brown"));
		frame.add(content, BorderLayout.CENTER);
		
		JLabel regis = new JLabel("REGISTER PAGE", JLabel.CENTER);
		regis.setForeground(Color.WHITE);
		regis.setFont(new Font("Verdana", Font.PLAIN, 20));
		content.add(regis, BorderLayout.NORTH);
		
		//REGISTER PANEL
		JPanel regisPanel = new JPanel();
		regisPanel.setSize(400, 400);
		regisPanel.setLayout(new GridLayout(4,2,10,10));
		regisPanel.setBackground(Color.getColor("Brown"));
		content.add(regisPanel);
		
		JLabel name = new JLabel("Full Name");
		name.setForeground(Color.WHITE);
		regisPanel.add(name);
		JTextField nameField = new JTextField(20);
		regisPanel.add(nameField);
		
		JLabel gender = new JLabel("Gender");
		gender.setForeground(Color.WHITE);
		regisPanel.add(gender);
		
		JRadioButton maleBtn = new JRadioButton();
		maleBtn.setBackground(Color.getColor("Brown"));
		JLabel male = new JLabel("Male");
		male.setForeground(Color.WHITE);
		
		JRadioButton femaleBtn = new JRadioButton();
		femaleBtn.setBackground(Color.getColor("Brown"));
		JLabel female = new JLabel("Female");
		female.setForeground(Color.WHITE);
		
		ButtonGroup genderBtn = new ButtonGroup();
		genderBtn.add(maleBtn);
		genderBtn.add(femaleBtn);
		
		JPanel radio = new JPanel();
		radio.setBackground(Color.getColor("Brown"));
		radio.setLayout(new FlowLayout());
		radio.add(maleBtn);
		radio.add(male);
		radio.add(femaleBtn);
		radio.add(female);
		regisPanel.add(radio);
		
		JLabel pass = new JLabel("Password");
		pass.setForeground(Color.WHITE);
		regisPanel.add(pass);
		
		JPasswordField passField = new JPasswordField(20);
		passField.setSize(100, 50);
		regisPanel.add(passField);
		
		JLabel rePass = new JLabel("Re-Password");
		rePass.setForeground(Color.WHITE);
		regisPanel.add(rePass);
		
		JPasswordField rePassField = new JPasswordField(20);
		rePassField.setSize(100, 50);
		regisPanel.add(rePassField);
		
		//BUTTON PANEL
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.setBackground(Color.getColor("Brown"));
		content.add(btnPanel, BorderLayout.SOUTH);
		
		JButton signup = new JButton("Sign Up");
		btnPanel.add(signup);
		signup.addActionListener(this);
		
		JButton reset = new JButton("Reset");
		btnPanel.add(reset);
		
		//FOOTER
		JPanel footer = new JPanel();
		//footer.setBounds(0, 450, 800, 50);
		footer.setBackground(Color.getColor("Orange"));
		footer.setLayout(new BorderLayout());
		frame.add(footer, BorderLayout.SOUTH);
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout());
		backPanel.setBackground(Color.getColor("Orange"));
		footer.add(backPanel, BorderLayout.WEST);
		
		JLabel backIcon = new JLabel(getIcon("src/Assets/image/back.png"));
		backPanel.add(backIcon);
		JLabel back = new JLabel("Back");
		backPanel.add(back);
		
		backIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new Login();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	private ImageIcon getIcon(String URL) {
			
			ImageIcon io = new ImageIcon(URL);
			Image img = io.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			return new ImageIcon(img);
			
		}
	
	private void reset() {
		nameField.setText("");
		genderBtn.clearSelection();
		passField.setText("");
		rePassField.setText("");

	}
	public static void main(String[] args) {
		new Register();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(signup)) {
			boolean valid = true;
			if(nameField.getText().equals("")) {
			JOptionPane.showMessageDialog(frame, "Username must be filled", "Error", JOptionPane.ERROR_MESSAGE);
			valid = false;
			}
			if(!(nameField.getText().length()>5)) {
				JOptionPane.showMessageDialog(frame, "Username at least 5 characters", "Error", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
			if(!maleBtn.isSelected() && !femaleBtn.isSelected()) {
				JOptionPane.showMessageDialog(frame, "Must choose the gender", "Error", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
			if(passField.getText().equals("")) {
				JOptionPane.showMessageDialog(frame, "Password must be filled", "Error", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
			if(!(passField.getText().length()>8)) {
				JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
			if(!passField.getText().contains("(?=.*[A-Z])(?=.*[0-9])")) {
				JOptionPane.showMessageDialog(frame, "Password must contain 1 Uppercase and 1 Symbol/Number", "Error", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
			if(!rePassField.getText().equals(passField.getText())) {
				JOptionPane.showMessageDialog(frame, "Re-Password must be same as Password", "Error", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		}
		if(e.getSource() == reset) {
			reset();
		}
		
	}

}
