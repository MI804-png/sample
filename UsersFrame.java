
package main;
import java.awt.event.ActionEvent;
import java.io.*;
import static java.io.FileDescriptor.in;
import java.io.IOException;
import static javax.management.Query.in;
import javax.swing.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class UsersFrame extends JFrame{
    public UsersFrame() {
        super("Users");
        setSize(300, 400);
        setLocation(700, 100);
        setDefaultCloseOperation(3);
        //setResizable(false);
        
        JPanel usersPanel=new JPanel();
        usersPanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );
        
        JTextArea usersTextArea=new JTextArea(16,58);
        usersTextArea.setBounds(10, 15, 655, 830);
        usersTextArea.setEditable(true);
        
    // create the middle panel components

    JScrollPane scroll = new JScrollPane ( usersTextArea );
    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        usersPanel.add(scroll);
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
        usersTextArea.setText(String.valueOf(result));
    }catch(IOException e){
            showMessage("An error occurred");
        }
        
        
        usersPanel.setLayout(null);
        usersPanel.add(usersTextArea);
        //usersTextArea.add ( scroll );
        //setLocationRelativeTo ( null );
       
        add(usersPanel );
       
        add(usersPanel);
    }
    public void showFrame(){
        setVisible(true);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(UsersFrame.this, message);
    }
}

