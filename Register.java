import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * The register class for new users.
 * @author  Kehan Chen, Qilin Yang, Jingxuan Wang
 * @version 3.0
 */ 
public class Register extends JFrame implements ActionListener {
	private static final long serialVersionUID = -8587278184477495036L;
	private JLabel lbName=new JLabel("Please input your name");
    private JTextField tfName=new JTextField(20);// used for input the name
    private JLabel lbAccount=new JLabel("Please input your email address as account");
    private JTextField tfAccount=new JTextField(20);// used for input the account
    private JLabel lbPassword=new JLabel("Please input your password");
    private JTextField tfPassword=new JTextField(20);// used for input the password
    private JButton btRegister=new JButton("Register");

    public Register(){
        super("Register");
        this.setLayout(new FlowLayout());
        this.add(lbName);
        this.add(tfName);
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(tfPassword);
        this.add(btRegister);
        this.setSize(300,220);
        GUI.toCenter(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);// the size of the frame is fixed
        this.setVisible(true);// display the frame
        btRegister.addActionListener(this);
    }
    
    /**The method for the input of users and process button which reacts to the users' click on the button.
	 * @param e  The user's action.
	 */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btRegister) {
        	//Get the user's input in testfield
            String account=tfAccount.getText();
            String password=tfPassword.getText();
            String name=tfName.getText();
            Check c = new Check();
            
            //Check if the user input anything
            if(account.length() == 0 
            		|| password.length() == 0 
            		|| name.length() == 0){
            	JOptionPane.showMessageDialog(this,"Please fill in all the blank");
            }
            else if(c.checkEmail(account) == false){//Check the validation of user's email address
            	JOptionPane.showMessageDialog(this,"Please enter a valid email address");
            }
            else if(c.checkPassword(password) == false){//Check the validation of user's password
            	JOptionPane.showMessageDialog(this,"Please enter a valid password:\n"
            			+ "- between six and ten characters long\n"
            			+ "- contain only letters and digits\n"
            			+ "- contain at least one letter and one digit");
            }
            else if(!ReadTxt.CheckAccount("Users.txt",account)){
                JOptionPane.showMessageDialog(this,"Account must be unique");
            }
            else{
                ReadTxt.writeTxt("Users.txt",account+","+password+","+name+",card member,0"+"\n");
                JOptionPane.showMessageDialog(this,"Register success");
                this.dispose();
            }
        }
    }
}
