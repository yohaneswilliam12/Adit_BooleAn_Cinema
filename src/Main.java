import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


public class Main {
	public EmbeddedMediaPlayer music;
	public Main() {
		//color
		System.setProperty("Brown", "#3b1d13");
		System.setProperty("Orange", "#ba5f41");
		
		JFrame frame = new JFrame();
		frame.setSize(800, 500);
		frame.setTitle("BooleAn Cinema");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		
		music = new MediaPlayerFactory().newEmbeddedMediaPlayer();
		 try {
			 music.prepareMedia(new File(getClass().getResource("src/Assets/music/cigarettes of ours.mp3").toURI()).getAbsolutePath());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}music.play();
		
	}

	private ImageIcon getIcon(String URL) {
		
		ImageIcon io = new ImageIcon(URL);
		Image img = io.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
		
	}

	public static void main(String[] args) {
		NativeLibrary.addSearchPath("libvlc", "C:\\Program Files (x86)\\VideoLAN\\VLC");
		Native.loadLibrary(LibVlc.class);
		new Main();
		
	}

}
