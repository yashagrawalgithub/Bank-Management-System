package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class signupthree extends JFrame implements ActionListener
{
    JRadioButton saving,current;
    JCheckBox s1,s2,s3,s4,s5,s6,declare;
    JButton cancel,submit;
    String formno;
    signupthree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("APPLICATION FORM:");
        
        JLabel finaldetails = new JLabel("PAGE 3: FINAL DETAILS");
        finaldetails.setFont(new Font("Times New Roman",Font.BOLD,22));
        finaldetails.setBounds(290,80,400,30);
        add(finaldetails);

        JLabel accounttype = new JLabel("ACCOUNT TYPE:");
        accounttype.setFont(new Font("Times New Roman",Font.BOLD,22));
        accounttype.setBounds(100,140,200,30);
        add(accounttype);
        
        saving = new JRadioButton("SAVING ACCOUNT");
        saving.setFont(new Font("Times New Roman",Font.BOLD,14));
        saving.setBounds(400,140,150,30);
        saving.setBackground(Color.white);
        add(saving);
        
        current = new JRadioButton("CURRENT ACCOUNT");
        current.setFont(new Font("Times New Roman",Font.BOLD,14));
        current.setBounds(550,140,180,30);
        current.setBackground(Color.white);
        add(current);
        
        ButtonGroup accounttypegroup = new ButtonGroup();
        accounttypegroup.add(saving);
        accounttypegroup.add(current);
        
        JLabel cardno = new JLabel("CARD NUMBER:");
        cardno.setFont(new Font("Times New Roman",Font.BOLD,22));
        cardno.setBounds(100,190,200,30);
        add(cardno);
        
        JLabel cno = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cno.setFont(new Font("Times New Roman",Font.BOLD,22));
        cno.setBounds(400,190,300,30);
        add(cno);
        
        JLabel pinno = new JLabel("PIN NUMBER:");
        pinno.setFont(new Font("Times New Roman",Font.BOLD,22));
        pinno.setBounds(100,240,200,30);
        add(pinno);
        
        JLabel pno = new JLabel("XXXX");
        pno.setFont(new Font("Times New Roman",Font.BOLD,22));
        pno.setBounds(400,240,200,30);
        add(pno);
        
        JLabel services = new JLabel("SERVICES REQUIRED:");
        services.setFont(new Font("Times New Roman",Font.BOLD,22));
        services.setBounds(100,290,250,30);
        add(services);
        
        s1=new JCheckBox("ATM CARD");
        s1.setFont(new Font("Times New Roman",Font.BOLD,20));
        s1.setBounds(400,290,200,25);
        s1.setBackground(Color.white);
        add(s1);
        
        s2=new JCheckBox("INTERNET BANKING");
        s2.setFont(new Font("Times New Roman",Font.BOLD,20));
        s2.setBounds(600,290,300,25);
        s2.setBackground(Color.white);
        add(s2);
        
        s3=new JCheckBox("SMS ALERT");
        s3.setFont(new Font("Times New Roman",Font.BOLD,20));
        s3.setBounds(400,340,200,25);
        s3.setBackground(Color.white);
        add(s3);
        
        s4=new JCheckBox("MOBILE BANKING");
        s4.setFont(new Font("Times New Roman",Font.BOLD,20));
        s4.setBounds(600,340,300,25);
        s4.setBackground(Color.white);
        add(s4);
        
        s5=new JCheckBox("CHEQUE BOOK");
        s5.setFont(new Font("Times New Roman",Font.BOLD,20));
        s5.setBounds(400,390,200,25);
        s5.setBackground(Color.white);
        add(s5);
        
        s6=new JCheckBox("E-STATEMENT");
        s6.setFont(new Font("Times New Roman",Font.BOLD,20));
        s6.setBounds(600,390,300,25);
        s6.setBackground(Color.white);
        add(s6);
        
        declare=new JCheckBox("I HEREBY DECLARE THAT THE ABOVE DEATILS ARE CORRECT");
        declare.setFont(new Font("Times New Roman",Font.BOLD,15));
        declare.setBounds(100,450,700,25);
        declare.setBackground(Color.white);
        add(declare);
                
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Times New Roman",Font.BOLD,14));
        cancel.setBounds(400,600,150,30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Times New Roman",Font.BOLD,14));
        submit.setBounds(600,600,150,30);
        submit.addActionListener(this);
        add(submit);
        
        getContentPane().setBackground(Color.white);
        setSize(850,750);
        setLocation(300,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)
        {
            String accounttype=null;
            if(saving.isSelected()){accounttype="SAVING";}
            else if(current.isSelected()){accounttype="CURRENT";}
            
            Random random=new Random();
            String cardno =""+ Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinno=""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String services="";
            if(s1.isSelected()){services+="ATM CARD ";}
            if(s2.isSelected()){services+="INTERNET BANKING ";}
            if(s3.isSelected()){services+="SMS ALERT ";}
            if(s4.isSelected()){services+="MOBILE BANKING ";}
            if(s5.isSelected()){services+="CHEQUE BOOK ";}
            if(s6.isSelected()){services+="E-STATEMENT ";}
            
            try
            {
                if(declare.isSelected()==false)
                {
                    JOptionPane.showMessageDialog(null,"ACCEPT THE DECLARATION");
                }
                else
                {
                    Connect con =new Connect();
                    String query ="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardno+"','"+pinno+"'"
                        + ",'"+services+"')";
                    con.stmt.executeUpdate(query);
                    
                    String query1 ="insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
                    con.stmt.executeUpdate(query1);
                    
                    JOptionPane.showMessageDialog(null,"CARD NUMBER: "+cardno+"\nPIN NUMBER: "+pinno);
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                }
            }
            catch(SQLException a)
            {
                System.out.println(a);
            }
        }
        else if(e.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
            
    }
    public static void main(String args[])
    {
        new signupthree("").setVisible(true);
    }
}
