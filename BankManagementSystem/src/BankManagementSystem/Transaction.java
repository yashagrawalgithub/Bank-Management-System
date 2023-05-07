package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import java.util.*;

public class Transaction extends JFrame implements ActionListener
{
    JButton deposit,withdraw,fastcash,statement,pinchange,balance,exit;
    String pinnumber;
    Transaction(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("TRANSACTION");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel label =new JLabel(i3);
        label.setBounds(0,0,700,700);
        add(label);
        
        JLabel text=new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setFont(new Font("Times New Roman",Font.BOLD,14));
        text.setBounds(135,250,400,40);
        text.setForeground(Color.white);
        label.add(text);
        
        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Times New Roman",Font.BOLD,14));
        deposit.setBounds(130,350,120,20);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        label.add(deposit);
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("Times New Roman",Font.BOLD,14));
        withdraw.setBounds(280,350,120,20);
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        fastcash = new JButton("FAST CASH");
        fastcash.setFont(new Font("Times New Roman",Font.BOLD,14));
        fastcash.setBounds(130,380,120,20);
        fastcash.setBackground(Color.white);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        label.add(fastcash);
        
        balance = new JButton("BALANCE");
        balance.setFont(new Font("Times New Roman",Font.BOLD,14));
        balance.setBounds(280,380,120,20);
        balance.setBackground(Color.white);
        balance.setForeground(Color.black);
        balance.addActionListener(this);
        label.add(balance);
        
        pinchange = new JButton("PIN CHANGE");
        pinchange.setFont(new Font("Times New Roman",Font.BOLD,14));
        pinchange.setBounds(130,410,120,20);
        pinchange.setBackground(Color.white);
        pinchange.setForeground(Color.black);
        pinchange.addActionListener(this);
        label.add(pinchange);
               
        exit = new JButton("EXIT");
        exit.setFont(new Font("Times New Roman",Font.BOLD,14));
        exit.setBounds(280,410,120,20);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        label.add(exit);        
        
        getContentPane().setBackground(Color.white);
        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exit)
        {
            System.exit(0);
        }    
        if(e.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }  
        if(e.getSource()==withdraw)
        {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }  
        if(e.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        if(e.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }  
        if(e.getSource()==balance)
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
                JOptionPane.showMessageDialog(null,"CURRENT BALANCE: "+balance);
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
            catch(SQLException a)
            {
                System.out.println(a);
            }
        }
    }
    
    public static void main(String args[])
    {
        new Transaction("");
    }
}
