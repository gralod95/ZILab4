/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author macbook
 */
public class Authentication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        UserBase.loadUserBase();
        Window w1 = new Window();
        w1.setB2N("sing");
        w1.setB1N("reg");
        w1.pack();
        w1.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                w1.setVisible(false);
                Window w2 = new Window();
                w2.setLN("Sing in");
                w2.setB2N("back");
                w2.setB1N("next");
                w2.addTextPanel();
                w2.button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)  {
                        String log = w2.getSetLog();
                        String pass = w2.getSetPass();
                        System.out.println(log);
                        System.out.println(pass);
                        w2.setVisible(false);
                        Window w3 = new Window();
                        w3.setLN("Result");
                        w3.setB1N("Start");
                        w3.setB2N("Login");
                        try {
                            if(UserBase.singIn(log, pass)){
                                w3.setLN("You sing in");
                            }else{
                                w3.setLN("Wrong login or password");
                            }
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        w3.button1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                w3.setVisible(false);
                                w1.setVisible(true);
                            }
                        });
                        w3.button2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                w3.setVisible(false);
                                w2.setVisible(true);
                            }
                        });
                    }
                });
                w2.button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        w2.setVisible(false); 
                        w1.setVisible(true);   
                    }
                });
                
            }
        });
        w1.button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                w1.setVisible(false);
                Window w2 = new Window();
                w2.setLN("Registration");
                w2.setB2N("back");
                w2.setB1N("next");
                w2.addTextPanel1();
                w2.button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String log = w2.getSetLog();
                        String pass = w2.getSetPass();
                        String pass1 = w2.getSetPass1();
                        System.out.println(log);
                        System.out.println(pass);
                        System.out.println(pass1);
                        w2.setVisible(false);
                        Window w3 = new Window();
                        w3.setLN("Result");
                        w3.setB2N("Reg");
                        w3.setB1N("Start");
                        try {
                            if(pass.equals(pass1)){
                                if(UserBase.addNewUser(log, pass)){
                                    w3.setLN("new user added");
                                }else{
                                    w3.setLN("this login already used");
                                }
                            }else{
                                w3.setLN("wrong repeted password");
                            }
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(UserBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        w3.button1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                w3.setVisible(false);
                                w1.setVisible(true);
                            }
                        });
                        w3.button2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                w3.setVisible(false);
                                w2.setVisible(true);
                            }
                        });
                    
                w2.button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        w2.setVisible(false); 
                        w1.setVisible(true);   
                    }
                });
            }
                
                });
            }
        });
    }
}
