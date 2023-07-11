import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class creates the GUI interface for Live classes.
 * @author  Junting Mo, Jingxuan Wang
 * @version 3.0
 */
public class Live extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6141672754595499972L;
	private JPanel jpl = new JPanel();
	private JPanel jpr = new JPanel();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	private ImageIcon background = new ImageIcon("img/background.png");
	private JLabel jl1 = new JLabel("Live classes Booking");
	private JLabel jl2 = new JLabel(background);
	private JButton jbt1 = new JButton("Book a new class");
	private JButton jbt2 = new JButton("Start Training");

	@SuppressWarnings("deprecation")
	public Live() {
		// Make the frame.
		JFrame jf = new JFrame();
		
		// Add panels to the frame.
		jf.getContentPane().add(jpl);		
		jf.getContentPane().add(jpr);
		jpl.add(jp1);		
		jpl.add(jp2);
		jpl.add(jp3);
		
		// Add widgets to the panels.
		jp1.add(jl1);
		jp2.add(jbt1);
		jp3.add(jbt2);
		
		// Set event handlers.
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		
		// Set the background and label
		jl1.setFont(new Font("", Font.BOLD, 30));
		jl1.setForeground(Color.white);
		jl2.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		
		JPanel j=(JPanel)jf.getContentPane();
		j.setOpaque(false);
		jpl.setOpaque(false);
		jpr.setOpaque(false);
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		
		jf.getLayeredPane().add(jl2, new Integer(Integer.MIN_VALUE));
		
		// Set status for the frame.
		jf.setTitle("Booking");
		jf.setSize(750, 450);
		GUI.toCenter(jf);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jpl.setLayout(new GridLayout(3, 1));
		jf.getContentPane().setLayout(new GridLayout(1, 2));
		jf.setResizable(false);
		jf.setVisible(true);
		
		ReadTxt.readtxtBooking("Booking.txt");
	}
	
	/**The method for the process button which reacts to the users' click on the button.
	 * @param e  The user's action.
	 */
	public void actionPerformed(ActionEvent e) {
		
		// When the user clicks a button, run the corresponding code below.
		if(e.getSource() == jbt1){
			//Go to the workout interface.
	    	new Booking();
	    }
		else if(e.getSource() == jbt2){
			//Go to the member interface.
			if(MemberConfig.str1.equals("")) {
				JOptionPane.showMessageDialog(this, "Sorry!\n"
												+ "You haven't booked any Live lessons!");
			}
			else {
				new Training();
			}
	    }
	}
}
