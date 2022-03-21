package Course;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Administrator  {
    //global scope
    private JFrame frame17;
    private ImageIcon ico9;
    private JLabel label10;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JButton button7,button8,button9,button10,button11,button12,b14,b18,b15,b20,bt30;
    private JTextField txt4,txt5;
    @SuppressWarnings("rawtypes")
    private JComboBox combo6,combos7,combos8;
    private Font fontts9;
    private JTable table12;

    // create frame of  application
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void controller() {
        frame17=new JFrame("Administrator");
        ico9=new ImageIcon("image/ad.png");
        frame17.setIconImage(ico9.getImage());

        fontts9=new Font("Arial",Font.BOLD,18);
        label10=new JLabel("Quick Service");
        label10.setBounds(20,10,170,30);
        label10.setForeground(Color.WHITE);
        label10.setFont(fontts9);
        frame17.add(label10);

        // back button to return to login
        b18=new JButton();
        b18.setBounds(25,70,190,31);
        b18.setText("Back");
        frame17.add(b18);
        b18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                LoginForm obf=new LoginForm();
                obf.App();
                obf.login();
                obf.setVisible(true);
                frame17.setVisible(false);

            }

        });

        // button to enter in teacher add frame
        b15=new JButton();
        b15.setBounds(25,101,190,31);
        b15.setText("Teacher Add");
        frame17.add(b15);
        b15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Teacheradd teachers=new Teacheradd();
                teachers.std();
                teachers.connects();
                teachers.setVisible(true);
                frame17.setVisible(false);

            }

        });
        // button to enter in teacher assign frame
        button8=new JButton();
        button8.setBounds(25,130,190,30);
        button8.setText(" Assign Teacher ");
        frame17.add(button8);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Teacher tch=new Teacher();
                tch.Teach();
                tch.getdata();
                tch.logining();
                tch.fillcombo1();
                tch.fill8();
                frame17.dispose();

            }

        });



        // button to enter in frame to manage course
        b14=new JButton();
        b14.setBounds(25,155,190,31);
        b14.setText("Manage Course");
        frame17.add(b14);
        b14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Course manag1=new Course();
                manag1.std();
                manag1.connects();
                frame17.dispose();

            }

        });

        // button to enter in student details frame to view student
        button7=new JButton();
        button7.setBounds(25,185,190,30);
        button7.setText("Details of student");
        frame17.add(button7);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Details window = new Details();
                frame17.dispose();
                window.setVisible(true);
                window.showwindow();




            }

        });


        // button to enter in result frame to see result slip of student
        bt30=new JButton();
        bt30.setBounds(25,215,190,30);
        bt30.setText("Result");
        frame17.add(bt30);
        bt30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Result resul = new Result();
                frame17.dispose();
                resul.insap1();
                resul.setVisible(true);





            }

        });


        // button to refresh administrator frame
        b20=new JButton();
        b20.setBounds(25,245,190,31);
        b20.setText("Refresh");
        frame17.add(b20);
        b20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Administrator obj = new Administrator();
                obj.controller();
                obj.logn();
                obj.setVisible(true);
                frame17.setVisible(false);


            }

        });



        fontts9=new Font("Arial",Font.BOLD,16);
        label10=new JLabel("Manage module to add-");
        label10.setBounds(225,76,250,30);
        label10.setForeground(Color.BLACK);
        label10.setFont(fontts9);
        frame17.add(label10);


        // text field to enter the module name
        fontts9=new Font("Arial",Font.ITALIC,17);
        label10=new JLabel("Enter Module Name-");
        label10.setBounds(225,140,290,30);
        label10.setForeground(Color.BLACK);
        label10.setFont(fontts9);
        frame17.add(label10);
        txt4=new JTextField();// create TextField  for Username
        txt4.setBounds(225,170,200,20);//TextField
        frame17.add(txt4);

        // text field to enter the module code
        fontts9=new Font("Arial",Font.ITALIC,17);
        label10=new JLabel("Enter the module code-");
        label10.setBounds(550,140,280,30);
        label10.setForeground(Color.BLACK);
        label10.setFont(fontts9);
        frame17.add(label10);
        txt5=new JTextField();// create TextField  for Username
        txt5.setBounds(550,170,200,20);//TextField
        frame17.add(txt5);

        // combobox to select the semester
        fontts9=new Font("Arial",Font.ITALIC,17);
        label10=new JLabel("Select semester to add course-");
        label10.setBounds(225,340,280,30);
        label10.setForeground(Color.BLACK);
        label10.setFont(fontts9);
        frame17.add(label10);
        String[] sem1= {"1","2"};
        combo6 = new JComboBox(sem1);
        combo6.setBounds(225, 370, 200, 30);
        frame17.add(combo6);
        combo6.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ew) {
                System.out.println(combo6.getSelectedItem());

            }

        });

        // combobox to select the course level
        fontts9=new Font("Arial",Font.ITALIC,17);
        label10=new JLabel("Select level to add course-");
        label10.setBounds(550,240,280,30);
        label10.setForeground(Color.BLACK);
        label10.setFont(fontts9);
        frame17.add(label10);

        String[] levels1= {"4","5","6"};
        combos7 = new JComboBox(levels1);
        combos7.setBounds(550, 270, 200, 30);
        frame17.add(combos7);
        combos7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ew) {
                System.out.println(combos7.getSelectedItem());

            }

        });

        // combobox to select the course
        fontts9=new Font("Arial",Font.ITALIC,17);
        label10=new JLabel("Select course-");
        label10.setBounds(225,240,280,30);
        label10.setForeground(Color.BLACK);
        label10.setFont(fontts9);
        frame17.add(label10);
        ArrayList<String> courseName = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://:3306/connec","root","");
            PreparedStatement ps=con.prepareStatement("SELECT course FROM coursemanage ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                courseName.add(rs.getString("course"));
            }
            combos8 = new JComboBox(new DefaultComboBoxModel<String>(courseName.toArray(new String[0])));
            combos8.setBounds(225,270,200,30);
            frame17.add(combos8);
            combos8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(combos8.getSelectedItem());

                }
            });
        }catch (SQLException excep){ // SQLException to catch SQL error
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, excep);
        }


        // button to add course

        button9=new JButton();
        button9.setBounds(225,450,200,30);
        button9.setText("Add");
        button9.setForeground(Color.WHITE);
        button9.setBackground(Color.black);
        frame17.add(button9);

        // button to update

        button10=new JButton();
        button10.setBounds(550,450,200,30);
        button10.setText("Edit");
        button10.setForeground(Color.WHITE);
        button10.setBackground(Color.black);
        frame17.add(button10);


        // button to delete
        button11=new JButton();
        button11.setBounds(225,530,200,30);
        button11.setText("Delete");
        button11.setForeground(Color.WHITE);
        button11.setBackground(Color.black);
        frame17.add(button11);



        // button to clear
        button12=new JButton();
        button12.setBounds(550,530,200,30);
        button12.setText("Clear");
        button12.setForeground(Color.WHITE);
        button12.setBackground(Color.black);
        frame17.add(button12);
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent eer) {

                txt4.setText("");
                txt5.setText("");
            }

        });


        // for panel1
        panel7=new JPanel();
        panel7.setBounds(19,65,199,690);
        panel7.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // for panel2
        panel8=new JPanel();
        panel8.setBounds(210,65,600,690);
        panel8.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));

        // panel3

        panel9=new JPanel();
        panel9.setBounds(800,65,530,690);
        String[] column= {"coursename","modulename","modulecode","course","semester","level"};

        //TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        //table = new JTable(model);
        table12 = new JTable();
        table12.setModel(model);
        table12.setPreferredScrollableViewportSize(new Dimension(500,650));
        JScrollPane scr9 = new JScrollPane(table12);
        scr9.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scr9.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel9.add(scr9);

        panel9.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));

        // fetching data into table
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM course");
            ResultSet rs=ps.executeQuery();
            table12.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception d) {
            JOptionPane.showMessageDialog(null,d);// show message in dialog box of error

        }


        frame17.add(panel7);
        frame17.add(panel8);
        frame17.add(panel9);
        frame17.setLayout(null);
        frame17.setSize(1400,800);
        frame17.setResizable(false);
        frame17.setVisible(true);
        frame17.getContentPane().setBackground( Color.darkGray);
        frame17.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit admin panel");
                System.exit(0);
            }

        });// JFrame exit on close

    }		 // JFrame exit on close



    protected void setVisible(boolean b) {
        // TODO Auto-generated method stub

    }

    // connection set
    public void logn() {
        // button to add course,level,semester,modulname and modulecode
        button9.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver"); // loading driver
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("insert into course(coursename,modulename,modulecode,semester,level)values(?,?,?,?,?)"); // query to insert

                    String col;
                    col=combos8.getSelectedItem().toString();
                    ps.setString(1, col);
                    ps.setString(2, txt4.getText());
                    ps.setString(3, txt5.getText());
                    String sem1;
                    sem1=combo6.getSelectedItem().toString();
                    ps.setString(4, sem1);

                    String levels1;
                    levels1=combos7.getSelectedItem().toString();
                    ps.setString(5, levels1);
                    int x=ps.executeUpdate();


                    if (x>0) {
                        System.out.println("Sucessfully insert");
                    }
                    else {
                        System.out.println("Not successfully inserted");
                    }
                }catch(Exception ee) {
                    System.out.println(ee);
                }


            }

        });

        // button to update course,level,semester,modulname and modulecode
        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("UPDATE course SET coursename=?,modulename=?,modulecode=?,semester=?,level=? WHERE modulename=?");



                    ps.setString(1, txt4.getText());
                    ps.setString(2, txt5.getText());



                    String sem1;
                    sem1=combo6.getSelectedItem().toString();
                    ps.setString(3, sem1);

                    String levels1;
                    levels1=combos7.getSelectedItem().toString();
                    ps.setString(4, levels1);

                    ps.setString(5, txt4.getText());
                    int x=ps.executeUpdate();
                    if (x>0) {
                        System.out.println("Update Successfully");
                    }
                    else {
                        System.out.println("Not updated");
                    }
                }catch(Exception ea) { // catch Exception
                    JOptionPane.showMessageDialog(null,ea.getMessage());

                }


            }

        });
        // button to delete course,level,semester,modulname and modulecode
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("DELETE FROM course where modulename=?");
                    ps.setString(1, txt5.getText());

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


    }

    public static void main(String[]args) {

        Administrator obj = new Administrator();
        // calling function
        obj.controller();
        obj.logn();



    }

}

