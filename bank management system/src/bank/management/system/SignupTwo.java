package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton sYes, sNo, eYes, eNo;
    JComboBox religion, category, occupation, education, income;
    String formNo;
        
    
    SignupTwo(String formNo) {
        this.formNo = formNo;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        

        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));    
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));    
        name.setBounds(100, 140, 100, 30);
        add(name); 
        
        String valReligion[] = {"Muslim", "Sikh", "Christian", "Hindu", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));    
        fname.setBounds(100, 190, 200, 30);
        add(fname);  
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));    
        dob.setBounds(100, 240, 200, 30);
        add(dob);  
        
        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,0000", "< 2,50,0000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
       
        
        JLabel gender = new JLabel("Education 1:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));    
        gender.setBounds(100, 290, 200, 30);
        add(gender); 
               
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));    
        email.setBounds(100, 315, 200, 30);
        add(email);  
        
        String educationValues[] = {"Non Graduation", "Graduate", "Post Graduation", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));    
        marital.setBounds(100, 390, 200, 30);
        add(marital); 
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);   
        
        
        JLabel nationalIdLabel  = new JLabel("National ID:");
        nationalIdLabel.setFont(new Font("Raleway", Font.BOLD, 20));    
        nationalIdLabel.setBounds(100, 490, 200, 30);
        add(nationalIdLabel);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 490, 400, 30);
        add(pan);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));    
        state.setBounds(100, 540, 200, 30);
        add(state);    
        
        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 540, 100, 30);
        sYes.setBackground(Color.white);
        add(sYes);
        
        sNo = new JRadioButton("No");
        sNo.setBounds(400, 540, 100, 30);
        sNo.setBackground(Color.white);
        add(sNo);
        
        ButtonGroup maritialGroup = new ButtonGroup();
        maritialGroup.add(sYes);
        maritialGroup.add(sNo);                

        
        JLabel pinCode = new JLabel("Existing Account:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));    
        pinCode.setBounds(100, 590, 200, 30);
        add(pinCode);
        
        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 590, 100, 30);
        eYes.setBackground(Color.white);
        add(eYes);
        
        eNo = new JRadioButton("No");
        eNo.setBounds(400, 590, 100, 30);
        eNo.setBackground(Color.white);
        add(eNo);
        
        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eYes);
        emaritalGroup.add(eNo);   
 
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        next.setBounds(620, 660, 80, 30);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ac) {
        String sReligion = (String) religion.getSelectedItem(); // setText
        String sCategory = (String) category.getSelectedItem();
        String sIncome = (String) income.getSelectedItem();
        String sEducation = (String) education.getSelectedItem();
        String sOccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if(sYes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sNo.isSelected()) {
            seniorCitizen = "No";
        }
  
        String existingAccount = null;
        if(eYes.isSelected()){
            existingAccount = "Yes";
        } else if (eNo.isSelected()) {
            existingAccount = "No";
        }
        
        String sNationalID  = pan.getText();
              
        
        try {
               Conn c = new Conn();
               String query = "insert into signupTwo values('"+formNo+"', '"+sReligion+"', '"+sCategory+"', '"+sIncome+"', '"+sEducation+"', '"+sOccupation+"', '"+sNationalID+"', '"+seniorCitizen+"', '"+existingAccount+"')";
               c.s.executeUpdate(query);
               
               //Signup3 Object
               setVisible(false);

               new SignupThree(formNo).setVisible(true);
      } catch (Exception e) {
      System.out.println(e);
      }        
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}