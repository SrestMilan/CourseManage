package Course;




import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.awt.Dimension;
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
import javax.swing.table.DefaultTableModel;


// class table

class Table4{
    private String id,studentname,modulename,modulecode,course,level,semester,marks,remarks;

    public Table4(String id,String studentname,String modulename,String modulecode, String course,String level,String semester,String marks,String remarks){
        this.id=id;
        this.studentname = studentname;
        this.modulename = modulename;
        this.modulecode=modulecode;
        this.course=course;
        this.level = level;
        this.semester = semester;
        this.marks = marks;
        this.remarks = remarks;
    }
    public String getid() {
        return this.id;
    }
    public String studentname(){
        return this.studentname;
    }



    public String getmodulename(){
        return this.modulename;
    }

    public String getmodulecode(){
        return this.modulecode;
    }

    public String getcours(){
        return this.course;
    }

    public String getlevel(){
        return this.level;
    }

    public String getsem(){
        return this.semester;
    }

    public String getmarks(){
        return this.marks;
    }

    public String getrem(){
        return this.remarks;
    }


}

public class Marks  {
    private JFrame frame197;
    private ImageIcon ico90;
    private JLabel labl10;
    private JPanel panl7;
    private JPanel panl8;
    private JPanel panl9;
    private JButton buutton9,buutton10,buutton11,buutton12,b120;
    private JTextField texs_1,texs_2,texs_3,texs_4;
    @SuppressWarnings("rawtypes")
    private JComboBox co1,co2,co3,co4,co5;
    private Font foonts9;
    private JTable table122;



    // create frame of application
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void controller(String teachname) {
        frame197=new JFrame("Marks");
        ico90=new ImageIcon("image/ad.png");
        frame197.setIconImage(ico90.getImage());

        foonts9=new Font("Arial",Font.BOLD,18);
        labl10=new JLabel("Marks of Students-");
        labl10.setBounds(20,10,170,30);
        labl10.setForeground(Color.WHITE);
        labl10.setFont(foonts9);
        frame197.add(labl10);

        // refresh button
        b120=new JButton();
        b120.setBounds(25,70,190,31);
        b120.setText("Refresh");
        frame197.add(b120);
        b120.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ew) {

                Marks mark1 = new Marks();
                // function call
                mark1.controller(teachname);
                mark1.markslogn();
                mark1.filcombo();
                mark1.setVisible(true);
                frame197.setVisible(false);


            }

        });



        foonts9=new Font("Arial",Font.BOLD,16);
        labl10=new JLabel("Manage Marks of Student-");
        labl10.setBounds(225,76,250,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);


        // select id of students
        foonts9=new Font("Arial",Font.ITALIC,17);
        labl10=new JLabel("ID-");
        labl10.setBounds(225,140,290,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);
        String [] id1={};
        co1=new JComboBox(id1);
        co1.setBounds(225,170,200,30);//TextField
        frame197.add(co1);

        // select combo item through which other combo items changes
        co1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String id1=co1.getSelectedItem().toString();
                String sql="Select * from student where id='"+id1+"'";  // select query
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://:3306/connec","root",""); // connection of local host
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ResultSet r_set=ps.executeQuery();
                    while(r_set.next()) {
                        co2.setSelectedItem(r_set.getString("studentname"));
                        co3.setSelectedItem(r_set.getString("course"));
                        co4.setSelectedItem(r_set.getString("level"));
                        co5.setSelectedItem(r_set.getString("semester"));
                    }
                }catch(SQLException ed) {   // catch SQL Exception
                    Logger.getLogger(Marks.class.getName()).log(Level.SEVERE, null, ed);
                }

            }
        });




        foonts9=new Font("Arial",Font.ITALIC,17);
        labl10=new JLabel("Studenname");
        labl10.setBounds(550,140,280,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);

        // combobox for studentname
        String[] stname= {};
        co2=new JComboBox(stname);
        co2.setBounds(550,170,200,30);//TextField
        frame197.add(co2);


        // textfield for modulename
        foonts9=new Font("Arial",Font.ITALIC,17);
        labl10=new JLabel("Modulename");
        labl10.setBounds(225,240,280,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);
        texs_1=new JTextField();
        texs_1.setBounds(225,270,200,30);
        frame197.add(texs_1);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/connec","root","");// connection of localhost
            PreparedStatement ps = con.prepareStatement("select modulename from teacher where userName=?"); // select query
            ps.setString(1, teachname);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                texs_1.setText(rs.getString("modulename"));

            }
        }
        catch(ClassNotFoundException | SQLException e) // catch Exception
        {
            System.out.println(e); // print in console
        }

        // textfield for modulecode
        labl10=new JLabel("Modulecode");
        labl10.setBounds(550,240,280,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);
        texs_2=new JTextField();
        texs_2.setBounds(550,270,200,30);
        frame197.add(texs_2);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/connec","root","");
            PreparedStatement ps = con.prepareStatement("select modulecode from teacher where userName=?");
            ps.setString(1, teachname);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                texs_2.setText(rs.getString("modulecode"));

            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }




        foonts9=new Font("Arial",Font.ITALIC,17);
        labl10=new JLabel("Course-");
        labl10.setBounds(225,340,280,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);
        // combobox for course
        String[] cors= {};
        co3 = new JComboBox(cors);
        co3.setBounds(225, 370, 200, 30);
        frame197.add(co3);


        labl10=new JLabel("Level-");
        labl10.setBounds(550,340,280,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);
        // combobox for level
        String[] lv1= {};
        co4 = new JComboBox(lv1);
        co4.setBounds(550, 370, 200, 30);
        frame197.add(co4);


        labl10=new JLabel("Semester-");
        labl10.setBounds(225,440,280,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);

        String[] se3= {};
        co5 = new JComboBox(se3); // combobox for semester
        co5.setBounds(225, 470, 200, 30);
        frame197.add(co5);


        // marks textfield
        labl10=new JLabel("Marks-");
        labl10.setBounds(550,440,280,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);

        texs_3=new JTextField();
        texs_3.setBounds(550,470,200,30);
        frame197.add(texs_3);

        // remarks textfield given to student
        labl10=new JLabel("Remarks-");
        labl10.setBounds(225,540,200,30);
        labl10.setForeground(Color.BLACK);
        labl10.setFont(foonts9);
        frame197.add(labl10);
        texs_4=new JTextField();
        texs_4.setBounds(225,570,200,30);
        frame197.add(texs_4);



        // add button
        buutton9=new JButton();
        buutton9.setBounds(300,650,150,30);
        buutton9.setText("Add");
        buutton9.setForeground(Color.WHITE);
        buutton9.setBackground(Color.black);
        frame197.add(buutton9);


        // edit button
        buutton10=new JButton();
        buutton10.setBounds(550,650,150,30);
        buutton10.setText("Edit");
        buutton10.setForeground(Color.WHITE);
        buutton10.setBackground(Color.black);
        frame197.add(buutton10);
        // delete button
        buutton11=new JButton();
        buutton11.setBounds(300,700,150,30);
        buutton11.setText("Delete");
        buutton11.setForeground(Color.WHITE);
        buutton11.setBackground(Color.black);
        frame197.add(buutton11);



