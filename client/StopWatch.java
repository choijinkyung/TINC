package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch extends JFrame{
   Thread t=null; //스레드
   Display t_display;
   JButton b1,b2,b3; // start,pause,reset
   JLabel mm,colon,ss; // 분 : 초 
   JPanel LED; 
   ButtonPanel Menu;
   String min,sec;
   int n1=0,n2=0,count=0; //n1=분을 저장 , n2= 초를 저장
   ButtonAction BA=new ButtonAction();
   
   class Display extends Thread{ //GUI 창
      Display(){
         setTitle("StopWatch");
         setLayout(new BorderLayout());
         setVisible(true);         
      }
      
      public void run() { //스레드 run 
       n1=Integer.parseInt(mm.getText());
       n2=Integer.parseInt(ss.getText());       
       
       while(t==Thread.currentThread() && count<300000) {
          
          n2=count%1000;
          n1=(count%100000)/60;
          min=String.format("%02d", n1);
          sec=String.format("%02d", n2);
         
          mm.setText(min);
          ss.setText(sec);
         
          count++;
          try {
             Thread.sleep(1000);
          }catch(InterruptedException e) {
             return;
          }          
       }
      }
   }
   
   class ButtonPanel extends JPanel{
      ButtonPanel(){
         b1=new JButton("Start");
         b2=new JButton("Pause");
         b3=new JButton("Reset");
         b1.addActionListener(BA);
         b2.addActionListener(BA);
         b3.addActionListener(BA);
         setLayout(new FlowLayout());
         b1.setEnabled(true);
         b2.setEnabled(false);
         b3.setEnabled(false);
         add(b1);
         add(b2);
         add(b3);
         
      }
   }
   class ButtonAction implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         JButton btn=(JButton)e.getSource();
         if(btn.getText().equals("Start")) {
            t_display=new Display();
            t_display.start();
            t = t_display;
            System.out.println("Start");
            b1.setEnabled(false);
            b2.setEnabled(true);
            b3.setEnabled(false);
            
         }
         if(btn.getText().equals("Pause")) {
      
            t = null;
            System.out.println("Pause");
            b1.setEnabled(true);
            b2.setEnabled(false);
            b3.setEnabled(true);
            
         }
         if(btn.getText().equals("Reset")) {   
         
            b1.setEnabled(false);
            b2.setEnabled(true);
            b3.setEnabled(false);
            System.out.println("Reset");
            count=0;
            mm.setText("00");
            ss.setText("00");
         
            
         }
         
      }
   }
   
   StopWatch(){
      setLayout(new BorderLayout());
      Display t_display=new Display();
      LED = new JPanel(new FlowLayout());
      setLED();
      add(LED,BorderLayout.CENTER);
      Menu=new ButtonPanel();
      add(Menu,BorderLayout.SOUTH);
      pack();
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   void setLED() {
      mm=new JLabel();
      mm.setFont(new Font("Serif",Font.BOLD,50));
      colon=new JLabel();
      colon.setFont(new Font("Serif",Font.BOLD,50));
      ss=new JLabel();
      ss.setFont(new Font("Serif",Font.BOLD,50));
      
   min=String.format("%02d",n1);
   sec=String.format("%02d",n2);
   
   mm.setText(min);
   colon.setText(":");
   ss.setText(sec);
   
   LED.add(mm);
   LED.add(colon);
   LED.add(ss);


   }
   public static void main(String[] args) {
      new StopWatch();
   }
}