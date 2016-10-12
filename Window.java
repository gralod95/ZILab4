/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author macbook
 */
public class Window extends JFrame {
    private JLabel countLabel;
    JButton button1;
    JButton button2;
    private JTextArea login;
    private JTextArea pass;
    private JTextArea pass1;
    private JPanel textPanel;
    private JPanel labelPanel;
    private JPanel buttonPanel;
    public Window(){
        setName("Authentication");
        setBounds(500, 250, 300, 200);
        countLabel = new JLabel("Good afternoon");
        button1 = new JButton("");
        button2 = new JButton("");
        login = new JTextArea("login");
        pass = new JTextArea("password");
        pass1 = new JTextArea("repeat password");
        labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(countLabel); 
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(button2);
        buttonPanel.add(button1);
        add(labelPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        initListeners();
    }
    private void initListeners() {
     button2.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
        //Enter app = new Enter();
         //voron = voron + 1;   /* Добавляем одну ворону  */
         //updateCrowCounter(); /* Сообщаем аппликации, что количество ворон изменилось  */
       }
     });
    }
    public void setB1N( String name){
        button1.setText(name);
        //pack();
    }
    public void setB2N( String name){
        button2.setText(name);
        //pack();
    }
    public void setLN( String name){
        countLabel.setText(name);
    }
    public void addTextPanel(){
        textPanel = new JPanel(new BorderLayout());
        textPanel.add(login, BorderLayout.NORTH);
        textPanel.add(pass, BorderLayout.SOUTH);
        add(textPanel);
    }
    public void addTextPanel1(){
        textPanel = new JPanel(new BorderLayout());
        textPanel.add(login, BorderLayout.NORTH);
        textPanel.add(pass, BorderLayout.CENTER);
        textPanel.add(pass1, BorderLayout.AFTER_LAST_LINE);
        add(textPanel);
    }
    public String getSetLog(){
        return login.getText();
    }
    public String getSetPass(){
        return pass.getText();
    }
    public String getSetPass1(){
        return pass1.getText();
    }
    public void removeButtonPanel(){
        buttonPanel.removeAll();
    }
}

