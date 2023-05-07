package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import java.util.*;

public class Login extends JFrame implements ActionListener
{
    JButton login,signup,clear;
    JTextField cardtext;
    JPasswordField pintext;
    Login()
    {
        setTitle("ATM");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);

        JLabel label =new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Times New Roman",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("CARD NO. :");
        cardno.setFont(new Font("Times New Roman",Font.BOLD,28));
        cardno.setBounds(150,150,400,40);
        add(cardno);

        cardtext=new JTextField();
        cardtext.setBounds(320,150,300,30);
        cardtext.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(cardtext);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Times New Roman",Font.BOLD,28));
        pin.setBounds(150,220,400,40);
        add(pin);

        pintext= new JPasswordField();
        pintext.setBounds(320,220,300,30);
        pintext.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(pintext);

        login = new JButton("LOGIN");
        login.setBounds(320,300,130,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(490,300,130,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(400,350,130,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(200,150);
    }
    public static void main(String[]args)
    {
        new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==clear)
        {
            cardtext.setText("");
            pintext.setText("");
        }
        else if (e.getSource()==login)
        {
            String cardnumber=cardtext.getText();
            String pinnumber=pintext.getText();
            try
            {
                Connect con =new Connect();

                String query ="select * from login where Card_Number= '"+cardnumber+"' and Pin_Number='"+pinnumber+"'";
                
                ResultSet r =con.stmt.executeQuery(query);
                if(r.next())
                {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"INVALID CREDENTIAL");

                }
            }
            catch(SQLException a)
            {
                System.out.println(a);
            }
        }
        else if(e.getSource()==signup)
        {
            setVisible(false);
            new signupone().setVisible(true);

        }
    }
}
