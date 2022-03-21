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

import javax.swing.*;


@SuppressWarnings("unused")
public class Course  {

    private JFrame frame_5;
    private ImageIcon icon_34;
    private JLabel labels_6;
    private JPanel pan_7,pan_8;
    private JButton b_9,b_10,b_13,b_14,b_15;
    private JTextField tex_3,tex_4;
    @SuppressWarnings("rawtypes")
    private Font fonts_3;

    // create frame of  application
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void std() {
        frame_5=new JFrame("Course_Manage");
        icon_34=new ImageIcon("image/ad.png");
        frame_5.setIconImage(icon_34.getImage());

        fonts_3=new Font("Arial",Font.BOLD,18);
        labels_6=new JLabel("Quick Service");
        labels_6.setBounds(20,10,170,30);
        labels_6.setForeground(Color.white);
        labels_6.setFont(fonts_3);
        frame_5.add(labels_6);


        // button to back admin
        b_9=new JButton();
        b_9.setBounds(25,62,190,32);
        b_9.setText("Back to admin");
        frame_5.add(b_9);
        b_9.addActionListener(new ActionListener() {
            @Override // override actionPerformed method
            public void actionPerformed(ActionEvent ew) {
                Administrator obj=new Administrator();
                obj.controller();
                obj.logn();
                frame_5.dispose();



            }

        });



        labels_6=new JLabel("ADD COURSE-");
        labels_6.setBounds(232,76,170,30);
        labels_6.setForeground(Color.BLACK);
        labels_6.setFont(fonts_3);
        frame_5.add(labels_6);

        fonts_3=new Font("Arial",Font.ITALIC,17);

        // textfield to add id
        labels_6=new JLabel("ID-");
        labels_6.setBounds(232,140,250,30);
        labels_6.setForeground(Color.BLACK);
        labels_6.setFont(fonts_3);
        frame_5.add(labels_6);
        tex_3=new JTextField();// create TextField  for Username
        tex_3.setBounds(232,170,200,20);//TextField
        frame_5.add(tex_3);


        // textfield to add course
        labels_6=new JLabel("New Course to add-");
        labels_6.setBounds(520,140,290,30);
        labels_6.setForeground(Color.BLACK);
        labels_6.setFont(fonts_3);
        frame_5.add(labels_6);
        tex_4=new JTextField();// create TextField  for Username
        tex_4.setBounds(520,170,200,20);//TextField
        frame_5.add(tex_4);

        // add button
        b_10=new JButton();
        b_10.setBounds(238,230,150,30);
        b_10.setText("ADD");
        b_10.setForeground(Color.WHITE);
        b_10.setBackground(Color.black);
        frame_5.add(b_10);

        // update button
        b_13=new JButton();
        b_13.setBounds(520,230,150,30);
        b_13.setText("Update");
        b_13.setForeground(Color.WHITE);
        b_13.setBackground(Color.black);
        frame_5.add(b_13);


        // delete button
        b_14=new JButton();
        b_14.setBounds(238,280,150,30);
        b_14.setText("Delete");
        b_14.setForeground(Color.WHITE);
        b_14.setBackground(Color.black);
        frame_5.add(b_14);


        // clear button
        b_15=new JButton();
        b_15.setBounds(520,280,150,30);
        b_15.setText("Clear");
        b_15.setForeground(Color.WHITE);
        b_15.setBackground(Color.black);
        frame_5.add(b_15);

        // for panel1
        pan_7=new JPanel();
        pan_7.setBounds(20,55,199,305);
        pan_7.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // for panel2
        pan_8=new JPanel();
        pan_8.setBounds(210,55,550,305);
        pan_8.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));

        frame_5.add(pan_7);
        frame_5.add(pan_8);
        frame_5.setLayout(null);
        frame_5.setSize(800,410);
        frame_5.setResizable(true);
        frame_5.setVisible(true);
        frame_5.getContentPane().setBackground( Color.darkGray);
        frame_5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame exit on close
    }
    public void setVisible(boolean b) {
        // TODO Auto-generated method stub

    }

    public void connects() {

        // button to add id number and courses
        b_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("insert into coursemanage(id,course)values(?,?)");


                    ps.setString(1,tex_3.getText());
                    ps.setString(2,tex_4.getText());




                    int x=ps.executeUpdate();
                    if (x>0) {
                        System.out.println("Sucessfully insert");
                    }
                    else   {
                        System.out.println("Not");
                    }
                }catch(Exception ee) {
                    System.out.println(ee);
                }


            }

        });

        // button to delete id number and courses
        b_14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("DELETE FROM coursemanage where course=?");
                    ps.setString(1, tex_4.getText());


                    int x=ps.executeUpdate();
                    if (x>0) {
                        System.out.println("Delete successfully");
                    }
                    else {
                        System.out.println("Not");
                    }
                }catch(Exception eex) {
                    JOptionPane.showMessageDialog(null,eex.getMessage());
                }

            }

        });

        // button to update id number and courses
        b_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("UPDATE coursemanage SET id=?,course=? WHERE id=?");// query to update



                    ps.setString(1, tex_3.getText());
                    ps.setString(2, tex_4.getText());

                    ps.setString(3, tex_3.getText());




                    int x=ps.executeUpdate();
                    if (x>0) {
                        System.out.println("Update Successfully");
                    }
                    else {
                        System.out.println("Not");
                    }
                }catch(Exception ea) {
                    JOptionPane.showMessageDialog(null,ea.getMessage());

                }

            }

        });


    }

    public static void main(String[]args) {
        Course manag1=new Course();
        // calling function using instance of class
        manag1.std();
        manag1.connects();

    }

}