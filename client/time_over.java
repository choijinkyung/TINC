package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.event.*;

public class time_over extends JFrame {

   private JPanel contentPane;

//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               time_over frame = new time_over();
//               frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   public time_over() {
      
      Border thickBorder_white = new LineBorder(Color.WHITE, 4);
      Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);
      Border thickBorder_red = new LineBorder(Color.RED, 4);
            
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(0, 0, 498, 312);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      
      JButton smallOK = new JButton("");
      smallOK.setBorder(thickBorder_white);
      smallOK.setContentAreaFilled(false); // 버튼 영역 투명
      smallOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
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
      smallOK.setBounds(178, 172, 111, 53);
      contentPane.add(smallOK);
   
      
      JLabel lblNewLabel = new JLabel("New label");
      lblNewLabel.setBounds(0, 0, 472, 251);
      contentPane.add(lblNewLabel);
      setLocationRelativeTo(null);
      lblNewLabel.setIcon(new ImageIcon("img/timeover.PNG"));   

   }

}