package Course;




import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;



public class Teacheradd  {

    private JFrame framess_5;
    private ImageIcon icon_35;
    private JLabel labelss_6;
    private JPanel panels_7,panels_8;
    private JButton bt_9,bt_10,bt_13,bt_14,bt_15;
    private JTextField texs_3,texs_4;
    private Font fonts_33;


    // create frame of  application
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void std() {
        framess_5=new JFrame("Course_Manage");
        icon_35=new ImageIcon("image/ad.png");
        framess_5.setIconImage(icon_35.getImage());

        fonts_33=new Font("Arial",Font.BOLD,18);
        labelss_6=new JLabel("Quick Service");
        labelss_6.setBounds(20,10,170,30);
        labelss_6.setForeground(Color.white);
        labelss_6.setFont(fonts_33);
        framess_5.add(labelss_6);


        // button to return admin frame
        bt_9=new JButton();
        bt_9.setBounds(25,62,190,32);
        bt_9.setText("Back to admin");
        framess_5.add(bt_9);
        bt_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Administrator obj=new Administrator();
                obj.controller();
                obj.logn();
                framess_5.dispose();



            }

        });



        labelss_6=new JLabel("Teacher add-");
        labelss_6.setBounds(232,76,170,30);
        labelss_6.setForeground(Color.BLACK);
        labelss_6.setFont(fonts_33);
        framess_5.add(labelss_6);

        fonts_33=new Font("Arial",Font.ITALIC,17);

        // textfield for id
        labelss_6=new JLabel("ID-");
        labelss_6.setBounds(232,140,250,30);
        labelss_6.setForeground(Color.BLACK);
        labelss_6.setFont(fonts_33);
        framess_5.add(labelss_6);
        texs_3=new JTextField();// create TextField  for Username
        texs_3.setBounds(232,170,200,20);//TextField
        framess_5.add(texs_3);


        // textfield to add teachername
        labelss_6=new JLabel("New teacher to add-");
        labelss_6.setBounds(520,140,290,30);
        labelss_6.setForeground(Color.BLACK);
        labelss_6.setFont(fonts_33);
        framess_5.add(labelss_6);
        texs_4=new JTextField();// create TextField  for Username
        texs_4.setBounds(520,170,200,20);//TextField
        framess_5.add(texs_4);

        // button to add teachername
        bt_10=new JButton();
        bt_10.setBounds(238,230,150,30);
        bt_10.setText("ADD");
        bt_10.setForeground(Color.WHITE);
        bt_10.setBackground(Color.black);
        framess_5.add(bt_10);

        // button to update teachername
        bt_13=new JButton();
        bt_13.setBounds(520,230,150,30);
        bt_13.setText("Update");
        bt_13.setForeground(Color.WHITE);
        bt_13.setBackground(Color.black);
        framess_5.add(bt_13);

        // button to delete
        bt_14=new JButton();
        bt_14.setBounds(238,280,150,30);
        bt_14.setText("Delete");
        bt_14.setForeground(Color.WHITE);
        bt_14.setBackground(Color.black);
        framess_5.add(bt_14);

        // button to clear textfield
        bt_15=new JButton();
        bt_15.setBounds(520,280,150,30);
        bt_15.setText("Clear");
        bt_15.setForeground(Color.WHITE);
        bt_15.setBackground(Color.black);
        framess_5.add(bt_15);


        // for panel1
        panels_7=new JPanel();
        panels_7.setBounds(20,55,199,305);
        panels_7.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // for panel2
        panels_8=new JPanel();
        panels_8.setBounds(210,55,550,305);
        panels_8.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        framess_5.add(panels_7);// adding panels_7 in frame
        framess_5.add(panels_8);// adding panels_7 in frame
        framess_5.setLayout(null);
        framess_5.setSize(800,410);
        framess_5.setResizable(true);
        framess_5.setVisible(true);
        framess_5.getContentPane().setBackground( Color.darkGray);
        framess_5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame exit on close
    }
    public void setVisible(boolean b) {
        // TODO Auto-generated method stub

    }

    // connection for database using several button such as add delete, update,add
    public void connects() {
        bt_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("insert into teacheradd(id,userName)values(?,?)");


                    ps.setString(1,texs_3.getText());
                    ps.setString(2,texs_4.getText());




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

        bt_14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("DELETE FROM teacheradd where userName=?");
                    ps.setString(1, texs_4.getText());


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

        bt_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("UPDATE teacheradd SET id=?,userName=? WHERE id=?");



                    ps.setString(1, texs_3.getText());
                    ps.setString(2, texs_4.getText());

                    ps.setString(3, texs_3.getText());




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
        Teacheradd teachers=new Teacheradd();
        // calling function of Teacheradd class using instance
        teachers.std();
        teachers.connects();

    }

}