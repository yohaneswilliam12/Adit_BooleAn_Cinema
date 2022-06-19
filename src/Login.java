import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Login extends JFrame implements ActionListener{
	private JFrame frame;
	private JTextField emailField, passField;
	//private JPasswordField ;
	private JButton login, reset;
	public EmbeddedMediaPlayer music;
	
	public Login(){
		//color
		System.setProperty("Brown", "#3b1d13");
		System.setProperty("Orange", "#ba5f41");
		
		music();
				
		JFrame frame = new JFrame();
		frame.setSize(800, 500);
		frame.setTitle("BooleAn Cinema");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		//frame.setResizable(false);
		frame.setVisible(true);
		
		
		JPanel header = new JPanel();
		//header.setBounds(0, 0, 800, 50);
		//header.setPreferredSize(new Dimension(800, 50));
		header.setBackground(Color.getColor("Orange"));
		header.setLayout(new BorderLayout());
		frame.add(header, BorderLayout.NORTH);
		
		JLabel closeIcon = new JLabel(getIcon("src/Assets/image/close.png"));
		header.add(closeIcon, BorderLayout.EAST);
		closeIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("close");
				System.exit(0);
				
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
		
		JPanel content = new JPanel();
		//content.setLayout(new GridLayout(2, 2));
		//content.setBounds(0, 50, 800, 400);
		content.setLayout(new BorderLayout());
		content.setBorder(new EmptyBorder(20, 200, 200,200));
		content.setBackground(Color.getColor("Brown"));
		frame.add(content, BorderLayout.CENTER);
		
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(Color.getColor("Brown"));
		content.add(titlePanel, BorderLayout.NORTH);
		
		JLabel LogoIcon = new JLabel(getIcon("src/Assets/image/logo.png"));
		titlePanel.add(LogoIcon, BorderLayout.NORTH);
		JLabel title = new JLabel("BOOLEAN CINEMA", JLabel.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Verdana", Font.PLAIN, 20));
		titlePanel.add(title, BorderLayout.SOUTH);
		
		//LOGIN PANEL
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new GridLayout(2,2, 10, 15));
		loginPanel.setBounds(0, 100, 400, 200);
		loginPanel.setBackground(Color.getColor("Brown"));
		content.add(loginPanel, BorderLayout.CENTER);
		
		JLabel email = new JLabel("Email :");
		email.setForeground(Color.WHITE);
		//email.setBounds(10, 20, 80, 25);
		loginPanel.add(email);
		
		JTextField emailField = new JTextField(20);
		//emailField.setBounds(100, 20, 165, 25);
		emailField.setSize(100, 50);
		loginPanel.add(emailField);
		
		JLabel pass = new JLabel("Password :");
		pass.setForeground(Color.WHITE);
		//pass.setBounds(10, 50, 80, 25);
		loginPanel.add(pass);
		
		JPasswordField passField = new JPasswordField(20);
		//passField.setBounds(10, 50, 165, 25);
		passField.setSize(100, 50);
		loginPanel.add(passField);
		
		//BUTTON PANEL
		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(Color.getColor("Brown"));
		content.add(btnPanel, BorderLayout.SOUTH);
		
		JButton login = new JButton("Login");
		//login.setBounds(100, 110, 50, 25);
		login.addActionListener(this);
		btnPanel.add(login);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(this);
		btnPanel.add(reset);
		
		//FOOTER
		JPanel footer = new JPanel();
		//footer.setBounds(0, 450, 800, 50);
		footer.setBackground(Color.getColor("Orange"));
		footer.setLayout(new BorderLayout());
		frame.add(footer, BorderLayout.SOUTH);
		
		//SOUND PANEL
		JPanel soundPanel = new JPanel();
		soundPanel.setLayout(new FlowLayout());
		soundPanel.setBackground(Color.getColor("Orange"));
		footer.add(soundPanel, BorderLayout.WEST);
		
		JLabel soundIcon = new JLabel(getIcon("src/Assets/image/voice.png"));
		soundPanel.add(soundIcon);
		JLabel sound = new JLabel("cigarettes of ours.mp3");
		soundPanel.add(sound);
		
		
		final int[] change = {1};
		soundIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				music.pause();
				if(change[0]==1) {
					change[0]=0;
					soundIcon.setIcon(getIcon("src/Assets/image/mute.png"));
					sound.setText("Muted...");
				}else {
					change[0]=1;
					soundIcon.setIcon(getIcon("src/Assets/image/voice.png"));
					sound.setText("cigarettes of ours.mp3");
				}
				
				
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
		
		//SIGN UP PANEL
		JPanel signPanel = new JPanel();
		signPanel.setLayout(new FlowLayout());
		signPanel.setBackground(Color.getColor("Orange"));
		footer.add(signPanel, BorderLayout.EAST);
		JLabel signIcon = new JLabel(getIcon("src/Assets/image/signup.png"));
		signPanel.add(signIcon);
		JLabel signUp = new JLabel("Sign Up");
		signPanel.add(signUp);
		
		signIcon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new Register();
				music.stop();
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
		Image img = io.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
		
	}
	private void validation() {
		boolean valid = true;
		if(emailField.getText().equals("")) {
			JOptionPane.showMessageDialog(frame, "Email must be filled", "Error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}if(passField.getText().equals("")) {
			JOptionPane.showMessageDialog(frame, "Password must be filled", "Error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		
		
	}
	void music() {
		NativeLibrary.addSearchPath("libvlc", "C:\\Program Files\\VideoLAN\\VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
		music = new MediaPlayerFactory().newEmbeddedMediaPlayer();
		 try {
			 music.prepareMedia(new File(getClass().getResource("Assets/music/cigarettes of ours.mp3").toURI()).getAbsolutePath());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}music.play();
	}
	
	public void reset() {
		emailField.setText("");
		passField.setText("");
	}

	public static void main(String[] args) {
		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String Email = emailField.getText();
		//String Password = new String(passField.getPassword());
		
		if(e.getSource() == login) {
			validation();
			System.out.println("Valid");
		}
		if(e.getSource() == reset) {
			reset();
			System.out.println("reset");
		}
		
	}

}
