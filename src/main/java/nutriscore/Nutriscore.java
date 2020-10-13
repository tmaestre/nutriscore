package nutriscore;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

import nutriscore.listener.TimerActionListener;

/**
 * Application main class.
 */
public class Nutriscore {

	//The timer delay in milliseconds
	private static final int TIMER_DELAY_MILLISECONDS = 10000;

	//Main frame unique instance
	private static Nutriscore INSTANCE = null;
	
	//Application slider
	private JSlider slider;

	//Private constructor to prevent class instanciation
	private Nutriscore() {}
	//Get unique instance of main frame
	public static Nutriscore getInstance(){           
        if (INSTANCE == null) INSTANCE = new Nutriscore(); 
        return INSTANCE;
    }
	
	/**
	 * Application main method.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Nutriscore.getInstance().initialize();
			}
		});
	}
	
	/**
	 * GUI initialization.
	 */
	private void initialize() {
		JFrame mainFrame = new JFrame();
		
		//Build main frame
		mainFrame.setTitle("Nutriscore");
		mainFrame.setPreferredSize(new Dimension(300, 100));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.X_AXIS));
		ImageIcon icon = new ImageIcon(Nutriscore.class.getResource("/images/loupe.png"));
		mainFrame.setIconImage(icon.getImage());

		//Build widgets
		JPanel centerPanel = new JPanel();
		mainFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		slider = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
		slider.setFont(new Font("Arial", Font.BOLD, 40));
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(1, new JLabel("B"));
		labelTable.put(2, new JLabel("C"));
		labelTable.put(3, new JLabel("D"));
		labelTable.put(4, new JLabel("E"));
		
		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true); 
		slider.setEnabled(false);
		centerPanel.add(slider);      
		
		//Build timer
		try {
			Timer timer = new Timer(TIMER_DELAY_MILLISECONDS, new TimerActionListener());
			timer.setInitialDelay(0);
			timer.start();
		} catch (Exception e) {
			System.out.println("Error while executing random number request");
		}
		
		//Main frame display
		mainFrame.setLocationRelativeTo(null);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}
	
	public JSlider getSlider() {
		return slider;
	}
	
	public void setSlider(JSlider slider) {
		this.slider = slider;
	}

}
