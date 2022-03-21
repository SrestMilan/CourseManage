package Course;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// create a users class




public class Details  {
    private JFrame frame5;
    private JPanel p10;
    private JButton buttn;
    private JTable table = new JTable();


    // function to create frame of student details
    public void showwindow() {
        frame5=new JFrame();
        frame5.setTitle("Details");
        buttn=new JButton();
        buttn.setBounds(25,20,150,30);
        buttn.setText("Back");
        buttn.setBackground(Color.black);
        buttn.setForeground(Color.white);
        frame5.add(buttn);


        // button to return administator
        buttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Administrator obj=new Administrator();
                obj.controller();
                obj.logn();
                frame5.dispose();

            }

        });


        // panel for table
        p10 = new JPanel();
        p10.setBounds(100,70,650,570);
        String[] column= {"id","studentname","address","course","level","semester"};
        table = new JTable();

        // default  table model inside panel
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(630,520)); // dimension of table
        JScrollPane scroll9 = new JScrollPane(table);
        scroll9.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll9.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        p10.add(scroll9);
        p10.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN)); // border of panel

        // fetching data into table through database
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM student");
            ResultSet rs=ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception d) { // catch Exception
            JOptionPane.showMessageDialog(null,d);

        }


        frame5.add(p10);
        frame5.setLayout(null);
        frame5.setSize(900,700);
        frame5.setResizable(false);
        frame5.setVisible(true);
        frame5.getContentPane().setBackground( Color.darkGray);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame exit on close


    }
    public static void main(String[] args){
        Details window = new Details();
        //calling function
        window.showwindow();



    }
    public void setVisible(boolean b) {
        // TODO Auto-generated method stub

    }
}
