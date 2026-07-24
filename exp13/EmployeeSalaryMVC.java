package exp13;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class EmployeeModel {
    private String name;
    private String department;
    private String employmentType;
    private double basicSalary;

    public EmployeeModel(String name, String department,
                         String employmentType, double basicSalary) {
        this.name = name;
        this.department = department;
        this.employmentType = employmentType;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {

        double bonus = 0;

        if (department.equals("IT")) {
            bonus = 5000;
        } else if (department.equals("HR")) {
            bonus = 3000;
        } else {
            bonus = 2000;
        }

        if (employmentType.equals("Full Time")) {
            bonus += 4000;
        } else {
            bonus += 1500;
        }

        return basicSalary + bonus;
    }
}

class EmployeeView extends JFrame {

    JTextField txtName, txtSalary;
    JComboBox<String> deptBox;

    JRadioButton fullTime, partTime;

    JButton calcButton;

    JLabel resultLabel;

    public EmployeeView() {

        setTitle("Employee Salary Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }

        Container c = getContentPane();
        c.setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Employee Salary Calculator",
                JLabel.CENTER);

        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setOpaque(true);
        title.setBackground(Color.LIGHT_GRAY);
        title.setBorder(new EmptyBorder(10, 10, 10, 10));

        c.add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        centerPanel.setBorder(
                new TitledBorder("Employee Details"));

        JLabel lblName = new JLabel("Employee Name:");
        txtName = new JTextField();

        JLabel lblSalary = new JLabel("Basic Salary:");
        txtSalary = new JTextField();

        JLabel lblDept = new JLabel("Department:");
        deptBox = new JComboBox<>(
                new String[]{"IT", "HR", "Sales"});

        JLabel lblType = new JLabel("Employment Type:");

        fullTime = new JRadioButton("Full Time");
        partTime = new JRadioButton("Part Time");

        ButtonGroup bg = new ButtonGroup();
        bg.add(fullTime);
        bg.add(partTime);

        fullTime.setSelected(true);

        txtName.setPreferredSize(new Dimension(150, 30));
        txtName.setBorder(new LineBorder(Color.BLACK, 1));
        txtName.setOpaque(true);

        txtSalary.setPreferredSize(new Dimension(150, 30));
        txtSalary.setBorder(new LineBorder(Color.BLACK, 1));
        txtSalary.setOpaque(true);

        deptBox.setPreferredSize(new Dimension(150, 30));
        deptBox.setBorder(new LineBorder(Color.BLACK, 1));
        deptBox.setOpaque(true);

        fullTime.setBorder(new LineBorder(Color.GRAY, 1));
        fullTime.setOpaque(true);

        partTime.setBorder(new LineBorder(Color.GRAY, 1));
        partTime.setOpaque(true);

        centerPanel.add(lblName);
        centerPanel.add(txtName);

        centerPanel.add(lblSalary);
        centerPanel.add(txtSalary);

        centerPanel.add(lblDept);
        centerPanel.add(deptBox);

        centerPanel.add(lblType);

        JPanel radioPanel = new JPanel();
        radioPanel.add(fullTime);
        radioPanel.add(partTime);

        centerPanel.add(radioPanel);

        resultLabel = new JLabel("Salary: ");
        resultLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        resultLabel.setForeground(Color.BLUE);

        centerPanel.add(resultLabel);

        c.add(centerPanel, BorderLayout.CENTER);

        calcButton = new JButton("Calculate Salary");

        ImageIcon icon = new ImageIcon("calculator.png");
        calcButton.setIcon(icon);

        calcButton.setToolTipText("Click to calculate salary");
        calcButton.setMnemonic(KeyEvent.VK_C);

        calcButton.setBackground(Color.BLACK);
        calcButton.setForeground(Color.WHITE);

        calcButton.setPreferredSize(new Dimension(200, 40));
        calcButton.setBorder(new LineBorder(Color.BLACK, 2));
        calcButton.setOpaque(true);

        JPanel southPanel = new JPanel();
        southPanel.add(calcButton);

        c.add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

class EmployeeController implements ActionListener {

    EmployeeView view;

    public EmployeeController(EmployeeView view) {
        this.view = view;

        view.calcButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            String name = view.txtName.getText();

            double salary =
                    Double.parseDouble(view.txtSalary.getText());

            String dept =
                    view.deptBox.getSelectedItem().toString();

            String type =
                    view.fullTime.isSelected()
                            ? "Full Time"
                            : "Part Time";

            EmployeeModel model =
                    new EmployeeModel(name, dept, type, salary);

            double finalSalary = model.calculateSalary();

            view.resultLabel.setText(
                    "Final Salary: ₹ " + finalSalary);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    view,
                    "Enter valid salary!"
            );
        }
    }
}

public class EmployeeSalaryMVC {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            EmployeeView view = new EmployeeView();

            new EmployeeController(view);

        });
    }
}