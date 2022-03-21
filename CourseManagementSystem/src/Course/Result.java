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


public class Result extends JFrame {

    private ImageIcon ico_9;
    private JLabel labels_10;
    private JPanel p_77;
    private JPanel p_88,panel_3;
    private JButton button_999,button_18,bt_0;
    @SuppressWarnings("rawtypes")
    private Font ft_9;
    private JTable table0;
    private JTextField tx19;
    private JTextArea area1;


    // function to create frame of application

    public void insap1() {
        setTitle("Result of Student");
        ico_9=new ImageIcon("image/ad.png");
        setIconImage(ico_9.getImage());

        ft_9=new Font("Arial",Font.BOLD,18);
        labels_10=new JLabel("Result of Student");
        labels_10.setBounds(20,10,170,30);
        labels_10.setForeground(Color.WHITE);
        labels_10.setFont(ft_9);
        add(labels_10);

        // back to admin
        button_18=new JButton();
        button_18.setBounds(25,70,190,31);
        button_18.setText("Back");
        add(button_18);
        button_18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {
                Administrator obj = new Administrator();
                // calling function of admin
                obj.controller();
                obj.logn();

                dispose();

            }

        });



        // for panel1
        p_77=new JPanel();
        p_77.setBounds(19,65,199,580);
        p_77.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // for panel2
        p_88=new JPanel();
        p_88.setBounds(210,65,650,580);

        // store table column in string array
        String[] column= {"id","studentname","modulename","modulecode","course","level","semester","marks","remarks"};

        //TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
        //table = new JTable(model);
        table0 = new JTable();
        table0.setModel(model);
        table0.setPreferredScrollableViewportSize(new Dimension(620,450));
        table0.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table0.setFillsViewportHeight(true);
        JScrollPane s12 = new JScrollPane(table0);
        s12.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        s12.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        p_88.add(s12);


        p_88.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));

        tx19= new JTextField();
        tx19.setBounds(230,590,150,31);
        add(tx19);

        // button to search id
        button_999=new JButton("Search ID");
        button_999.setBackground(Color.black);
        button_999.setForeground(Color.white);
        button_999.setBounds(450,590,100,31);
        add(button_999);
        button_999.addActionListener(e->getRe());


        panel_3=new JPanel();
        panel_3.setBounds(850,65,680,580);
        area1 = new JTextArea();
        area1.setEditable(false);
        area1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane_1 = new JScrollPane(area1);
        scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane_1.setPreferredSize(new Dimension(640, 550));
        panel_3.add(scrollPane_1);
        panel_3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));

        // button to prinnt result in textarea
        bt_0=new JButton("Print");
        bt_0.setBackground(Color.black);
        bt_0.setForeground(Color.white);
        bt_0.setBounds(600,590,100,31);
        add(bt_0);
        bt_0.addActionListener(e->areas());


        add(p_77);
        add(p_88);
        add(panel_3);
        setLayout(null);
        setSize(1600,750);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground( Color.darkGray);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit result window");
                System.exit(0);
            }

        });// JFrame exit on close


    }

    // textarea
    public void areas() {
        area1.setText(area1.getText()+"======================================================================================================\n");
        area1.setText(area1.getText()+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+" Result of Student \n");
        area1.setText(area1.getText()+"======================================================================================================\n");
        DefaultTableModel model = (DefaultTableModel) table0.getModel();
        for(int i=0; i<table0.getRowCount(); i++) {
            String id=table0.getValueAt(i,0).toString();
            String name=table0.getValueAt(i,1).toString();
            String mname=table0.getValueAt(i,2).toString();
            String mcode=table0.getValueAt(i,3).toString();
            String cours=table0.getValueAt(i,4).toString();
            String lev1=table0.getValueAt(i,5).toString();
            String sem=table0.getValueAt(i,6).toString();
            String mrk=table0.getValueAt(i,7).toString();
            String rmrk=table0.getValueAt(i,8).toString();
            area1.setText(area1.getText()+"id:"+id+"\n"+"Studentname:"+name+"\n"+"Module Name:"+mname+"\n"+"Module Code:"+mcode+"\n"+"Course:"+cours+"\n"+"Level:"+lev1+"\n"+"Semester:"+sem+"\n"+"Marks:"+mrk+"\n"+"Remarks:"+rmrk+"\n");

        }

        area1.setText(area1.getText()+"\n");
        area1.setText(area1.getText()+"===================================================================================================\n");

    }




    public JTable getTable4() {
        return table0;
    }

    // get student result in table
    public void getRe() {
        String stud_id=tx19.getText(); // textfield to enter student id
        try {

            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
            PreparedStatement ps=conn.prepareStatement("SELECT id FROM marks where id=?"); // select query for id
            ps.setString(1, stud_id);
            ResultSet result=ps.executeQuery();
            boolean bol = false;
            while(result.next()) {


                if (stud_id.equals(result.getString("id"))) {  // check student id from database
                    bol = true;
                    break;

                }
            }
            if(bol) {
                String res = "SELECT * FROM marks WHERE id="+"'"+stud_id+"'";
                PreparedStatement pre = conn.prepareStatement(res);
                ResultSet rs = pre.executeQuery();
                table0.setModel(DbUtils.resultSetToTableModel(rs));
                JOptionPane.showMessageDialog(null," Hurray! Marks of student is shown in table");
            }
            else {
                JOptionPane.showMessageDialog(null,"you type wrong student id");
            }
        }catch(Exception ea) {
            JOptionPane.showMessageDialog(null,ea);

        }

    }



    public static void main(String[]args) {

        Result resul = new Result();
        // calling function of Result class using instance
        resul.insap1();





    }

}
