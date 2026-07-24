import javax.swing.*;
import java.sql.*;
import java.awt.*;

class UI{
    public static void main(String arg[]){
        JFrame f =new JFrame();
        JLabel l1=new JLabel("name");
        l1.setBounds(50,50,100,30);
        JLabel l2=new JLabel("email");
         l2.setBounds(50,100,100,30);

        JTextField t1 =new JTextField();
        t1.setBounds(100,50,100,30);

        JTextField t2 =new JTextField();
        t2.setBounds(100,100,100,30);

    JButton btn =new JButton("Loing");
      btn.setBounds(80,150,100,30);
      btn.setBackground(Color.red);

      btn.addActionListener(e->{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/exam",
"root",
"root123");

            PreparedStatement ps = con.prepareStatement("update oop set name=? where roll=?; "); 
               
             ps.setString(1,t1.getText());   
             ps.setInt(2,Integer.parseInt(t2.getText())); 
            ps.executeUpdate();
            // ResultSet rs=ps.executeQuery();
            // if(rs.next()){
            //     JOptionPane.showMessageDialog(f,"login");
            // }else{
            //     JOptionPane.showMessageDialog(f,"dfdf");
            // }
                con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
      });
      f.setBackground(Color.blue);
    f.add(l1);
     f.add(l2);
      f.add(t1);
       f.add(t2);
        f.add(btn);

        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
}