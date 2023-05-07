package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class signupone extends JFrame implements ActionListener
{
    long random;
    JTextField nametext,fnametext,emailtext,addresstext,citytext,statetext,pincodetext;
    JButton next;
    JRadioButton male,female,single,married,divorced;
    JDateChooser dobdate;
    signupone()
    {
        setLayout(null);
        setTitle("APPLICATION FORM:");

        Random ram = new Random();
        random = Math.abs((ram.nextLong() % 9000L)+1000L);

        JLabel formno = new JLabel("APPLICATION FORM NUMBER: " + random);
        formno.setFont(new Font("Times New Roman",Font.BOLD,28));
        formno.setBounds(170,20,600,40);
        add(formno);

        JLabel persondetails = new JLabel("PAGE 1: PERSONAL DETAILS");
        persondetails.setFont(new Font("Times New Roman",Font.BOLD,22));
        persondetails.setBounds(290,80,400,30);
        add(persondetails);

        JLabel name = new JLabel("NAME: ");
        name.setFont(new Font("Times New Roman",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        nametext = new JTextField();
        nametext.setFont(new Font("Times New Roman",Font.BOLD,14));
        nametext.setBounds(400,140,400,30);
        add(nametext);

        JLabel fname = new JLabel("FATHER'S NAME: ");
        fname.setFont(new Font("Times New Roman",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnametext = new JTextField();
        fnametext.setFont(new Font("Times New Roman",Font.BOLD,14));
        fnametext.setBounds(400,190,400,30);
        add(fnametext);

        JLabel dob = new JLabel("DATE OF BIRTH: ");
        dob.setFont(new Font("Times New Roman",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);

        dobdate = new JDateChooser();
        dobdate.setBounds(400,240,400,30);
        add(dobdate);

        JLabel gender = new JLabel("GENDER: ");
        gender.setFont(new Font("Times New Roman",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("MALE");
        male.setFont(new Font("Times New Roman",Font.BOLD,14));
        male.setBounds(400,290,100,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setFont(new Font("Times New Roman",Font.BOLD,14));
        female.setBounds(500,290,100,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("EMAIL ADDRESS: ");
        email.setFont(new Font("Times New Roman",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);

        emailtext = new JTextField();
        emailtext.setFont(new Font("Times New Roman",Font.BOLD,14));
        emailtext.setBounds(400,340,400,30);
        add(emailtext);

        JLabel marital = new JLabel("MARITAL STATUS: ");
        marital.setFont(new Font("Times New Roman",Font.BOLD,22));
        marital.setBounds(100,390,250,30);
        add(marital);

        single = new JRadioButton("SINGLE");
        single.setFont(new Font("Times New Roman",Font.BOLD,14));
        single.setBounds(400,390,100,30);
        single.setBackground(Color.white);
        add(single);

        married = new JRadioButton("MARRIED");
        married.setFont(new Font("Times New Roman",Font.BOLD,14));
        married.setBounds(500,390,100,30);
        married.setBackground(Color.white);
        add(married);

        divorced = new JRadioButton("DIVORCED");
        divorced.setFont(new Font("Times New Roman",Font.BOLD,14));
        divorced.setBounds(600,390,100,30);
        divorced.setBackground(Color.white);
        add(divorced);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(single);
        maritalgroup.add(married);
        maritalgroup.add(divorced);

        JLabel address = new JLabel("ADDRESS: ");
        address.setFont(new Font("Times New Roman",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);

        addresstext = new JTextField();
        addresstext.setFont(new Font("Times New Roman",Font.BOLD,14));
        addresstext.setBounds(400,440,400,30);
        add(addresstext);

        JLabel city = new JLabel("CITY: ");
        city.setFont(new Font("Times New Roman",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        citytext = new JTextField();
        citytext.setFont(new Font("Times New Roman",Font.BOLD,14));
        citytext.setBounds(400,490,400,30);
        add(citytext);

        JLabel state = new JLabel("STATE: ");
        state.setFont(new Font("Times New Roman",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);

        statetext = new JTextField();
        statetext.setFont(new Font("Times New Roman",Font.BOLD,14));
        statetext.setBounds(400,540,400,30);
        add(statetext);

        JLabel pincode = new JLabel("PINCODE: ");
        pincode.setFont(new Font("Times New Roman",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodetext = new JTextField();
        pincodetext.setFont(new Font("Times New Roman",Font.BOLD,14));
        pincodetext.setBounds(400,590,400,30);
        add(pincodetext);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Times New Roman",Font.BOLD,14));
        next.setBounds(400,640,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850,750);
        setLocation(300,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String formno=" "+random;
        String name= nametext.getText();
        String fname=fnametext.getText();
        String dob=((JTextField)dobdate.getDateEditor().getUiComponent()).getText();
        String gender=null;
        
        if(male.isSelected()) {gender="MALE";}
        else if(female.isSelected()){gender="FEMALE";}
        
        String email=emailtext.getText();
        String marital =null;
        
        if(single.isSelected()){marital="SINGLE";}
        else if(married.isSelected()){marital="MARRIED";}
        else if(divorced.isSelected()){marital="DIVORCED";}
        
        String address=addresstext.getText();
        String city=citytext.getText();
        String state=statetext.getText();
        String pincode=pincodetext.getText();
            
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is required");
            }       
            else
            {
                Connect con =new Connect();
                String query ="insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+dob+"'"
                        + ",'"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                con.stmt.executeUpdate(query);
                setVisible(false);
                new signuptwo(formno).setVisible(true);
            }
        }
        catch(SQLException a)
        {
            System.out.println(a);
        }
    }
    public static void main (String [] args)
    {
        new signupone().setVisible(true);
    }
}
