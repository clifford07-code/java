import java.awt.Color;
import java.sql.*;

import javax.swing.*;

class zx {
    public static void main(String[] args) {
        JFrame f=new JFrame("Login");
        JLabel l1 = new JLabel("name");
        l1.setBounds(50,50,100,30);
        JLabel l2 = new JLabel("email");
         l2.setBounds(50,100,100,30);

         JTextField t1 =new JTextField();
          t1.setBounds(100,50,100,30);
          JTextField t2 =new JTextField();
          t2.setBounds(100,100,100,30);

          JButton btn=new JButton("Login");
          btn.setBounds(80,130,100,30);

          btn.addActionListener(e->{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/college",
                "root",
                "password");
                PreparedStatement ps = con.prepareStatement("insert into user values(?,?)");
                ps.setString(1,t1.getText());
                ps.setString(2,t2.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(f,"inserted");
            }catch(Exception ex){
                System.out.println(ex);
            }
          });

        f.add(l1);
         f.add(l2);
          f.add(t1);
           f.add(t2);
           f.add(btn);
f.setLayout(null);
           f.setSize(300,300);
           
           f.setVisible(true);



    }
}