import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;

class Table {
	public static void main(String arg[]) {
		JFrame f = new JFrame();
		String col[] = { "name", "rol" };
		DefaultTableModel m = new DefaultTableModel(col, 0);
		JTable table = new JTable(m);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(020,20,400,500);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(                "jdbc:mysql://localhost:3306/exam",
                "root",
                "root123");
			PreparedStatement ps = con.prepareStatement("Select * from oop ");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				Object row[]={
					rs.getString("name"),
					rs.getInt("roll")
				};
				m.addRow(row);
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
		f.add(sp);
		f.setSize(500, 200);
		f.setLayout(null);
		f.setVisible(true);
	}
}