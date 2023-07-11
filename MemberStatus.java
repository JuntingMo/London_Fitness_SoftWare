import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberStatus extends JFrame implements ActionListener {
    private static final long serialVersionUID = -2194240811777567652L;
	private JPanel jp1 = new JPanel();
    private JPanel jp2 = new JPanel();
    private JPanel jp3 = new JPanel();
    private JPanel jp4 = new JPanel();
    private String welcomMsg="Choose your operation";
    private JLabel lblWelcome=new JLabel(welcomMsg);
    private JButton btGold=new JButton("   gold card member100$  ");
    private JButton btPlatinum=new JButton("platinum card member 500$");
    private JButton btDiamond=new JButton("diamond card member 1000$");
    public MemberStatus() {
        /****************************Initialization************************/
        super("MemberStatus: "+MemberConfig.memberStatus);

        this.getContentPane().add(jp1);
        this.getContentPane().add(jp2);
        this.getContentPane().add(jp3);
        this.getContentPane().add(jp4);

        this.getContentPane().setLayout(new GridLayout(4,1));
        jp1.add(lblWelcome);
        jp2.add(btGold);
        jp3.add(btPlatinum);
        jp4.add(btDiamond);
        this.setSize(500,350);
        GUI.toCenter(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /**********************add listening*******************************/
        btGold.addActionListener(this);
        btPlatinum.addActionListener(this);
        btDiamond.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btGold) {
            if(MemberConfig.memberStatus.equals("gold card member") || MemberConfig.memberStatus.equals("platinum card member")||MemberConfig.memberStatus.equals("diamond card member")){
                JOptionPane.showMessageDialog(this,"Fail to upgrade.\nYou are already "
                									+ MemberConfig.memberStatus);
            }else{
                MemberConfig.memberStatus="gold card member";
                ReadTxt.modify("Users.txt",MemberConfig.account,MemberConfig.password,MemberConfig.name,MemberConfig.memberStatus,MemberConfig.money);
                JOptionPane.showMessageDialog(this,"Upgrade success.\nYou have become gold card member");
            }

        }
        else if(e.getSource()==btPlatinum) {
            if(MemberConfig.memberStatus.equals("platinum card member")||MemberConfig.memberStatus.equals("diamond card member")){
                JOptionPane.showMessageDialog(this,"Fail to upgrade.\nYou are already "
													+ MemberConfig.memberStatus);
            }else{
                MemberConfig.memberStatus="platinum card member";
                ReadTxt.modify("Users.txt",MemberConfig.account,MemberConfig.password,MemberConfig.name,MemberConfig.memberStatus,MemberConfig.money);
                JOptionPane.showMessageDialog(this,"Upgrade success.\nYou have become platinum card member");
            }

        }
        else if(e.getSource()==btDiamond)
        {
            if(MemberConfig.memberStatus.equals("diamond card member")){
                JOptionPane.showMessageDialog(this,"Fail to upgrade.\nYou are already "
													+ MemberConfig.memberStatus);
            }else{
                MemberConfig.memberStatus="diamond card member";
                ReadTxt.modify("Users.txt",MemberConfig.account,MemberConfig.password,MemberConfig.name,MemberConfig.memberStatus,MemberConfig.money);
                JOptionPane.showMessageDialog(this,"Upgrade success.\nYou have become diamond card member");
            }
        }
    }
}
