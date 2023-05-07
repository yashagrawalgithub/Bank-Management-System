package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
//import java.util.*;

public class Withdraw extends JFrame implements ActionListener
{
    JTextField withdrawtext;
    JButton withdraw,back;
    String pinnumber;
    Withdraw(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("WITHDRAW");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel label =new JLabel(i3);
        label.setBounds(0,0,700,700);
        add(label);
        
        JLabel text=new JLabel("ENTER AMOUNT TO WITHDRAW");
        text.setFont(new Font("Times New Roman",Font.BOLD,14));
        text.setBounds(170,250,400,40);
        text.setForeground(Color.white);
        label.add(text);
        
        withdrawtext=new JTextField();
        withdrawtext.setBounds(160,350,200,25);
        withdrawtext.setFont(new Font("Times New Roman",Font.BOLD,20));
        label.add(withdrawtext);
        
        back = new JButton("BACK");
        back.setFont(new Font("Times New Roman",Font.BOLD,14));
        back.setBounds(130,400,120,20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        label.add(back);
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("Times New Roman",Font.BOLD,14));
        withdraw.setBounds(280,400,120,20);
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        getContentPane().setBackground(Color.white);
        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else
        {
            String amount=withdrawtext.getText();
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

                    String query ="select * from transaction where Pin_Number='"+pinnumber+"'";
                
                    ResultSet r=con.stmt.executeQuery(query);
                    int balance=0;
                    while(r.next())
                    {
                        if(r.getString("Type").equals("DEPOSIT"))
                        {
                            balance+=Integer.parseInt(r.getString("Amount"));
                        }
                        else
                        {
                            balance-=Integer.parseInt(r.getString("Amount"));
                        }
                    }
                    if(balance<Integer.parseInt(amount))
                    {
                        JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE");
                        return ;
                    }
                    
                    String query1 ="insert into transaction values('"+pinnumber+"','"+date+"','WITHDRAW','"+amount+"')";
                    con.stmt.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"WITHDRAWN SUCCESSFULLY \nAMOUNT: "+amount);
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                catch(SQLException a)
                {
                   System.out.println(a);
                }
            }
        }    
    }
    
    public static void main(String args[])
    {
        new Withdraw("");
    }

}

