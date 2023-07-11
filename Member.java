import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The class which shows the function of member
 * @author  Kehan Chen, Qilin Yang, Jingxuan Wang
 * @version 3.0
 */ 
public class Member extends JFrame implements ActionListener {
    private static final long serialVersionUID = 6641052793067564391L;
	/************************Define all components******************************/
	private JPanel jpl = new JPanel();
	private JPanel jpr = new JPanel();
    private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel();
    private JPanel jp4 = new JPanel();
    private JPanel jp5 = new JPanel();
    private JPanel jp6 = new JPanel();
    private String welcomMsg="Choose your operation";
    private JLabel lblWelcome=new JLabel(welcomMsg);
    private JButton btQuery=new JButton("    Query account profile    ");
    private JButton btModify=new JButton("Modify your account profile");
    private JButton btUpgrade=new JButton("     Upgrade membership    ");
    private JButton btRecharge =new JButton("          Recharge         ");
    private JButton btPurchase=new JButton("          Purchase         ");
    private ImageIcon background = new ImageIcon("img/background.png");
    private JLabel jl = new JLabel(background);
    @SuppressWarnings("deprecation")
	public Member() {
        /****************************Initialization************************/
        super("Member: "+MemberConfig.name);

        this.getContentPane().add(jpl);
        this.getContentPane().add(jpr);
        
        jpl.add(jp1);		
		jpl.add(jp2);
		jpl.add(jp3);
		jpl.add(jp4);
		jpl.add(jp5);
		jpl.add(jp6);
        
        jpl.setLayout(new GridLayout(6,1));
        this.getContentPane().setLayout(new GridLayout(1,2));
        
        // Set the background and label
        lblWelcome.setFont(new Font("", Font.BOLD, 30));
        lblWelcome.setForeground(Color.white);
     	jl.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
     	
     	JPanel j=(JPanel)this.getContentPane();
		j.setOpaque(false);
		jpl.setOpaque(false);
		jpr.setOpaque(false);
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		jp4.setOpaque(false);
		jp5.setOpaque(false);
		jp6.setOpaque(false);
		this.getLayeredPane().add(jl, new Integer(Integer.MIN_VALUE));
     	
     	jp1.add(lblWelcome);
        jp2.add(btQuery);
        jp3.add(btModify);
        jp4.add(btUpgrade);
        jp5.add(btRecharge);
        jp6.add(btPurchase);
        this.setSize(750,450);
        GUI.toCenter(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
        /**********************add listening*******************************/
        btQuery.addActionListener(this);
        btModify.addActionListener(this);
        btUpgrade.addActionListener(this);
        btRecharge.addActionListener(this);
        btPurchase.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btQuery) {
            String message="Your account profile:\n";
            message+="Account:"+MemberConfig.account+"\n";
            message+="Name:"+MemberConfig.name+"\n";
            message+="Membership Status: "+MemberConfig.memberStatus+"\n";
            JOptionPane.showMessageDialog(this,message);
        }
        else if(e.getSource()==btModify) {
            new ModifyAccount();
        }
        else if(e.getSource()==btUpgrade)
        {
            new MemberStatus();
        }
        else if(e.getSource()==btRecharge)
        {
            new Recharge();
        }
        else if(e.getSource()==btPurchase)
        {
            //new charge();
            new Purchase();
        }
    }
}