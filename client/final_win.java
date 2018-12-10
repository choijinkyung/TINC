package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class final_win extends JFrame {

   private JPanel contentPane;

   public final_win() {
        Border thickBorder_white = new LineBorder(Color.WHITE, 4);
         Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);
         Border thickBorder_red = new LineBorder(Color.RED, 4);
               
         
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(0, 0, 597, 383);
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);
         
         
         JButton smallOK = new JButton("");
         smallOK.setBorder(thickBorder_white);
         smallOK.setContentAreaFilled(false); // 버튼 영역 투명
         smallOK.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent arg0) {
                   System.exit(0);
               }
           });
         smallOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
               smallOK.setBorder(thickBorder_orange);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               smallOK.setBorder(thickBorder_white);
            }
         });      
         smallOK.setBounds(227, 233, 100, 63);
         contentPane.add(smallOK);
      
         
         JLabel win = new JLabel("win");
         win.setBounds(0, 0, 575, 334);
         contentPane.add(win);
         win.setIcon(new ImageIcon("img/final_win.PNG"));   
         setLocationRelativeTo(null);
         setVisible(true);
   }

}