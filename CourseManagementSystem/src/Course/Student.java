package Course;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Student  {
    // global scope
    private JFrame f4;
    private ImageIcon ico19;
    private JLabel labels10,labels11;
    private JPanel p_7,p_8;
    private JButton buttn9,bt13,bt14;
    private JTextField tex3,tx7,tx9;
    @SuppressWarnings("rawtypes")
    private JComboBox cbo6,combos9,combos10;
    private Font fonts19;
    private JTable t11;


    //create frame of application
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void std() {
        f4=new JFrame("Student");
        ico19=new ImageIcon("image/ad.png");
        f4.setIconImage(ico19.getImage());

        fonts19=new Font("Arial",Font.BOLD,18);
        labels10=new JLabel("Quick Service");
        labels10.setBounds(20,10,170,30);
        labels10.setForeground(Color.white);
        labels10.setFont(fonts19);
        f4.add(labels10);


        // back button

        bt13=new JButton();
        bt13.setBounds(35,65,190,30);
        bt13.setText("Back");
        f4.add(bt13);
        bt13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                LoginForm obf=new LoginForm();
                obf.App();
                obf.login();
                f4.dispose();



            }

        });

        // button for teacher details
        bt14=new JButton();
        bt14.setBounds(35,96,190,30);
        bt14.setText("Teacher Details");
        f4.add(bt14);
        bt14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ews) {
                Teactable instr = new Teactable();
                instr.insap();
                instr.table1();
                f4.dispose();

            }

        });


        // label for enrollment
        labels11=new JLabel("Student Enroll:");
        labels11.setBounds(235,76,300,30);
        labels11.setForeground(Color.BLACK);
        labels11.setFont(fonts19);
        f4.add(labels11);

/*************************************************************************************/
        // student ID
        fonts19=new Font("Arial",Font.ITALIC,17);
        labels10=new JLabel("ID-");
        labels10.setBounds(235,120,280,30);
        labels10.setForeground(Color.BLACK);
        labels10.setFont(fonts19);
        f4.add(labels10);
        tex3=new JTextField();
        tex3.setBounds(235,150,190,30);
        f4.add(tex3);
/**************************************************************************************/

/***************************************************************************************/
        // student name
        labels10=new JLabel("Student Name-");
        labels10.setBounds(560,120,280,30);
        labels10.setForeground(Color.BLACK);
        labels10.setFont(fonts19);
        f4.add(labels10);
        tx7=new JTextField();
        tx7.setBounds(560,150,190,30);
        f4.add(tx7);


        // student address
        labels10=new JLabel("Address-");
        labels10.setBounds(235,210,280,30);
        labels10.setForeground(Color.BLACK);
        labels10.setFont(fonts19);
        f4.add(labels10);
        tx9=new JTextField();
        tx9.setBounds(235,240,190,30);
        f4.add(tx9);

        // selection of course
        fonts19=new Font("Arial",Font.ITALIC,17);
        labels10=new JLabel("Select course-");
        labels10.setBounds(560,210,280,30);
        labels10.setForeground(Color.BLACK);
        labels10.setFont(fonts19);
        f4.add(labels10);
        String[]types= {};
        cbo6 = new JComboBox(types);
        cbo6.setBounds(560,240,190,30);
        f4.add(cbo6);



        // for level of studies
        labels10=new JLabel("Select level-");
        labels10.setBounds(235,310,280,30);
        labels10.setForeground(Color.BLACK);
        labels10.setFont(fonts19);
        f4.add(labels10);
        String[]lvl10= {"4","5","6"};
        combos9 = new JComboBox(lvl10);
        combos9.setBounds(235,340,190,30);
        f4.add(combos9);



        // selection of semester
        labels10=new JLabel("Select Semester-");
        labels10.setBounds(560,310,280,30);
        labels10.setForeground(Color.BLACK);
        labels10.setFont(fonts19);
        f4.add(labels10);
        String[]sem7= {"1","2"};
        combos10 = new JComboBox(sem7);
        combos10.setBounds(560,340,190,30);
        f4.add(combos10);



/*********************************************************************/

        // button for enrollment
        bt13=new JButton();
        bt13.setBounds(400,450,150,30);
        bt13.setBackground(Color.black);
        bt13.setText("Enroll");
        bt13.setForeground(Color.white);
        f4.add(bt13);
        bt13.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("insert into student(id,studentname,address,course,level,semester)values(?,?,?,?,?,?)");


                    ps.setString(1, tex3.getText());
                    ps.setString(2, tx7.getText());
                    ps.setString(3, tx9.getText());
                    String types;
                    types=cbo6.getSelectedItem().toString();
                    ps.setString(4, types);

                    String lvl10;
                    lvl10=combos9.getSelectedItem().toString();
                    ps.setString(5, lvl10);

                    String sem7;
                    sem7=combos10.getSelectedItem().toString();
                    ps.setString(6, sem7);
                    int x=ps.executeUpdate();


                    if (x>0) {
                        System.out.println("Sucessfully insert");
                    }
                    else{
                        System.out.println("Already existed");
                    }
                }catch(Exception s) {
                    System.out.println(s);
                }


            }

        });



/********************************************************/


        // for panel1
        p_7=new JPanel();
        p_7.setBounds(30,55,199,550);
        p_7.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // for panel2
        p_8=new JPanel();
        p_8.setBounds(220,55,610,550);
        p_8.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));





        f4.add(p_7);
        f4.add(p_8);
        f4.setLayout(null);
        f4.setSize(920,700); // size of frame
        f4.setResizable(false);
        f4.setVisible(true);
        f4.getContentPane().setBackground( Color.darkGray);// background of frame
        f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame exit on close
    }
    public void setVisible(boolean b) {
        // TODO Auto-generated method stub

    }

    // adding items in combobox from database by using select query
    public void fillcombo2() {

        try {
            Connection connects = DriverManager.getConnection("jdbc:mysql://:3306/connec","root","");
            Statement stat_ment = connects.createStatement();
            ResultSet r_set = stat_ment.executeQuery("select * from coursemanage"); // select query to fetch course from database
            while(r_set.next()){
                cbo6.addItem(r_set.getString("course"));


            }
        } catch(SQLException aw) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, aw);

        }

    }
    public static void main(String[]args) {
        Student stdent=new Student();
        // calling function of class using instance
        stdent.std();
        stdent.fillcombo2();


    }


}

