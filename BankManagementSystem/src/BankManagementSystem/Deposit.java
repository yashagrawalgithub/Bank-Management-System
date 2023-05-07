package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
//import java.util.*;


public class Deposit extends JFrame implements ActionListener
{
    JTextField deposittext;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("DEPOSIT");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel label =new JLabel(i3);
        label.setBounds(0,0,700,700);
        add(label);
        
        JLabel text=new JLabel("ENTER AMOUNT TO DEPOSIT");
        text.setFont(new Font("Times New Roman",Font.BOLD,14));
        text.setBounds(170,250,400,40);
        text.setForeground(Color.white);
        label.add(text);
        
        deposittext=new JTextField();
        deposittext.setBounds(160,350,200,25);
        deposittext.setFont(new Font("Times New Roman",Font.BOLD,20));
        label.add(deposittext);
        
        back = new JButton("BACK");
        back.setFont(new Font("Times New Roman",Font.BOLD,14));
        back.setBounds(130,400,120,20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        label.add(back);
        
        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Times New Roman",Font.BOLD,14));
        deposit.setBounds(280,400,120,20);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        label.add(deposit);
        
        getContentPane().setBackground(Color.white);
        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==deposit)
        {
            String amount=deposittext.getText();
            Date date = new Date();
            if(amount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"ENTER AMOUNT");
            }
            else
            {
                try
                {
                    Connect con =new Connect();

                    String query ="insert into transaction values('"+pinnumber+"','"+date+"','DEPOSIT','"+amount+"')";
                
                    con.stmt.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null,"DEPOSITED SUCCESSFULLY \nAMOUNT: "+amount);
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                catch(SQLException a)
                {
                   System.out.println(a);
                }
            }
        }    
        if(e.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Deposit("");
    }

}
