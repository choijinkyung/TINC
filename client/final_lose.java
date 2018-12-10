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

public class final_lose extends JFrame {

   private JPanel contentPane;

   public final_lose() {
        Border thickBorder_white = new LineBorder(Color.WHITE, 4);
         Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);
         Border thickBorder_red = new LineBorder(Color.RED, 4);
               
         
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(0, 0, 477, 358);
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         
         
         JButton smallOK = new JButton("");
         smallOK.setBounds(184, 223, 82, 49);
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
         contentPane.setLayout(null);
         contentPane.add(smallOK);
      
         
         JLabel lose = new JLabel("lose");
         lose.setBounds(0, 0, 460, 307);
         contentPane.add(lose);
         lose.setIcon(new ImageIcon("img/final_lose.PNG"));   
         setVisible(true);
   }

}