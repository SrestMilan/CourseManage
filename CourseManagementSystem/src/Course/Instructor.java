package Course;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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






public class Instructor extends JFrame {
    private ImageIcon icos_1;
    private JLabel labelss_10;
    private JPanel panelss_7;
    private JPanel panelss_8;
    private JButton button_9,button_18;
    @SuppressWarnings("rawtypes")
    private JComboBox combo_11,combo77,combo88,combo99,combo101,combo111;
    private Font fonnts9;


    // create frame of application

    public void insappp() {
        setTitle("Instructor");
        icos_1=new ImageIcon("image/ad.png");
        setIconImage(icos_1.getImage());

        fonnts9=new Font("Arial",Font.BOLD,18);
        labelss_10=new JLabel("Quick Service");
        labelss_10.setBounds(20,10,170,30);
        labelss_10.setForeground(Color.WHITE);
        labelss_10.setFont(fonnts9);
        add(labelss_10);

        // button to login
        button_18=new JButton();
        button_18.setBounds(25,70,190,31);
        button_18.setText("Back");
        add(button_18);
        button_18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                LoginForm obf=new LoginForm();
                obf.App();
                obf.login();
                obf.setVisible(true);
                setVisible(false);

            }

        });

        // button to enter to teachname frame
        button_9=new JButton();
        button_9.setBounds(25,100,190,31);
        button_9.setText("Enter Instructorname Panel");
        add(button_9);
        button_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Tid ins = new Tid();
                ins.insid();

                ins.setVisible(true);
                setVisible(false);

            }

        });




        fonnts9=new Font("Arial",Font.BOLD,16);
        labelss_10=new JLabel("Teacher Details-");
        labelss_10.setBounds(225,76,250,30);
        labelss_10.setForeground(Color.BLACK);
        labelss_10.setFont(fonnts9);
        add(labelss_10);


        // combobox to select teachername
        fonnts9=new Font("Arial",Font.ITALIC,17);
        labelss_10=new JLabel("Teacher Name-");
        labelss_10.setBounds(225,140,290,30);
        labelss_10.setForeground(Color.BLACK);
        labelss_10.setFont(fonnts9);
        add(labelss_10);
        String name[]= {};
        combo_11=new JComboBox();// create TextField  for Username
        combo_11.setBounds(225,170,200,30);//TextField
        add(combo_11);
        combo_11.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String name=combo_11.getSelectedItem().toString();
                String sql="Select * from teacher where userName='"+name+"'"; // select query to select teachername
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://:3306/connec","root",""); // drivermanager to connect localhost
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ResultSet rs=ps.executeQuery();
                    // automatically select item of other combobox by selecting teachername
                    while(rs.next()) {
                        combo77.setSelectedItem(rs.getString("modulename"));
                        combo88.setSelectedItem(rs.getString("modulecode"));
                        combo99.setSelectedItem(rs.getString("course"));
                        combo101.setSelectedItem(rs.getString("level"));
                        combo111.setSelectedItem(rs.getString("semester"));
                    }
                }catch(SQLException ed) { // SQL Exception
                    Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ed);
                }

            }
        });


        // combobox for modulename
        fonnts9=new Font("Arial",Font.ITALIC,17);
        labelss_10=new JLabel("Module Name-");
        labelss_10.setBounds(550,140,280,30);
        labelss_10.setForeground(Color.BLACK);
        labelss_10.setFont(fonnts9);
        add(labelss_10);
        combo77=new JComboBox();// create TextField  for Username
        combo77.setBounds(550,170,200,30);//TextField
        add(combo77);

        // combobox for modulecode
        fonnts9=new Font("Arial",Font.ITALIC,17);
        labelss_10=new JLabel("Module Code-");
        labelss_10.setBounds(225,240,280,30);
        labelss_10.setForeground(Color.BLACK);
        labelss_10.setFont(fonnts9);
        add(labelss_10);

        combo88=new JComboBox();// create TextField  for Username
        combo88.setBounds(225,270,200,30);//TextField
        add(combo88);

        // combobox for course
        fonnts9=new Font("Arial",Font.ITALIC,17);
        labelss_10=new JLabel("Course-");
        labelss_10.setBounds(550,240,280,30);
        labelss_10.setForeground(Color.BLACK);
        labelss_10.setFont(fonnts9);
        add(labelss_10);
        combo99=new JComboBox();// create TextField  for Username
        combo99.setBounds(550,270,200,30);//TextField
        add(combo99);

        // combobox for level
        fonnts9=new Font("Arial",Font.ITALIC,17);
        labelss_10=new JLabel("Level-");
        labelss_10.setBounds(225,340,280,30);
        labelss_10.setForeground(Color.BLACK);
        labelss_10.setFont(fonnts9);
        add(labelss_10);
        combo101=new JComboBox();// create TextField  for Username
        combo101.setBounds(225,370,200,30);//TextField
        add(combo101);

        // combobox for semester
        labelss_10=new JLabel("Semester-");
        labelss_10.setBounds(550,340,280,30);
        labelss_10.setForeground(Color.BLACK);
        labelss_10.setFont(fonnts9);
        add(labelss_10);
        combo111=new JComboBox();// create TextField  for Username
        combo111.setBounds(550,370,200,30);//TextField
        add(combo111);



        // for panel1
        panelss_7=new JPanel();
        panelss_7.setBounds(19,65,199,580);
        panelss_7.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // for panel2
        panelss_8=new JPanel();
        panelss_8.setBounds(210,65,600,580);
        panelss_8.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        add(panelss_7);
        add(panelss_8);

        setLayout(null);
        setSize(860,750);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground( Color.darkGray);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit instructor panel");
                System.exit(0);
            }

        });// JFrame exit on close

        // JFrame exit on close
    }


    // fetch data into combobox from database using select query
    public void fillcombo9() {

        try {
            Connection connects = DriverManager.getConnection("jdbc:mysql://:3306/connec","root","");
            Statement stat_ment = connects.createStatement();
            ResultSet r_set = stat_ment.executeQuery("select * from teacher ");
            while(r_set.next()){
                combo_11.addItem(r_set.getString("userName"));
                combo77.addItem(r_set.getString("modulename"));
                combo88.addItem(r_set.getString("modulecode"));
                combo99.addItem(r_set.getString("course"));
                combo101.addItem(r_set.getString("level"));
                combo111.addItem(r_set.getString("semester"));


            }
        } catch(SQLException aw) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, aw);

        }

    }


    public static void main(String[]args) {

        Instructor insr = new Instructor();
        // calling function using instance of class
        insr.insappp();
        insr.fillcombo9();



    }

}


