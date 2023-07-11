import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class creates the booking session for Live classes.
 * @author  Junting Mo, Jingxuan Wang
 * @version 3.0
 */ 
public class Booking extends JFrame implements ActionListener
{

	private static final long serialVersionUID = -6221229369819628919L;
	//Define components
	private JPanel jpH1,jpH2,jpH3,jpH4,jpH5,jpH6;
	private JLabel jlb1,jlb2,jlb3,jlb4,jlb5;
	private JComboBox<String> jBox1,jBox2,jBox3,jBox4,jBox5;
	private JButton jb1;
	private JTextArea textdata;
	private ImageIcon background = new ImageIcon("img/background.png");

	public Booking()
	{

		jpH1 = new JPanel(); 
		jpH2 = new JPanel(); 
		jpH3 = new JPanel(); 
		jpH4 = new JPanel(); 
		jpH5 = new JPanel();
		jpH6 = new JPanel();
		
		//Create a container
		Container content = getContentPane();

		//Create some choices for users
		JPanel panelArea1 = new JPanel();
		jlb1 = new JLabel("Information to choose");
		jlb1.setFont(new Font("", Font.BOLD, 30));
		jpH1.add(jlb1);
		this.add(jpH1);

		jlb2 = new JLabel("Personal Trainer:");
		String[] j2 = {"Jack","Ming","James","Lucy","Monica"};//Define the personal trainer you can choose
		jBox1 = new JComboBox<String>(j2);
		jpH2.add(jlb2);
		jpH2.add(jBox1);
		this.add(jpH2);

		jlb3 = new JLabel("Date(dd-MM):");
		String[] j3 = {"1","2","3","4","5","6","7","8","9","10","11","12"};//Define the months you can select
		String[] j5 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};//Define the date you can choose
		jBox2 = new JComboBox<String>(j3);
		jBox4 = new JComboBox<String>(j5);
		jpH3.add(jlb3);
		jpH3.add(jBox4);
		jpH3.add(jBox2);
		this.add(jpH3);

		jlb4 = new JLabel("Start Time:");
		String[] j4 = {"08","09","10","14","15","16"};//Define optional time
		jBox3 = new JComboBox<String>(j4);
		jpH4.add(jlb4);
		jpH4.add(jBox3);
		this.add(jpH4);
		
		jlb5 = new JLabel("Training intensity");
		String[] j6 = {"Very high","High","Medium","Low","Very low"};//Define the optional training intensity
		jBox5 = new JComboBox<String>(j6);
		jpH5.add(jlb5);
		jpH5.add(jBox5);
		this.add(jpH5);
		
		JPanel back = new JPanel() {
			private static final long serialVersionUID = 542734331110788015L;
			{
			this.setOpaque(false);
			this.setLayout(new BorderLayout());
			}
			

			public void paintComponent(Graphics g) {
				   g.drawImage(background.getImage(), 0, 0, this);
				   super.paintComponents(g);
			}
		};

		jb1 = new JButton("Submit");//Submit component
		jpH6.add(jb1);
		this.add(jpH6);
		
		panelArea1.add(jpH1);
		panelArea1.add(jpH2);
		panelArea1.add(jpH3);
		panelArea1.add(jpH4);
		panelArea1.add(jpH5);
		panelArea1.add(jpH6);
		panelArea1.setLayout(new GridLayout(6,1));
		back.add(panelArea1);

		//Create a scroll panel
		textdata=new JTextArea("Please book the Live class from the left.\n"
								+"Your current booking:");
		MemberConfig.a = 0;
		while(ReadTxt.readtxtBooking("Booking.txt") == true) {
			textdata.append("\nYou chose " + MemberConfig.str1 + "'s lesson in " + MemberConfig.str5 + " level.\n"
							+ "The date is on " + MemberConfig.str4 + "-" + MemberConfig.str2 + " (dd-MM).\n"
							+ "The class will start at " + MemberConfig.str3 + "\n");
		} //Displays the selected information on the screen
		MemberConfig.a = 0;
		textdata.setLineWrap(true);
		textdata.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textdata,
													ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
													ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		back.add(scrollPane);
		back.setLayout(new GridLayout(1,2));
		content.add(back);

		back.setOpaque(false);
		panelArea1.setOpaque(false);
		jpH1.setOpaque(false);
		jpH2.setOpaque(false);
		jpH3.setOpaque(false);
		jpH4.setOpaque(false);
		jpH5.setOpaque(false);
		jpH6.setOpaque(false);
		
		this.setTitle("Booking");
		this.setSize(750, 450);
		GUI.toCenter(this);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		jb1.addActionListener(this);
    }
	
	/**Give the process button which reacts to the users' click on the button.
	 *
	 */
	public void actionPerformed(ActionEvent e) 
	{

		if(e.getSource() == jb1)
		{
			boolean read = ReadTxt.readtxtBooking("Booking.txt");
			if(((read == true) && (MemberConfig.memberStatus.equals("diamond card member")))
					|| (read == false)) {
				MemberConfig.str1 = (String)jBox1.getSelectedItem();
				MemberConfig.str2 = (String)jBox2.getSelectedItem();
				MemberConfig.str3 = (String)jBox3.getSelectedItem();
				MemberConfig.str4 = (String)jBox4.getSelectedItem();
				MemberConfig.str5 = (String)jBox5.getSelectedItem();
				textdata.append("\nNew booking:\n"
									+ "You chose " + MemberConfig.str1 + "'s lesson in " + MemberConfig.str5 + " level.\n"
									+ "The date is on " + MemberConfig.str4 + "-" + MemberConfig.str2 + " (dd-MM).\n"
									+ "The class will start at " + MemberConfig.str3 + "\n"
									+ "Please click on Start Training five minutes before the designated time "
									+ "to start the personal trainer live class\n");
				String a = MemberConfig.account + "," + MemberConfig.str1 + "," + MemberConfig.str2 +"," + MemberConfig.str3 + "," + MemberConfig.str4 + "," + MemberConfig.str5 + "\n";
				ReadTxt.writeTxt("Booking.txt", a);
				MemberConfig.a = 0;
			}	
			else {
					JOptionPane.showMessageDialog(this,"Sorry!\n"
							+ "Your current membership is "
							+ MemberConfig.memberStatus
							+ ".\nOnly diamond card member"
							+ "can book more than one class.\n"
							+ "Please upgrade in the Member menu.");
			}
	    }
	}
}
