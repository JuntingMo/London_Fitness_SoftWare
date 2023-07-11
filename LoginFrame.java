import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {//create a window can respond to user's action
    private static final long serialVersionUID = -8522386036909363040L;
	private JLabel lbAccount=new JLabel("Please input your account");
    private JTextField tfAccount=new JTextField(10);// used for input the account
    private JLabel lbPassword=new JLabel("Please input your password");
    private JPasswordField pfPassword=new JPasswordField(10);// used for input the password
    private JButton btLogin=new JButton("Login");
    private JButton btRegister=new JButton("Register");
    private JButton btExit=new JButton("Quit");
    public LoginFrame() {
        /**********************Initialization*****************************/
        super("Login");
        this.setLayout(new FlowLayout());
        //put the label on the frame
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(btLogin);
        this.add(btRegister);
        this.add(btExit);
        this.setSize(240,180);
        GUI.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);// the size of the frame is fixed
        this.setVisible(true);// display the frame
        /*****************************let the three button works************************/
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {// respond to user's operation
        if(e.getSource()==btLogin) {
            String account=tfAccount.getText();
            String password=new String(pfPassword.getPassword());
            // Open the file to read account( need to write more code)
            if(ReadTxt.check("Users.txt",account,password)){
                JOptionPane.showMessageDialog(this,"Login success");
                new Interface();
                this.dispose();
                //into the operation window( need to write more code)
            }else{
                JOptionPane.showMessageDialog(this,"Login failure");
            }

        }
        else if(e.getSource()==btRegister) {
            new Register();
            // into the register window( need to write more code)
        }
        else {
            JOptionPane.showMessageDialog(this,"Goodbye");
            System.exit(0);//exit the window
        }
    }
}