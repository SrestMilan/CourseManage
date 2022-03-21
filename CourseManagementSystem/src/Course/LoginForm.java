package Course;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;



@SuppressWarnings("serial")
public class LoginForm  extends JFrame  {
    private JPanel panel3;
    private JLabel label2;
    private ImageIcon icons1;
    private Font font6;
    private JTextField txt1;
    private JPasswordField txt2;
    private JButton bttn1,bttn2;
    private JComboBox c1;

    // create frame of application
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void App()  {
        setTitle("Course Management System");
        icons1=new ImageIcon("image/d.png");
        setIconImage(icons1.getImage());
        // for panel
        panel3=new JPanel();
        panel3.setBackground(Color.WHITE);
        panel3.setLayout(null);
        panel3.setBounds(25,25,780,360);



        icons1=new ImageIcon("image/ad.png");
        label2=new JLabel(icons1);
        label2.setBounds(300,70,500,210);
        panel3.add(label2);

        font6=new Font("Arial",Font.BOLD,20);
        label2=new JLabel("Select User:");
        label2.setForeground(Color.BLACK);
        label2.setBounds(70,80,170,20);
        label2.setFont(font6);
        panel3.add(label2);
        String [] users= {"Student","Admin","Instructor"};
        c1=new JComboBox(users);
        c1.setBounds(190,80,150,20);
        panel3.add(c1);
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(c1.getSelectedItem());

            }

        });



        // Username

        label2=new JLabel("Username:");
        label2.setBounds(70,130,150,20); // set position and size of label3
        label2.setForeground(Color.BLACK);
        label2.setFont(font6);
        panel3.add(label2);
        txt1=new JTextField();// create TextField  for Username
        txt1.setBounds(189,130,150,20);//TextField
        panel3.add(txt1);

        // Password

        label2=new JLabel("Password:");
        label2.setForeground(Color.BLACK);
        label2.setBounds(70,190,150,20);
        label2.setFont(font6);
        panel3.add(label2);
        txt2=new JPasswordField();// create TextField  for Username
        txt2.setBounds(190,190,150,20);//TextField
        panel3.add(txt2);

        // Login Button
        bttn1=new JButton("Login");
        bttn1.setBounds(70,250,100,30);
        bttn1.setForeground(Color.WHITE);
        bttn1.setBackground(Color.BLACK);
        panel3.add(bttn1);// add buttton in JFrame

        // Exit button
        bttn2=new JButton("Exit");
        bttn2.setBounds(240,250,100,30);
        bttn2.setForeground(Color.WHITE);
        bttn2.setBackground(Color.BLACK);
        panel3.add(bttn2);// add buttton in JFrame
        bttn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Exit Panel");
                System.exit(0);

            }

        });

        add(panel3);
        setLayout(null);
        setSize(850,450);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground( Color.BLACK);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit Window");
                System.exit(0);
            }

        });// JFrame exit on close




    }

    // set connection for login
    public void login() {
        bttn1.addActionListener(new ActionListener(){
            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent ee){
                String userName=txt1.getText();
                String pass=txt2.getText();

                try {
                    Connection conec=null;
                    PreparedStatement p_statement=null;
                    ResultSet r_set=null;
                    String query="SELECT * FROM `accounts` WHERE userName=? and password=? and usertype=?"; // query for selecting user type, password and usernam
                    conec=DriverManager.getConnection("jdbc:mysql://localhost/connec","root",""); // connection of localhost server using driver manager
                    p_statement=conec.prepareStatement(query);
                    p_statement.setString(1, userName);
                    p_statement.setString(2, pass);
                    p_statement.setString(3, String.valueOf(c1.getSelectedItem()));
                    r_set=p_statement.executeQuery();

                    if(r_set.next()) {
                        JOptionPane.showMessageDialog(null,"Login Sucessfully");
                        if(c1.getSelectedIndex()==0) {  // combobox index number 3 selected
                            Student stdent=new Student();  // student class
                            stdent.std();
                            stdent.fillcombo2();
                            stdent.setVisible(true);
                            setVisible(false);

                        }
                        else if(c1.getSelectedIndex()==1) {  // combobox index number 1 selected
                            Administrator obj = new Administrator();  // admin class
                            obj.controller();
                            obj.logn();
                            obj.setVisible(true);
                            setVisible(false);
                        }

                        else if(c1.getSelectedIndex()==2) {  // combobox index number 2 selected

                            Instructor insr = new Instructor();  // instructor class
                            insr.insappp();
                            insr.fillcombo9();


                            insr.setVisible(true);
                            setVisible(false);
                        }

                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Invalid username and password");
                    }



                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }



            }
        });

    }
    public static void main(String[]args) {
        LoginForm obf=new LoginForm();
        // calling function of class using instance
        obf.App();
        obf.login();
    }

}