// clear textfield button
        buutton12=new JButton();
        buutton12.setBounds(550,700,150,30);
        buutton12.setText("Clear");
        buutton12.setForeground(Color.WHITE);
        buutton12.setBackground(Color.black);
        frame197.add(buutton12);
        buutton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent eer) {

                // clear textfield
                texs_3.setText("");
                texs_4.setText("");

            }

        });


        // for panel1
        panl7=new JPanel();
        panl7.setBounds(19,65,199,690);
        panl7.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        // for panel2
        panl8=new JPanel();
        panl8.setBounds(210,65,600,690);
        panl8.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


// panel for table
        panl9=new JPanel();
        panl9.setBounds(800,65,640,690);
        table122 = new JTable();
        JTable table12 = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[9];

        columnsName[0]="id";
        columnsName[1] = "studentname";
        columnsName[2] = "modulename";
        columnsName[3] = "modulecode";
        columnsName[4] = "course";
        columnsName[5] = "level";

        columnsName[6] = "semester";

        columnsName[7] = "marks";
        columnsName[8]="remarks";



        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[9];
        for(int i = 0; i < table43().size(); i++){

            rowData[0] = table43().get(i).getid();
            rowData[1] = table43().get(i).studentname();
            rowData[2] = table43().get(i).getmodulename();
            rowData[3] = table43().get(i).getmodulecode();
            rowData[4] = table43().get(i).getcours();
            rowData[5] = table43().get(i).getlevel();
            rowData[6] = table43().get(i).getsem();
            rowData[7] = table43().get(i).getmarks();
            rowData[8] = table43().get(i).getrem();




            model.addRow(rowData);
        }
        table12.setModel(model);
        table12.setPreferredScrollableViewportSize(new Dimension(600,650));
        JScrollPane scr9 = new JScrollPane(table12);
        scr9.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scr9.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panl9.add(scr9);

        panl9.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.CYAN));


        frame197.add(panl7);
        frame197.add(panl8);
        frame197.add(panl9);
        frame197.setLayout(null);
        frame197.setSize(1500,800);
        frame197.setResizable(false);
        frame197.setVisible(true);
        frame197.getContentPane().setBackground( Color.darkGray);
        frame197.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit marks panel");
                System.exit(0);
            }

        });


    }


    public void setVisible(boolean b) {
        // TODO Auto-generated method stub

    }

    public ArrayList<Table4> table43() {

        ArrayList<Table4> table43 = new ArrayList<Table4>();
        try {

            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");//connection of localhost
            String query="SELECT * from marks"; // select query for marks
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Table4 use;

            while(rs.next()){

                use = new Table4(
                        rs.getString("id"),
                        rs.getString("studentname"),
                        rs.getString("modulename"),
                        rs.getString("modulecode"),
                        rs.getString("course"),
                        rs.getString("level"),
                        rs.getString("semester"),
                        rs.getString("marks"),
                        rs.getString("remarks")


                );

                table43.add(use); // add all column in table
            }

        } catch (SQLException ex) { // catch SQL Exception
            Logger.getLogger(Marks.class.getName()).log(Level.SEVERE, null, ex);
        }

        return table43;
    }



    public void markslogn() {
        // BUTTON to add marks
        buutton9.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("insert into marks(id,studentname,modulename,modulecode,course,level,semester,marks,remarks)values(?,?,?,?,?,?,?,?,?)");

                    String id1;
                    id1=co1.getSelectedItem().toString();
                    ps.setString(1, id1);

                    String stname;
                    stname=co2.getSelectedItem().toString();
                    ps.setString(2, stname);

                    ps.setString(3, texs_1.getText());
                    ps.setString(4, texs_2.getText());

                    String cors;
                    cors=co3.getSelectedItem().toString();
                    ps.setString(5, cors);

                    String lv1;
                    lv1=co4.getSelectedItem().toString();
                    ps.setString(6, lv1);

                    String se3;
                    se3=co5.getSelectedItem().toString();
                    ps.setString(7, se3);

                    ps.setString(8, texs_3.getText());
                    ps.setString(9, texs_4.getText());
                    int x=ps.executeUpdate();




                    if (x>0) {
                        System.out.println("Sucessfully insert");
                    }
                    else {
                        System.out.println("Already existed");
                    }
                }catch(Exception ee) {
                    System.out.println(ee);
                }


            }

        });

        // update marks
        buutton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("UPDATE marks SET id=?,studentname=?,modulename=?,modulecode=?,course=?,level=?,semester=?,marks=?,remarks=? WHERE id=?");



                    String id1;
                    id1=co1.getSelectedItem().toString();
                    ps.setString(1, id1);

                    String stname;
                    stname=co2.getSelectedItem().toString();
                    ps.setString(2, stname);

                    ps.setString(3, texs_1.getText());
                    ps.setString(4, texs_2.getText());

                    String cors;
                    cors=co3.getSelectedItem().toString();
                    ps.setString(5, cors);

                    String lv1;
                    lv1=co4.getSelectedItem().toString();
                    ps.setString(6, lv1);

                    String se3;
                    se3=co5.getSelectedItem().toString();
                    ps.setString(7, se3);

                    ps.setString(8, texs_3.getText());
                    ps.setString(9, texs_4.getText());


                    id1=co1.getSelectedItem().toString();
                    ps.setString(10, id1);



                    int y=ps.executeUpdate();
                    if (y>0) {
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

        // delete marks
        buutton11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
                    PreparedStatement ps=conn.prepareStatement("DELETE FROM marks where marks=?");
                    ps.setString(1, texs_3.getText());
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

    // fetch data in combobox from database using select Query
    public void filcombo() {
        try {
            Connection connects = DriverManager.getConnection("jdbc:mysql://:3306/connec","root","");
            Statement stat_ment = connects.createStatement();
            ResultSet r_set = stat_ment.executeQuery("select * from student");
            while(r_set.next()){
                co1.addItem(r_set.getString("id"));
                co2.addItem(r_set.getString("studentname"));
                co3.addItem(r_set.getString("course"));
                co4.addItem(r_set.getString("level"));
                co5.addItem(r_set.getString("semester"));

            }
        } catch(SQLException aw) {  // catch SQL Exception
            Logger.getLogger(Marks.class.getName()).log(Level.SEVERE, null, aw);

        }

    }

    public static void main(String[]args) {

        Marks mark1 = new Marks();

        // call function
        mark1.controller(null);
        mark1.markslogn();
        mark1.filcombo();



    }



}
