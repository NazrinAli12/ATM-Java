package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton deposit, withDraw1, miniStatement, pinChange, fastCash, balanceEnquiry, exit;
    String pinNumber;

    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); // şəkilin ölçüləri və yeri
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAW AMOUNT"); //Please select your Transaction
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withDraw1 = new JButton("Rs 500");
        withDraw1.setBounds(355, 415, 150, 30);
        withDraw1.addActionListener(this);
        image.add(withDraw1);

        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);        
        image.add(fastCash);

        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);   

        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);        
        image.add(pinChange);   

        balanceEnquiry = new JButton("Rs 10000");
        balanceEnquiry.setBounds(355, 485, 150, 30);
        balanceEnquiry.addActionListener(this);        
        image.add(balanceEnquiry);   

        
        exit = new JButton("Back");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);           
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);       
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == exit) {
           setVisible(false);
           new Transactions(pinNumber).setVisible(true);
    } else if (ae.getSource() == deposit || ae.getSource() == withDraw1 || ae.getSource() == fastCash || ae.getSource() == miniStatement || ae.getSource() == pinChange || ae.getSource() == balanceEnquiry) {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //Rs 500
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                        }
                }
                
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw1', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Succesfully"); 
                
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } 
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
