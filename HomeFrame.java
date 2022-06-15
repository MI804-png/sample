
package main;

import javax.swing.*;

public class HomeFrame extends JFrame{
    public HomeFrame(){
        
    
        super("Home");
        setSize(300, 400);
        setLocation(500, 100);
        setDefaultCloseOperation(2);
        setResizable(false);
        
        JMenuItem usersMenuItem = new JMenuItem("Users");
        usersMenuItem.addActionListener(e -> new UsersFrame().showFrame());
        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.add(usersMenuItem);
        JMenuBar signUpMenuBar = new JMenuBar();
        signUpMenuBar.add(optionsMenu);
        setJMenuBar(signUpMenuBar);
        
        
        
        JPanel HomePanel = new JPanel();
        HomePanel.setLayout(null);
        
        
        
        add(HomePanel);
    }
    public void showFrame(){
        setVisible(true);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(HomeFrame.this, message);
    }
    
    
}