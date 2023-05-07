package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import java.util.*;
//import com.toedter.calendar.JDateChooser;


public class signuptwo extends JFrame implements ActionListener
{
    JTextField incometext,mobiletext,occupationtext,pantext,adhaartext;
    JButton next;
    JRadioButton general,obc,sc,syes,sno,eyes,eno;
    JComboBox religionval,qualificationval;
    String formno;
    //JDateChooser ;
    signuptwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("APPLICATION FORM:");


        JLabel additionaldetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionaldetails.setFont(new Font("Times New Roman",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);

        JLabel religion = new JLabel("RELIGION: ");
        religion.setFont(new Font("Times New Roman",Font.BOLD,22));
        religion.setBounds(100,140,150,30);
        add(religion);

        String valreligion[]={"HINDU","MUSLIM","SIKH","CHRISTIAN","OTHER"};
        religionval = new JComboBox(valreligion);
        religionval.setFont(new Font("Times New Roman",Font.BOLD,14));
        religionval.setBounds(400,140,400,30);
        religionval.setBackground(Color.white);
        add(religionval);

        JLabel category = new JLabel("CATEGORY: ");
        category.setFont(new Font("Times New Roman",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);

        general = new JRadioButton("GENERAL");
        general.setFont(new Font("Times New Roman",Font.BOLD,14));
        general.setBounds(400,190,100,30);
        general.setBackground(Color.white);
        add(general);

        obc = new JRadioButton("OBC");
        obc.setFont(new Font("Times New Roman",Font.BOLD,14));
        obc.setBounds(500,190,100,30);
        obc.setBackground(Color.white);
        add(obc);
        
        sc = new JRadioButton("SC/ST");
        sc.setFont(new Font("Times New Roman",Font.BOLD,14));
        sc.setBounds(600,190,100,30);
        sc.setBackground(Color.white);
        add(sc);
        
        ButtonGroup categorygroup = new ButtonGroup();
        categorygroup.add(general);
        categorygroup.add(obc);
        categorygroup.add(sc);
        
        JLabel income = new JLabel("INCOME: ");
        income.setFont(new Font("Times New Roman",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);

        incometext = new JTextField();
        incometext.setFont(new Font("Times New Roman",Font.BOLD,14));
        incometext.setBounds(400,240,400,30);
        add(incometext);

        JLabel qualification = new JLabel("QUALIFICATION: ");
        qualification.setFont(new Font("Times New Roman",Font.BOLD,22));
        qualification.setBounds(100,290,230,30);
        add(qualification);

        String valqualification[]={"NON-GRADUATE","UNDER GRADUATE","POST GRADUATE","DOCTARATE","OTHER"};
        qualificationval = new JComboBox(valqualification);
        qualificationval.setFont(new Font("Times New Roman",Font.BOLD,14));
        qualificationval.setBounds(400,290,400,30);
        qualificationval.setBackground(Color.white);
        add(qualificationval);

        JLabel mobile= new JLabel("MOBILE NO: ");
        mobile.setFont(new Font("Times New Roman",Font.BOLD,22));
        mobile.setBounds(100,340,200,30);
        add(mobile);

        mobiletext = new JTextField();
        mobiletext.setFont(new Font("Times New Roman",Font.BOLD,14));
        mobiletext.setBounds(400,340,400,30);
        add(mobiletext);

        JLabel occupation = new JLabel("OCCUPATION: ");
        occupation.setFont(new Font("Times New Roman",Font.BOLD,22));
        occupation.setBounds(100,390,250,30);
        add(occupation);

        occupationtext = new JTextField();
        occupationtext.setFont(new Font("Times New Roman",Font.BOLD,14));
        occupationtext.setBounds(400,390,400,30);
        add(occupationtext);

        JLabel pan = new JLabel("PAN NO: ");
        pan.setFont(new Font("Times New Roman",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);

        pantext = new JTextField();
        pantext.setFont(new Font("Times New Roman",Font.BOLD,14));
        pantext.setBounds(400,440,400,30);
        add(pantext);

        JLabel adhaar = new JLabel("ADHAAR NO: ");
        adhaar.setFont(new Font("Times New Roman",Font.BOLD,22));
        adhaar.setBounds(100,490,200,30);
        add(adhaar);

        adhaartext = new JTextField();
        adhaartext.setFont(new Font("Times New Roman",Font.BOLD,14));
        adhaartext.setBounds(400,490,400,30);
        add(adhaartext);

        JLabel senior = new JLabel("SENIOR CITIZEN: ");
        senior.setFont(new Font("Times New Roman",Font.BOLD,22));
        senior.setBounds(100,540,200,30);
        add(senior);

        syes = new JRadioButton("YES");
        syes.setFont(new Font("Times New Roman",Font.BOLD,14));
        syes.setBounds(400,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setFont(new Font("Times New Roman",Font.BOLD,14));
        sno.setBounds(500,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);

        JLabel exitacc = new JLabel("EXISTING ACCOUNT: ");
        exitacc.setFont(new Font("Times New Roman",Font.BOLD,22));
        exitacc.setBounds(100,590,250,30);
        add(exitacc);

        eyes = new JRadioButton("YES");
        eyes.setFont(new Font("Times New Roman",Font.BOLD,14));
        eyes.setBounds(400,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setFont(new Font("Times New Roman",Font.BOLD,14));
        eno.setBounds(500,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup exitaccgroup = new ButtonGroup();
        exitaccgroup.add(eyes);
        exitaccgroup.add(eno);

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
        //String formno=" "+random;
        String religion= (String)religionval.getSelectedItem();
        
        String category=null;
        if(general.isSelected()){ category="GENERAL";}
        else if(obc.isSelected()){category="OBC";}
        else if(sc.isSelected()){category="SC/ST";}
        
        String income=incometext.getText();
        String qualification= (String)qualificationval.getSelectedItem();
        String mobile=mobiletext.getText();
        String occupation =occupationtext.getText();
        String pan=pantext.getText();
        String adhaar=adhaartext.getText();
        
        String senior=null;     
        if(syes.isSelected()){senior="YES";}
        else if(sno.isSelected()){senior="NO";}
        
        String exist=null;
        if(eyes.isSelected()){exist="YES";}
        else if(eno.isSelected()){exist="NO";}
            
        try
        {
            if(mobile.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Mobile is required");
            }       
            else
            {
                Connect con =new Connect();
                String query ="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"'"
                        + ",'"+qualification+"','"+mobile+"','"+occupation+"','"+pan+"','"+adhaar+"','"+senior+"','"+exist+"')";
                con.stmt.executeUpdate(query);
                setVisible(false);
                new signupthree(formno).setVisible(true);
            }
        }
        catch(SQLException a)
        {
            System.out.println(a);
        }
    }
    public static void main (String [] args)
    {
        new signuptwo("").setVisible(true);
    }
}

