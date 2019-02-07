/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmn14_b;

import javax.swing.JFrame;

/**
 *
 * @author avis
 */
public class Mmn14_b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      JFrame frame =new JFrame ("Remains");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        Remain s=new  Remain();
        frame.add(s);
        frame.setVisible(true);  
        
        
    }
    
}
