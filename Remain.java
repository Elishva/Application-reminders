/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmn14_b;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author avis
 */
public class Remain extends JPanel{
    private Hashtable <Integer,String>_table =new Hashtable(); 
    private final JComboBox _cmdMonth;
    private final JComboBox _cmdDay;
    private final JComboBox _cmdYear;
    private final JTextField txtrmd;
    private final JButton btnsave;
    private final JButton btntake;
    private final JButton btnSaveFile;
    private final JButton btnLoadFile;
    private final String arrDay[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",};
    private final String arrMonth[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
   private final String arrYear[]={"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021"};
    public Remain()
    {
       _table = new Hashtable<>();
       setLayout(new BorderLayout());
       
         txtrmd=new JTextField(100);
         btnsave=new JButton("save");
         btntake=new JButton("take");
         btnSaveFile=new JButton("save to File");
         btnLoadFile=new JButton("Load From File");
        _cmdMonth=new  JComboBox(arrMonth);
        _cmdDay=new  JComboBox(arrDay);
        _cmdYear=new  JComboBox( arrYear);
        
       
        add( btntake);
        add(new MyJComboBox(),BorderLayout.NORTH); 
        add(txtrmd,BorderLayout.CENTER );
        add(new MyButton(),BorderLayout.SOUTH );
        
        
         btnsave.addActionListener(new ButtonAction());
         btntake.addActionListener(new ButtonAction());
         btnSaveFile.addActionListener(new ButtonAction());
         btnLoadFile.addActionListener(new ButtonAction());
        
    }
    
   //build the date  
   private class MyJComboBox extends JPanel
    {
        
        public MyJComboBox()
        {
            add(_cmdDay);
            add( _cmdMonth);
           add(_cmdYear);
        }
    
   }
   //this method take the reamin from date.
    private void takeRemain()
   {
       String str="";
       int day =  Integer.parseInt((String) _cmdDay.getSelectedItem());
       int m =  Integer.parseInt((String) _cmdMonth.getSelectedItem());
       int y = Integer.parseInt((String) _cmdYear.getSelectedItem());
       
       Date d=new Date(day,m,y);
       int key = d.hashCode();
     
       str=_table.get(key);
      txtrmd.setText(str);
   }
   //this method saves the remain of date
   private void saveRemain()
   {
       int day =  Integer.parseInt((String) _cmdDay.getSelectedItem());
       int m =  Integer.parseInt((String) _cmdMonth.getSelectedItem());
       int y = Integer.parseInt((String) _cmdYear.getSelectedItem());
       
       Date d=new Date(day,m,y);
       int key = d.hashCode();
     
       String st = txtrmd.getText();
       
       _table.put( key, st);
   }
   
   //this method take the remain from  file that choose by user.
   private void takeFile()
   {
       String name;
       try{
       name=JOptionPane.showInputDialog("Enter your name of file to read message(ex. a.txt)");
        readfile(name);
       }catch(FileNotFoundException e){
           System.out.println("no such file");
       }
     
       
   }
   
   //this method save the remain on file that choose by user.
   public void saveFile() throws FileNotFoundException
   {
       String name;
       
       name=JOptionPane.showInputDialog("Enter your name of file to write message (ex. a)");
      writefile(name);
      
        
   }
   //build the button to take and save remains
   private class MyButton extends JPanel
    {
        
        public MyButton()
        {
             add(btntake);
             add(btnsave ); 
             add(btnSaveFile);
             add(btnLoadFile);
        
 
            
        }
    
   }
   
   
  private class ButtonAction implements ActionListener
       {
          public void actionPerformed(ActionEvent event)
          {
               Object e=event.getSource();
               if(e.equals(btntake))
                     takeRemain();
               if(e.equals(btnsave))
                   saveRemain();
               if(e.equals(btnSaveFile))
                     try {
                         saveFile();
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Remain.class.getName()).log(Level.SEVERE, null, ex);
               }
               if(e.equals(btnLoadFile))
                  takeFile();
              
                  
               
          }
        }
  //this metod write the remain of file.
    private void writefile(String name) throws FileNotFoundException
    {
     
    String n=""+name+".txt";
    System.out.print(n);
      Formatter output=new Formatter(n);
      
      output.format(txtrmd.getText());
     
      output.close();
    }
    
    //this method read the remain from file.
    private void readfile(String name) throws FileNotFoundException
    {
         String st="";
        Scanner input = new Scanner(new File(name)); 
         while (input.hasNext()){
            st = input.next();
          }
         txtrmd.setText(st);
         System.out.print(txtrmd.getText());
    }
   
}
