import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class which contains the workout video function. 
 * @author  Shuo Shi, Jingxuan Wang
 * @version 3.0
 */ 
public class Workout extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declaration of instance variables to make widgets
    private JPanel jpl = new JPanel();
    private JPanel jpr = new JPanel();
    private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel();
    private JPanel jp4 = new JPanel();
    private JPanel jp5 = new JPanel();
    private JLabel jl1 = new JLabel("Workout at home!");
    private JButton jb1 = new JButton("Back");
    private JButton jb2 = new JButton("Booty");
    private JButton jb3 = new JButton("Arm");
    private JButton jb4 = new JButton("Belly");
    private JButton jb5 = new JButton("Leg");
    private JButton jb6 = new JButton("Yoga");
    private JButton jb7 = new JButton("HIIT");
    private JButton jb8 = new JButton("Stretch");    
    static JLabel jl2 = new JLabel("Picture"){
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
			ImageIcon img = new ImageIcon("img/workout.png");
			g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), img.getImageObserver());
			jl2.setIcon(img);
		}
	};

	/**The constructor for the system which creates the workout GUI. 
	 */
    public Workout() {
    	
    	// Make the frame
        JFrame jf = new JFrame();        
        jf.setLayout(new BorderLayout());
        jf.getContentPane().add(jpl, BorderLayout.CENTER);
        jf.getContentPane().add(jpr, BorderLayout.WEST);

        // Add panels to the frame
        jpl.setLayout(new BorderLayout());
        jpl.add(jp1, BorderLayout.NORTH);
        jpl.add(jp2, BorderLayout.WEST);
        jpl.add(jp3, BorderLayout.SOUTH);
        jpl.add(jp4, BorderLayout.EAST);
        jpl.add(jp5, BorderLayout.CENTER);
        jp2.setLayout(new GridLayout(2, 1));
        jp3.setLayout(new GridLayout(1, 3));
        jp4.setLayout(new GridLayout(3, 1));
        
        // Add widgets to the panels
        jp1.add(jl1);
        jp2.add(jb1);
        jp2.add(jb2);
        jp3.add(jb6);
        jp3.add(jb7);
        jp3.add(jb8);
        jp4.add(jb3);
        jp4.add(jb4);
        jp4.add(jb5);
        jp5.add(jl2);
        jl2.setBounds(100,100,300,300);

        // Set event handlers
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);

        // Set status for the frame
        jf.setTitle("Workout");
        jf.setSize(750, 450);
        GUI.toCenter(jf);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.setResizable(false);
        jf.setVisible(true);
    }
    
    /**The method for the process button which reacts to the users' click on the button
     * 										and set the name of the video for playing.
	 * @param e  The user's action.
	 */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1) {
            this.dispose();
            new Video("video/Back.mp4");
        }
        else if(e.getSource() == jb2) {
            this.dispose();
            new Video("video/Booty.mp4");
        }
        else if(e.getSource() == jb3) {
            this.dispose();
            new Video("video/Arm.mp4");
        }
        else if(e.getSource() == jb4) {
            this.dispose();
            new Video("video/Belly.mp4");
        }
        else if(e.getSource() == jb5) {
            this.dispose();
            new Video("video/Leg.mp4");
        }
        else if(e.getSource() == jb6) {
            this.dispose();
            new Video("video/Yoga.mp4");
        }
        else if(e.getSource() == jb7) {
            this.dispose();
            new Video("video/HIIT.mp4");
        }
        else if(e.getSource() == jb8) {
            this.dispose();
            new Video("video/Stretch.mp4");
        }
    }
}