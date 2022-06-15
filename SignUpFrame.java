
package main;

import java.awt.event.ActionEvent;
import java.io.*;
import static java.io.FileDescriptor.in;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.in;
import javax.swing.*;

public class SignUpFrame extends JFrame{
    public SignUpFrame(){
        super("Create new account");
        setSize(400, 500);
        setLocation(100, 100);
        setDefaultCloseOperation(3);
        setResizable(false);
        
        //menubar->menu->menuItem
        
       /* JMenuItem usersMenuItem = new JMenuItem("Users");
        usersMenuItem.addActionListener(e -> new UsersFrame().showFrame());
        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.add(usersMenuItem);
        JMenuBar signUpMenuBar = new JMenuBar();
        signUpMenuBar.add(optionsMenu);
        setJMenuBar(signUpMenuBar);
        */
        JLabel nameLabel = new JLabel("Enter Your Name");
        nameLabel.setBounds(40, 5, 150, 15);
        
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(40, 25, 260, 25);
        
        JLabel emailLabel = new JLabel("Enter Your Email");
        emailLabel.setBounds(40, 55, 150, 35);
        
        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(40, 95, 260, 27);
        
        JLabel passwordLabel = new JLabel("Enter Your Password");
        passwordLabel.setBounds(40, 135, 150, 35);
        
        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(40, 170, 260, 27);
        
        
        JRadioButton maleRadioButton = new JRadioButton("male");
        maleRadioButton.setBounds(40, 200, 100, 20);
        
        JRadioButton femaleRadioButton = new JRadioButton("female");
        femaleRadioButton.setBounds(40, 230, 100, 20);
        
        JRadioButton childrenRadioButton = new JRadioButton("chidren");
        childrenRadioButton.setBounds(40, 260, 100, 20);
        
        JButton createNewAccountButton = new JButton("Create New Account");
        createNewAccountButton.setBounds(40, 300, 150, 25);
        createNewAccountButton.addActionListener((ActionEvent e) ->{
            String name =nameTextField.getText();
            String email =emailTextField.getText();
            String password =passwordTextField.getText();
            String gender = "";
            int n=0;
            n++;
            int increase=0;
            if(maleRadioButton.isSelected())gender="male";
            else if(femaleRadioButton.isSelected())gender="female";
            else gender="children";
            if(name.isEmpty()){
                showMessage("Name is empty , please enter your name");
            return;}
            
            if(email.isEmpty()){
                showMessage("Email is empty , please enter your email");
            return;}
            
            if(password.isEmpty()){
                showMessage("Password is empty , please enter your password");
            return;}
            
            

            
            if(gender.isEmpty()){
                showMessage("Gender is empty , please enter your gender");
            return;}
            showMessage(name + "\n" +email + "\n" + password + "\n" + gender);
            
            
            try {
                String url ="jdbc:mysql://localhost:3306/church";
                Connection connection = DriverManager.getConnection(url,"root","");
                connection.createStatement().execute("INSERT INTO `users` (`name`, `email`, `password`,`gender`)"
                        + " VALUES ('"+name+"' , '"+email+"', '"+password+"','"+gender+"' );");
            } catch (SQLException ex) {
                System.out.println("Database error occurred");}
            
            
            try{
                FileWriter fileWriter = new FileWriter("users.txt",true);
                //userData.append("Name : "+name + "\n"+"Email : "+email + "\n"+"Password : "+password + "\n"+"Gender : "+gender + "\n"+"-------");
                String userData="Name : "+name + "\n"+"Email : "+email + "\n"+"Password : "+password + "\n"+"Gender : "+gender + "\n"+"-------------------"+"\n"+"---------------------------------";              
                fileWriter.write(userData);
                //////////////////////////////////////////////
                //try database
            
            
            
                
                
                //////////////////////////////////////////////
                fileWriter.close();

                showMessage("Account created successfully");
                nameTextField.setText("");
                emailTextField.setText("");
                passwordTextField.setText("");
                maleRadioButton.setSelected(false);
                femaleRadioButton.setSelected(false);
                childrenRadioButton.setSelected(false);
                
            }catch(IOException ioException){
                showMessage("Error Occurred");
            }
   
        });
        
        JButton SignInButton = new JButton("Sign In New Account");
        SignInButton.setBounds(40, 340, 150, 25);
        SignInButton.addActionListener(e ->{
            String email = emailTextField.getText();
            String password = passwordTextField.getText();
            LoginFrame loginFrame = new LoginFrame(email,password);
            loginFrame.showFrame();
            
        });
        
        JPanel SignUpPanel=new JPanel();
        SignUpPanel.setLayout(null);
        SignUpPanel.add(nameLabel);
        SignUpPanel.add(nameTextField);
        SignUpPanel.add(emailLabel);
        SignUpPanel.add(emailTextField);
        SignUpPanel.add(passwordLabel);
        SignUpPanel.add(passwordTextField);
        SignUpPanel.add(maleRadioButton);
        SignUpPanel.add(femaleRadioButton);
        SignUpPanel.add(createNewAccountButton);
        SignUpPanel.add(childrenRadioButton);
        SignUpPanel.add(SignInButton);
        add(SignUpPanel);
        
    }
    
    public void showFrame(){
        setVisible(true);
    }
    private void showMessage(String message){
        JOptionPane.showMessageDialog(SignUpFrame.this, message);
        
    }
    
    
    
}
