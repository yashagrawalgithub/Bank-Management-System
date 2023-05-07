package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
//import java.util.*;

public class FastCash extends JFrame implements ActionListener
{
    JButton OH,TH,FH,TT,back;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("FAST CASH");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel label =new JLabel(i3);
        label.setBounds(0,0,700,700);
        add(label);
        
        JLabel text=new JLabel("PLEASE SELECT YOUR AMOUNT");
        text.setFont(new Font("Times New Roman",Font.BOLD,14));
        text.setBounds(170,250,400,40);
        text.setForeground(Color.white);
        label.add(text);
        
        OH = new JButton("RS. 100");
        OH.setFont(new Font("Times New Roman",Font.BOLD,14));
        OH.setBounds(130,350,120,20);
        OH.setBackground(Color.white);
        OH.setForeground(Color.black);
        OH.addActionListener(this);
        label.add(OH);
        
        TH = new JButton("RS. 200");
        TH.setFont(new Font("Times New Roman",Font.BOLD,14));
        TH.setBounds(280,350,120,20);
        TH.setBackground(Color.white);
        TH.setForeground(Color.black);
        TH.addActionListener(this);
        label.add(TH);
        
        FH = new JButton("RS. 500");
        FH.setFont(new Font("Times New Roman",Font.BOLD,14));
        FH.setBounds(130,380,120,20);
        FH.setBackground(Color.white);
        FH.setForeground(Color.black);
        FH.addActionListener(this);
        label.add(FH);
        
        TT = new JButton("RS. 2000");
        TT.setFont(new Font("Times New Roman",Font.BOLD,14));
        TT.setBounds(280,380,120,20);
        TT.setBackground(Color.white);
        TT.setForeground(Color.black);
        TT.addActionListener(this);
        label.add(TT);
        
        back = new JButton("BACK");
        back.setFont(new Font("Times New Roman",Font.BOLD,14));
        back.setBounds(130,420,120,20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        label.add(back); 
        
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
            String amount=((JButton)e.getSource()).getText().substring(4);        
            Date date = new Date();
   
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
                
                String query1="insert into transaction values('"+pinnumber+"','"+date+"','WITHDRAW','"+amount+"')";
                con.stmt.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"FAST CASH WITHDRAWN SUCCESSFULLY \nAMOUNT: "+amount);
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
        new FastCash("");
    }
}
