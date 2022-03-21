package Course;


import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.*;


// Tid class extends JFrame class from JSwing class
public class Tid extends JFrame {

    private ImageIcon icons_9;
    private JLabel label_ss;
    private JPanel panelss_1;
    private JButton bt_99;
    private JTextField tx_1;
    private Font fonts_99;


    // function to create frame of application

    public void insid() {
        setTitle("Enter teachername");
        icons_9=new ImageIcon("image/ad.png");
        setIconImage(icons_9.getImage());

        fonts_99=new Font("Arial",Font.BOLD,25);
        label_ss=new JLabel();
        label_ss.setBounds(20,10,170,30);
        label_ss.setForeground(Color.WHITE);
        label_ss.setFont(fonts_99);
        add(label_ss);


        // for panel
        panelss_1=new JPanel();
        panelss_1.setBounds(45,40,490,180);

        // label of teachername
        label_ss=new JLabel("Teacher name");
        label_ss.setBounds(220,90,500,30);
        label_ss.setForeground(Color.black);
        label_ss.setBackground(Color.white);
        label_ss.setFont(fonts_99);
        add(label_ss);
        tx_1=new JTextField();
        tx_1.setBounds(150,130,300,30);
        add(tx_1);

        // button to enter using teachername
        bt_99=new JButton();
        bt_99.setBounds(250,180,110,30);
        bt_99.setText("Enter ");
        bt_99.setForeground(Color.white);
        bt_99.setBackground(Color.black);
        add(bt_99);
        // button to check textfield empty or not
        bt_99.addActionListener(e->
                {


                    if (tx_1.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null," Oops ! Your textfield is empty");
                    }
                    else
                        checkid();

                }
        );

        panelss_1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));// bordercolor


        add(panelss_1);
        setLayout(null);
        setSize(600,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground( Color.black);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit entering id panel");
                System.exit(0);
            }

        });// JFrame exit on close

        // JFrame exit on close
    }

    public void checkid() {
        // textfield to enter teachername
        String teachname= tx_1.getText();
        try {

            Connection connne=DriverManager.getConnection("jdbc:mysql://localhost:3306/connec","root","");
            PreparedStatement p_st=connne.prepareStatement("SELECT userName FROM teacher where userName=?");
            p_st.setString(1, teachname);
            ResultSet re_set=p_st.executeQuery();
            boolean bol = false;
            while(re_set.next()) {

// check teachername is equal that we enter in database or not
                if (teachname.equals(re_set.getString("userName"))) {
                    bol = true;
                    break;

                }
            }
            if(bol) {

                String res = "SELECT * FROM teacher WHERE id="+"'"+teachname+"'";
                PreparedStatement p_st1 = connne.prepareStatement(res);
                ResultSet r_set = p_st1.executeQuery();

                Marks mark1 = new Marks();
                mark1.controller(teachname);
                mark1.markslogn();
                mark1.filcombo();

                mark1.setVisible(true);
                setVisible(false);


            }
            else {
                JOptionPane.showMessageDialog(null,"Oops! Your name is wrong teacher");

            }
        }catch(Exception d) { // catch Exception if SQL query is wrong
            JOptionPane.showMessageDialog(null,d);

        }
    }


    public static void main(String[]args) {

        Tid ins = new Tid();
        // call function of class using instance
        ins.insid();




    }

}
