
package main;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class LoginFrame extends JFrame{
    String email = "";
    String password = "";
    public LoginFrame(String email, String password){
       super("People"); 
       this.email=email;
       this.password=password;
        
        setSize(400, 500);
        setLocation(800, 100);
        setDefaultCloseOperation(2);
        setResizable(false);
        
        JLabel emailLabel = new JLabel("Enter Your Email");
        emailLabel.setBounds(40, 5, 150, 15);
        
        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(40, 25, 260, 27);
        
        JLabel passwordLabel = new JLabel("Enter Your Password");
        passwordLabel.setBounds(40, 60, 150, 35);
        
        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(40, 100, 260, 27);
        
        JButton logInButton = new JButton("logIn");
        logInButton.setBounds(40, 135, 160, 27);
        logInButton.addActionListener(e->{
            if(email.contains(this.email)&& password.contains(this.password)){
                new HomeFrame().showFrame();
            }else{
                showMessage("the email or password isn't correct");
            }
        });
        
        try{
            FileReader fileReader = new FileReader("users.txt");
            int letter = fileReader.read();
            //usersTextArea.setText(String.valueOf((char)letter));
            StringBuilder result = new StringBuilder();
            while (letter!=-1) {                
                result.append((char)letter);
                letter=fileReader.read();
            }
        
        fileReader.close();
        String fileResult = String.valueOf(result);
        
        if(fileResult.contains(email)&&fileResult.contains(password)){
           // new HomeFrame().showFrame();
        }else{
            showMessage("the email or password isn't correct");
        }
        
        //usersTextArea.setText(String.valueOf(result));
    }catch(IOException e){
            showMessage("An error occurred");
        }
        
       /* String retrievedUserName = "";
        String status = "";
        try {
            
                String url ="jdbc:mysql://localhost:3306/demo";
                Connection connection = DriverManager.getConnection(url,"root","");
                connection.createStatement().execute("SELECT `email`, `password`  FROM `users`;");
                
                
            } catch (SQLException ex) {
                System.out.println("Database error occurred");}
        */
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.add(emailLabel);
        loginPanel.add(emailTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginPanel.add(logInButton);
        add(loginPanel);
    }

    LoginFrame() {
        
    }
    
    public void showFrame(){
        setVisible(true);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(LoginFrame.this, message);
    }
    
    
    
}
