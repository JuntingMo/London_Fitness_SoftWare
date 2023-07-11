import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * The class for modifying account information.
 * @author  Kehan Chen, Qilin Yang, Jingxuan Wang
 * @version 3.0
 */

public class ModifyAccount extends JFrame implements ActionListener{
    private static final long serialVersionUID = 861612102244275730L;
	private JLabel lbName=new JLabel("Please input your new name");
    private JTextField tfName=new JTextField(15);// used for input the account
    private JLabel lbPassword=new JLabel("Please input your new password");
    private JTextField tfPassword=new JTextField(15);// used for input the password
    private JButton btModify=new JButton("Modify");
    public ModifyAccount(){
        super("Modify");
        this.setLayout(new FlowLayout());
        this.add(lbName);
        this.add(tfName);
        this.add(lbPassword);
        this.add(tfPassword);
        this.add(btModify);
        this.setSize(300,150);
        GUI.toCenter(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);// the size of the frame is fixed
        this.setVisible(true);// display the frame
        tfName.setText(MemberConfig.name);
        tfPassword.setText(MemberConfig.password);
        /**********************add listening*******************************/
        btModify.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btModify) {
            String password=tfPassword.getText();
            String name=tfName.getText();
            Check c = new Check();
            
            //Check if the user input anything
            if(password.length() == 0 
            		|| name.length() == 0){
            	JOptionPane.showMessageDialog(this,"Please fill in all the blank");
            }
            else if(c.checkPassword(password) == false){//Check the validation of user's password
            	JOptionPane.showMessageDialog(this,"Please enter a valid password:\n"
            			+ "- between six and ten characters long\n"
            			+ "- contain only letters and digits\n"
            			+ "- contain at least one letter and one digit");
            }
            else{
            	ReadTxt.modify("Users.txt",MemberConfig.account,password,name,MemberConfig.memberStatus,MemberConfig.money);
            	this.dispose();
            }
        }
    }
}
