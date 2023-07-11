import javax.swing.*;
import java.awt.*;
/**
 * The class creates the training session for Live classes.
 * @author  Junting Mo, Jingxuan Wang
 * @version 3.0
 */
public class Training extends JFrame {

	private static final long serialVersionUID = -9142313201907638371L;
	//Define components
	private JLabel jlb1;
	private JTextArea textdata;

	public Training() {

		//Create a container
		Container content = this.getContentPane();			
		jlb1 = new JLabel("Welcome to the training session.", JLabel.CENTER);
		jlb1.setFont(new Font("", Font.BOLD, 30));
			
		//Create a scroll panel
		textdata=new JTextArea("Your latest booking: \n");
		//Display the selected information in the screen
		textdata.append("\nYou will have " + MemberConfig.str1 + "'s lesson in " + MemberConfig.str5 + " level.\n"
							+ "The date is on " + MemberConfig.str4 + "-" + MemberConfig.str2 + " (dd-MM).\n"
							+ "The class will start at " + MemberConfig.str3 + "\n"
							+ "Please use 'zoom.us/join' and enter meeting ID '961-4640-8636' to join this training class.");
		textdata.setLineWrap(true);
		textdata.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(
				textdata,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
		);

		content.setLayout(new BorderLayout());
		content.add(jlb1, BorderLayout.NORTH);
		content.add(scrollPane, BorderLayout.CENTER);
		
  		//Setting GUI window information
		this.setTitle("Training");
		this.setSize(750, 450);
		GUI.toCenter(this);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}
}
