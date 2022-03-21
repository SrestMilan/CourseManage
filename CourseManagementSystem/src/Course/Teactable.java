package Course;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;






public class Teactable extends JFrame {
    private ImageIcon ico99;
    private JLabel labe10;
    private JPanel panell7;
    private JPanel panell8;
    private JPanel panell9;
    private JButton butto9,butto18;
    @SuppressWarnings("rawtypes")
    private JComboBox combo,combo7,combo8,combo9,combo10,combo11;
    private Font fontss9;
    private JTable table99;

    // create frame of  application

    public void insap() {
        setTitle("Instructor");
        ico99=new ImageIcon("image/ad.png");
        setIconImage(ico99.getImage());

        fontss9=new Font("Arial",Font.BOLD,18);
        labe10=new JLabel("Teacher Details");
        labe10.setBounds(20,10,170,30);
        labe10.setForeground(Color.WHITE);
        labe10.setFont(fontss9);
        add(labe10);

        // back to student frame
        butto18=new JButton();
        butto18.setBounds(25,70,190,31);
        butto18.setText("Back");
        add(butto18);
        butto18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Student stdent=new Student();
                stdent.std();
                stdent.fillcombo2();
                dispose();

            }

        });



        // for panel1
        panell7=new JPanel();
        panell7.setBounds(19,65,199,580);
        panell7.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // for panel2
        panell8=new JPanel();
        panell8.setBounds(210,65,600,580);

        // storing  column of table using string array
        String[] column= {"userName","modulename","modulecode","course","level","semester"};

        //TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        //table = new JTable(model);
        table99 = new JTable();
        table99.setModel(model);
        table99.setPreferredScrollableViewportSize(new Dimension(570,540));
        table99.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table99.setFillsViewportHeight(true);
        JScrollPane s12 = new JScrollPane(table99);
        s12.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        s12.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panell8.add(s12);
        panell8.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));

        add(panell7);
        add(panell8);

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

        });


    }



    // getter method
    public JTable getTable99() {
        return table99;
    }



    // setter method
    public void setTable99(JTable table99) {
        this.table99 = table99;
    }


    // fetch data into table from database
    public void table1() {
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM teacher"); // select query to fetch data of teacher from database
            ResultSet rs=ps.executeQuery();
            table99.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception d) {
            JOptionPane.showMessageDialog(null,d);// show error message in dialog box

        }

    }


    public static void main(String[]args) { // main method

        Teactable instr = new Teactable();
        // calling function
        instr.insap();
        instr.table1();

    }

}


