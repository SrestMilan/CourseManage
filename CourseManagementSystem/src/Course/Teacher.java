package Course;



import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Teacher  {
    private JFrame frame12;
    private ImageIcon ico;
    private JLabel l2;
    private JPanel panels34,p3;
    private JTextField field9,f10,f11;
    @SuppressWarnings("rawtypes")
    private JComboBox c4,c5,c6,c7,c9;
    private JTable t2;
    private Font f1;
    private JButton b1,b2,b3,b4,b5;
    private String id;

    // create frame of application
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void Teach() {
        frame12=new JFrame("Teacher Assign");
        ico=new ImageIcon("image/ins.png");
        frame12.setIconImage(ico.getImage());


        f1=new Font("Arial",Font.BOLD,17);
        l2=new JLabel("Assign Teacher");
        l2.setBounds(20,10,170,30);
        l2.setForeground(Color.WHITE);
        l2.setFont(f1);
        frame12.add(l2);


        // selection of ID
        f1=new Font("Arial",Font.BOLD,17);
        l2=new JLabel("ID");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(40,39,150,100);
        frame12.add(l2);
        String [] tid= {};
        c7=new JComboBox(tid);
        c7.setBounds(40, 110, 190, 30);
        frame12.add(c7);
        c7.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String tid=c7.getSelectedItem().toString();
                String sql="Select * from teacheradd where id='"+tid+"'"; // select query
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()) {
                        c9.setSelectedItem(rs.getString("userName"));  // change username according to id

                    }
                }catch(SQLException ed) {  // SQL exception
                    Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ed);
                }

            }
        });


        // selection of teachername
        f1=new Font("Arial",Font.BOLD,17);
        l2=new JLabel("Teacher Name");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(380,39,150,100);
        frame12.add(l2);
        String [] tname= {};
        c9=new JComboBox(tname);
        c9.setBounds(380, 110, 190, 30);
        frame12.add(c9);


        // textfield to write modulename
        l2=new JLabel("Modulename");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(380,120,150,100);
        frame12.add(l2);
        f10=new JTextField();
        f10.setBounds(380,200,190,30);
        frame12.add(f10);


        // textfield to write modulecode
        l2=new JLabel("Modulecode:");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(40,220,110,100);
        frame12.add(l2);
        f11=new JTextField();
        f11.setBounds(40,300,190,30);
        frame12.add(f11);

        // selection of course
        l2=new JLabel("Course");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(40,120,150,100);
        frame12.add(l2);
        String[]chos= {};
        c4 = new JComboBox(chos);
        c4.setBounds(40,200,190,30);
        frame12.add(c4);



        // selection of level
        l2=new JLabel("Level:");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(380,220,110,100);
        frame12.add(l2);
        String[]levll1= {"4","5","6"};
        c5 = new JComboBox(levll1);
        c5.setBounds(380,300,190,30);
        frame12.add(c5);
        c5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ew) {
                System.out.println(c5.getSelectedItem());

            }

        });

        // selection of semester
        l2=new JLabel("Semester:");
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        l2.setBounds(40,320,110,100);
        frame12.add(l2);
        String[] sem0= {"1","2"};
        c6 = new JComboBox(sem0);
        c6.setBounds(40,400,190,30);
        frame12.add(c6);
        c6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ew) {
                System.out.println(c6.getSelectedItem());

            }

        });


        panels34=new JPanel();
        panels34.setBounds(19,65,600,690);
        panels34.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        p3=new JPanel();
        p3.setBounds(550,65,800,690);
        String[] column= {"id","userName","modulename","modulecode","course","level","semester"};


        // creating default table mode in panel
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        t2 = new JTable();
        t2.setModel(model);
        t2.setPreferredScrollableViewportSize(new Dimension(590,650));
        t2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        t2.setFillsViewportHeight(true);
        JScrollPane s1 = new JScrollPane(t2);
        s1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        s1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        p3.add(s1);
        p3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // assign teacher
        b1=new JButton("ADD");
        b1.setBounds(80,500,150,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        frame12.add(b1);


        // delete teacher
        b2=new JButton("Delete");
        b2.setBounds(390,500,150,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        frame12.add(b2);


        // back button to admin
        b3=new JButton("Back");
        b3.setBounds(1200,30,150,30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.black);
        frame12.add(b3);


        // update button
        b4=new JButton("Update");
        b4.setBounds(80,570,150,30);
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.black);
        frame12.add(b4);

        // clear button
        b5=new JButton("Clear");
        b5.setBounds(390,570,150,30);
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.black);
        frame12.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent eer) {

                // clear textfield
                f10.setText("");
                f11.setText("");
            }

        });




        // return to administrator class
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Administrator obj=new Administrator();
                obj.controller();
                obj.logn();



                frame12.dispose();

            }

        });

        frame12.add(panels34);
        frame12.add(p3);
        frame12.setLayout(null);
        frame12.setSize(1400,800);
        frame12.setResizable(false);
        frame12.setVisible(true);
        frame12.getContentPane().setBackground( Color.darkGray);
        frame12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame exit on close
    }




    public String getId() {
        return id;
    }




    public void setId(String id) {
        this.id = id;
    }



    // fetch data in table from database connec
    public void getdata() {
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM teacher");
            ResultSet rs=ps.executeQuery();
            t2.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception d) {
            JOptionPane.showMessageDialog(null,d);

        }


    }

    public void logining() {

        // for assigning teacher
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("insert into teacher(id,userName,modulename,modulecode,course,level,semester)values(?,?,?,?,?,?,?)");

                    String tid;
                    tid=c7.getSelectedItem().toString();
                    ps.setString(1,tid);



                    String tname;
                    tname=c9.getSelectedItem().toString();
                    ps.setString(2,tname);

                    ps.setString(3, f10.getText());
                    ps.setString(4, f11.getText());

                    String chos;
                    chos=c4.getSelectedItem().toString();
                    ps.setString(5, chos);

                    String levll1;
                    levll1=c5.getSelectedItem().toString();
                    ps.setString(6, levll1);

                    String sem0;
                    sem0=c6.getSelectedItem().toString();
                    ps.setString(7, sem0);


                    int x=ps.executeUpdate();
                    if (x>0) {
                        System.out.println("Sucessfully isert");
                    }
                    else {
                        System.out.println("Not");
                    }
                }catch(Exception ee) {
                    System.out.println(ee);
                }
                getdata();


            }

        });

        // for deleting teacher according to modulecode
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("DELETE FROM teacher where modulecode=?");

                    ps.setString(1, f11.getText());

                    int y=ps.executeUpdate();
                    if (y>0) {
                        System.out.println("Delete successfully");
                    }
                    else {
                        System.out.println("Not");
                    }
                }catch(Exception ax) {
                    JOptionPane.showMessageDialog(null,ax.getMessage());
                }
                getdata();

            }

        });

        // for updating teacher to assign
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("UPDATE teacher SET id=?,userName=?,modulename=?,modulecode=?,course=?,level=?,semester=? where modulecode=?");

                    String tid;
                    tid=c7.getSelectedItem().toString();
                    ps.setString(1,tid);

                    String tname;
                    tname=c9.getSelectedItem().toString();
                    ps.setString(2,tname);
                    ps.setString(3, f10.getText());
                    ps.setString(4, f11.getText());

                    String chos;
                    chos=c4.getSelectedItem().toString();
                    ps.setString(5, chos);

                    String levll1;
                    levll1=c5.getSelectedItem().toString();
                    ps.setString(6, levll1);

                    String sem0;
                    sem0=c6.getSelectedItem().toString();
                    ps.setString(7, sem0);

                    ps.setString(8, f11.getText());


                    int x=ps.executeUpdate();
                    if (x>0) {
                        System.out.println("Update Sucessfully");
                    }
                    else {
                        System.out.println("Not");
                    }
                }catch(Exception ee) {
                    System.out.println(ee);
                }
                getdata();


            }

        });


    }


    // fetching data in combobox from database using select query
    public void fillcombo1() {

        try {
            Connection connects = DriverManager.getConnection("jdbc:mysql://:3306/connec","root","");
            Statement stat_ment = connects.createStatement();
            ResultSet r_set = stat_ment.executeQuery("select * from coursemanage");
            while(r_set.next()){
                c4.addItem(r_set.getString("course"));



            }
        } catch(SQLException aw) { // catch exception
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, aw);

        }

    }
    // fetching data in combobox from database using select query
    public void fill8() {

        try {
            Connection connects = DriverManager.getConnection("jdbc:mysql://:3306/connec","root","");
            Statement stat_ment = connects.createStatement();
            ResultSet r_set = stat_ment.executeQuery("select * from teacheradd");
            while(r_set.next()){
                c7.addItem(r_set.getString("id"));
                c9.addItem(r_set.getString("userName"));




            }
        } catch(SQLException aw) { // catch exception
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, aw);

        }

    }


    public static void main(String[]args) {
        Teacher tch=new Teacher();
        // calling function of class using instance
        tch.Teach();
        tch.getdata();
        tch.logining();
        tch.fillcombo1();
        tch.fill8();

    }

}