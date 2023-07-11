import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Recharge extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1091711054157878589L;

	private String welcomMsg="Choose your operation:\n";

    private String welcomMsg1="Gold card member recharge 100$ get 110$";
    private String welcomMsg2="Platinum card member recharge 100$ get 150$";
    private String welcomMsg3="Diamond card member recharge 100$ get 200$";
    private JLabel lblWelcome=new JLabel(welcomMsg);
    private JLabel lblWelcome1=new JLabel(welcomMsg1);
    private JLabel lblWelcome2=new JLabel(welcomMsg2);
    private JLabel lblWelcome3=new JLabel(welcomMsg3);
    private JLabel lbMoney=new JLabel("Please input the recharge number:");
    private JTextField tfMoney=new JTextField(10);
    private JButton btRecharge=new JButton("Recharge");
    public Recharge() {
        /****************************Initialization************************/
        super(MemberConfig.money+"$");

        this.setLayout(new FlowLayout());
        this.add(lblWelcome);
        this.add(lblWelcome1);
        this.add(lblWelcome2);
        this.add(lblWelcome3);
        this.add(lbMoney);
        this.add(tfMoney);
        this.add(btRecharge);

        this.setSize(300,200);
        GUI.toCenter(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /**********************add listening*******************************/
        btRecharge.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btRecharge) {
            int r=0;
            if(MemberConfig.memberStatus.equals("card member")){
                r= Integer.parseInt(this.tfMoney.getText());
            }else if(MemberConfig.memberStatus.equals("gold card member")){
                r= (int) (Integer.parseInt(this.tfMoney.getText())*1.1);
            }else if(MemberConfig.memberStatus.equals("platinum card member")){
                r= (int) (Integer.parseInt(this.tfMoney.getText())*1.5);
            }else if(MemberConfig.memberStatus.equals("diamond card member")){
                r= Integer.parseInt(this.tfMoney.getText())*2;
            }

            ReadTxt.modify("Users.txt",MemberConfig.account,MemberConfig.password,MemberConfig.name,MemberConfig.memberStatus,MemberConfig.money+r);
            JOptionPane.showMessageDialog(this,"Recharge success");
        }
    }
}
