import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Purchase extends JFrame implements ActionListener {

	private static final long serialVersionUID = 8779578892288065068L;
	private JLabel lbHour=new JLabel("Class hour 50$");
	private JLabel lbT=new JLabel("T-shirt 50$");
	private JLabel lbFe=new JLabel("Fitness equipment 50$");
	private JLabel lbPP=new JLabel("Protein Powder 100$");
	private JLabel lbShoe=new JLabel("Shoes 100$");
	private JTextField tf1=new JTextField(10);
	private JTextField tf2=new JTextField(10);
	private JTextField tf3=new JTextField(10);
	private JTextField tf4=new JTextField(10);
	private JTextField tf5=new JTextField(10);
	private JButton btPurchase=new JButton("Buy");
	private String welcomMsg="Please enter the number of the goods.";
	private JLabel lbW=new JLabel(welcomMsg);
	public Purchase()
	{
		super("Purchase");
		this.setLayout(new FlowLayout());
		this.add(lbW);
		this.add(lbHour);
		this.add(tf1);
		this.add(lbT);
		this.add(tf2);
		this.add(lbFe);
		this.add(tf3);
		this.add(lbPP);
		this.add(tf4);
		this.add(lbShoe);
		this.add(tf5);
		this.add(btPurchase);

		this.setSize(270,250);
		GUI.toCenter(this);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		btPurchase.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btPurchase){
			int n1= 0;
			if(!tf1.getText().equals("")){
				n1= Integer.parseInt(tf1.getText());
			}
			int n2= 0;
			if(!tf2.getText().equals("")){
				n2= Integer.parseInt(tf2.getText());
			}
			int n3= 0;
			if(!tf3.getText().equals("")){
				n3= Integer.parseInt(tf3.getText());
			}
			int n4= 0;
			if(!tf4.getText().equals("")){
				n4= Integer.parseInt(tf4.getText());
			}
			int n5= 0;
			if(!tf5.getText().equals("")){
				n5= Integer.parseInt(tf5.getText());
			}
			int money=MemberConfig.money;
			money=money-50*n1-50*n2-50*n3-100*n4-100*n5;
			if(money<0)
				JOptionPane.showMessageDialog(this,"Insufficient Balance");
			else{
				ReadTxt.modify("Users.txt",MemberConfig.account,MemberConfig.password,MemberConfig.name,MemberConfig.memberStatus,money);
				JOptionPane.showMessageDialog(this," Purchase Success");
			}
		}
	}
}
