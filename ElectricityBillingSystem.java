import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElectricityBillingSystem1 extends JFrame implements ActionListener{
 
    JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1;
    JRadioButton r1,r2;
    JCheckBox cb1,cb2;
    ElectricityBillingSystem1(){
        setVisible(true);
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Electricity Billing System");
 
        l1 = new JLabel("Electricity Billing System");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
 
        l2 = new JLabel("Enter the Units Consumed : ");
        l3 = new JLabel("Select the Service Type :");
 
        tf1 = new JTextField();
 
        btn1 = new JButton("Calculate Bill");
 
        r1 = new JRadioButton("Domestic");
        r2 = new JRadioButton("Commercial");
 
        cb1 = new JCheckBox("Night Charges");
        cb2 = new JCheckBox("GST");
 
        btn1.addActionListener(this);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
 
        l1.setBounds(200, 60, 800, 60);
        l2.setBounds(160, 140, 400, 60);
        l3.setBounds(160, 220, 400, 60);
        tf1.setBounds(600, 140, 400, 60);
        btn1.setBounds(300, 300, 300, 60);
        r1.setBounds(400, 400, 200, 60);
        r2.setBounds(400, 480, 200, 60);
        cb1.setBounds(400, 560, 400, 60);
        cb2.setBounds(400, 640, 400, 60);
 
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(btn1);
        add(r1);
        add(r2);
        add(cb1);
        add(cb2);
    }
    public void actionPerformed(ActionEvent e){
    
        float units=Float.parseFloat(tf1.getText());
        float charge=0;
        if(r1.isSelected()){
            if(units<=50){
                charge=units*1.20f;
            }
            else if(units<=150){
                charge=(50*1.20f)+(units-50)*2.40f;
            }
            else if(units<=250){
                charge=(50*1.20f)+(100*2.40f)+(units-150)*3.60f;
            }
            else{
                charge=(50*1.20f)+(100*2.40f)+(100*3.60f)+(units-250)*4.80f;
            }
        }
        else{
            if(units<=50){
                charge=units*2.50f;
            }
            else if(units<=150){
                charge=(50*2.50f)+(units-50)*4.00f;
            }
            else if(units<=250){
                charge=(50*2.50f)+(100*4.00f)+(units-150)*5.20f;
            }
            else{
                charge=(50*2.50f)+(100*4.00f)+(100*5.20f)+(units-250)*6.50f;
            }
        }
        if(cb1.isSelected()){
            charge=charge*1.20f;
        }
        if(cb2.isSelected()){
            charge=charge*1.10f;
        }
       
        JOptionPane.showMessageDialog(this,"Total bill is "+charge);
    }
    public static void main(String args[]){
        new ElectricityBillingSystem1();
    }
}
