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
 * The main class which creates the basic GUI interface of a digital gym system.
 * @author  Jingxuan Wang
 * @version 4.1
 */ 
public class Interface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 9100370373561590712L;
	// Declaration of instance variables to make widgets
	private JFrame jf = new JFrame();
	private JPanel jpl = new JPanel();
	private JPanel jpr = new JPanel();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	private JPanel jp4 = new JPanel();
	private JPanel jp5 = new JPanel();
	private ImageIcon background = new ImageIcon("img/background.png");
	private JLabel jl1 = new JLabel("Hello! " + MemberConfig.name);
	private JLabel jl2 = new JLabel(background);
	private JButton jbt1 = new JButton("    Workout Videos  ");
	private JButton jbt2 = new JButton("    Live Training   ");
	private JButton jbt3 = new JButton("      Membership    ");
	private JButton jbt4 = new JButton("       Log out      ");
	
	/**The constructor for the system which creates the basic GUI. 
	 */
	@SuppressWarnings("deprecation")
	public Interface() {
		
		// Set the background and label
		jl1.setFont(new Font("", Font.BOLD, 30));
		jl1.setForeground(Color.white);
		jl2.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		
		// Add panels to the frame
		jf.getContentPane().add(jpl);
		jf.getContentPane().add(jpr);
		
		jpl.add(jp1);		
		jpl.add(jp2);
		jpl.add(jp3);
		jpl.add(jp4);
		jpl.add(jp5);
		
		
		// Add widgets to the panels
		jp1.add(jl1);
		jp2.add(jbt1);
		jp3.add(jbt2);
		jp4.add(jbt3);
		jp5.add(jbt4);
	
		// Set event handlers
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
		jbt4.addActionListener(this);
		
		JPanel j=(JPanel)jf.getContentPane();
		j.setOpaque(false);
		jpl.setOpaque(false);
		jpr.setOpaque(false);
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		jp4.setOpaque(false);
		jp5.setOpaque(false);
		
		jf.getLayeredPane().add(jl2, new Integer(Integer.MIN_VALUE));
		
		// Set status for the frame
		jf.setTitle("London Fitness");
		jf.setSize(750, 450);
		GUI.toCenter(jf);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jpl.setLayout(new GridLayout(5, 1));
		jf.getContentPane().setLayout(new GridLayout(1, 2));
		jf.setResizable(false);
		jf.setVisible(true);
	}
	
	/**The method for the process button which reacts to the users' click on the button.
	 * @param e  The user's action.
	 */
	public void actionPerformed(ActionEvent e) {
		
		// When the user clicks a button, run the corresponding code below
		if(e.getSource() == jbt1){
			// Check the membership of the user
			if((MemberConfig.memberStatus.equals("gold card member"))
					|| (MemberConfig.memberStatus.equals("platinum card member"))
					|| (MemberConfig.memberStatus.equals("diamond card member"))) {
				// Go to the workout interface
				new Workout();
			}
			else {
				JOptionPane.showMessageDialog(this,"Sorry!\n"
													+ "Your current membership is "
													+ MemberConfig.memberStatus
													+ ".\nOnly gold card member or superior membership"
													+ "can assess this function.\n"
													+ "Please upgrade in the Member menu.");
			}
	    }
		else if(e.getSource() == jbt2){
			// Check the membership of the user
			if((MemberConfig.memberStatus.equals("platinum card member"))
					|| (MemberConfig.memberStatus.equals("diamond card member"))) {
				//Go to the live workout interface
				new Live();
			}
			else {
				JOptionPane.showMessageDialog(this,"Sorry!\n"
													+ "Your current membership is "
													+ MemberConfig.memberStatus
													+ ".\nOnly platinum card member or superior membership"
													+ "can assess this function.\n"
													+ "Please upgrade in the Member menu.");
			}
	    }
		else if(e.getSource() == jbt3){
			//Go to the member interface
	        new Member();
	    }
		else if(e.getSource() == jbt4){
			//Log out and open the login frame
			JOptionPane.showMessageDialog(this,"Log out successfully");
			jf.dispose();
			new LoginFrame();
			MemberConfig.str1 = "";
			MemberConfig.str2 = "";
			MemberConfig.str3 = "";
			MemberConfig.str4 = "";
			MemberConfig.str5 = "";
	    }
	}
	
	/**The main method for the system.
	 * @param args  The maximum number of probes.
	 */
	public static void main(String[] args) {
		//Start with the login interface
		new LoginFrame();
	}
}
