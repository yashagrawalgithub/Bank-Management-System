package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import java.util.*;


public class PinChange extends JFrame implements ActionListener
{
    JButton back,change;
    JPasswordField oldtext,newtext;
    String pinnumber;
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("PIN CHANGE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel label =new JLabel(i3);
        label.setBounds(0,0,700,700);
        add(label);
        
        JLabel text=new JLabel("ACCOUNT PIN CHANGE");
        text.setFont(new Font("Times New Roman",Font.BOLD,14));
        text.setBounds(170,250,400,40);
        text.setForeground(Color.white);
        label.add(text);
        
        JLabel oldpin=new JLabel("OLD PIN: ");
        oldpin.setFont(new Font("Times New Roman",Font.BOLD,14));
        oldpin.setBounds(130,340,400,40);
        oldpin.setForeground(Color.white);
        label.add(oldpin );
        
        oldtext=new JPasswordField();
        oldtext.setBounds(280,350,100,25);
        oldtext.setFont(new Font("Times New Roman",Font.BOLD,20));
        label.add(oldtext);
        
        JLabel newpin=new JLabel("NEW PIN: ");
        newpin.setFont(new Font("Times New Roman",Font.BOLD,14));
        newpin.setBounds(130,370,400,40);
        newpin.setForeground(Color.white);
        label.add(newpin );
        
        newtext=new JPasswordField();
        newtext.setBounds(280,380,100,25);
        newtext.setFont(new Font("Times New Roman",Font.BOLD,20));
        label.add(newtext);
        
        back = new JButton("BACK");
        back.setFont(new Font("Times New Roman",Font.BOLD,14));
        back.setBounds(130,420,120,20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        label.add(back); 
        
        change = new JButton("CHANGE");
        change.setFont(new Font("Times New Roman",Font.BOLD,14));
        change.setBounds(280,420,120,20);
        change.setBackground(Color.white);
        change.setForeground(Color.black);
        change.addActionListener(this);
        label.add(change); 
        
        getContentPane().setBackground(Color.white);
        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==change)
        {
            String newpin=newtext.getText();
            String oldpin=oldtext.getText();
            if(oldpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"ENTER OLD PIN");
            }
            if(newpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"ENTER NEW PIN");
            }
            else
            {   
                try
                {
                    Connect con=new Connect();
                
                    String query1="update login set Pin_Number='"+newpin+"' where Pin_Number='"+oldpin+"'";
                    con.stmt.executeUpdate(query1);
                
                    String query2="update transaction set Pin_Number='"+newpin+"' where Pin_Number='"+oldpin+"'";
                    con.stmt.executeUpdate(query2);
                
                    String query3="update signupthree set Pin_Number='"+newpin+"' where Pin_Number='"+oldpin+"'";
                    con.stmt.executeUpdate(query3);
                
                    JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULY");
                    setVisible(false);
                    new Login().setVisible(true);
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
        new PinChange("");
    }
}
