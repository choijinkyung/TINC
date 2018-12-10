package client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.Data;
import util.GameData;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Toolkit;

public class Board extends JFrame {

   private JPanel contentPane;
   static boolean[] flag = new boolean[200]; //버튼 클릭되면 더이상안되게 고정시키는 용도
   private ArrayList<JButton> buttonList = new ArrayList<JButton>();
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	Board frame = new Board(null); //확인
            	frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Board(Client client) {
      setTitle("TINC");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1300, 770);
      
      contentPane = new JPanel();
      //ImageIcon icon = new ImageIcon("image/tincc.jpg");
      //Image img = icon.getImage();
      
      contentPane.setBackground(new Color(245, 222, 179));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      //버튼 초기화
      for(int i=0;i<200;i++) {
         flag[i]=false;
      }
      Border thickBorder_white = new LineBorder(Color.WHITE,4);
      Border thickBorder_orange = new LineBorder(Color.ORANGE,4);
      Border thickBorder_red = new LineBorder(Color.RED,4);
      //box 1번 button 물체 포장 상자
      JButton box = new JButton("");
      box.setToolTipText("\uBB3C\uCCB4/\uD3EC\uC7A5/\uC0C1\uC790");
      //버튼 투명화(배경이 보이게)
      box.setOpaque(false);
      //버튼 내용 투명처리(필수)
      box.setContentAreaFilled(false);
      box.setBorder(thickBorder_white);
      box.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            box.setBorder(thickBorder_red);
            flag[0]=true;
            client.forwardGame(new GameData("GAME", "BUTTON", 0));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[0])
               box.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[0])
               box.setBorder(thickBorder_white);
         }
      });
      box.setBounds(30, 25, 60, 61);
      //buttonList.add(box); //button에 정보넣기
      //buttonList.get(1);   // buttonList[1];
      contentPane.add(box);
      JButton button = new JButton("");
      button.setToolTipText("\uC5EC\uC790/\uC554\uCEF7/\uC5EC\uC131\uC801\uC778");
      button.setOpaque(false);
      button.setContentAreaFilled(false);
      button.setBorder(thickBorder_white);
      button.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button.setBorder(thickBorder_red);
            flag[1] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 1));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[1])
               button.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[1])
               button.setBorder(thickBorder_white);
         }
      });
      button.setBounds(30, 85, 60, 61);
      buttonList.add(button);
      contentPane.add(button);
      
      JButton button_1 = new JButton("");
      button_1.setToolTipText("\uC77C/\uC9C1\uC5C5/\uAE30\uC220");
      button_1.setOpaque(false);
      button_1.setContentAreaFilled(false);
      button_1.setBorder(thickBorder_white);
      button_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_1.setBorder(thickBorder_red);
            flag[2] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 2));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[2])
               button_1.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[2])
               button_1.setBorder(thickBorder_white);
         }
      });
      button_1.setBounds(30, 146, 60, 61);
      buttonList.add(button_1);
      contentPane.add(button_1);
      
      JButton button_2 = new JButton("");
      button_2.setToolTipText("\uC57C\uC0DD/\uB3D9\uBB3C");
      button_2.setOpaque(false);
      button_2.setContentAreaFilled(false);
      button_2.setBorder(thickBorder_white);
      button_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_2.setBorder(thickBorder_red);
            flag[3] = true;
            //client.forwardData(new Data("GAME", "BUTTON", 3)); //server에 눌린거 보내기
            client.forwardGame(new GameData("GAME", "BUTTON", 3));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[3])
               button_2.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[3])
               button_2.setBorder(thickBorder_white);
         }
      });
      button_2.setBounds(32, 209, 60, 55);
      contentPane.add(button_2);
      
      JButton button_3 = new JButton("");
      button_3.setToolTipText("\uBB38\uD654/\uAE00/\uCC45");
      button_3.setOpaque(false);
      button_3.setContentAreaFilled(false);
      button_3.setBorder(thickBorder_white);
      button_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_3.setBorder(thickBorder_red);
            flag[4] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 4));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[4])
               button_3.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[4])
               button_3.setBorder(thickBorder_white);
         }
      });
      button_3.setBounds(32, 263, 60, 61);
      contentPane.add(button_3);
      
      JButton button_4 = new JButton("");
      button_4.setToolTipText("\uC601\uD654\uAD00/\uC601\uD654/\uCE74\uBA54\uB77C");
      button_4.setOpaque(false);
      button_4.setContentAreaFilled(false);
      button_4.setBorder(thickBorder_white);
      button_4.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_4.setBorder(thickBorder_red);
            flag[5] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 5));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[5])
               button_4.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[5])
               button_4.setBorder(thickBorder_white);
         }
      });
      button_4.setBounds(32, 325, 60, 61);
      contentPane.add(button_4);
      
      JButton button_5 = new JButton("");
      button_5.setToolTipText("TV/\uBC29\uC1A1/\uB4DC\uB77C\uB9C8");
      button_5.setOpaque(false);
      button_5.setContentAreaFilled(false);
      button_5.setBorder(thickBorder_white);
      button_5.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_5.setBorder(thickBorder_red);
            flag[6] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 6));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[6])
               button_5.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[6])
               button_5.setBorder(thickBorder_white);
         }
      });
      button_5.setBounds(32, 385, 60, 61);
      contentPane.add(button_5);
      
      JButton button_6 = new JButton("");
      button_6.setToolTipText("\uC544\uC774\uB514\uC5B4/\uC0DD\uAC01/\uAC1C\uB150");
      button_6.setOpaque(false);
      button_6.setContentAreaFilled(false);
      button_6.setBorder(thickBorder_white);
      button_6.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_6.setBorder(thickBorder_red);
            flag[7] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 7));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[7])
               button_6.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[7])
               button_6.setBorder(thickBorder_white);
         }
      });
      button_6.setBounds(32, 443, 60, 61);
      contentPane.add(button_6);
      
      JButton button_7 = new JButton("");
      button_7.setToolTipText("\uC704\uCE58/\uAD6D\uAC00/\uAE43\uBC1C");
      button_7.setOpaque(false);
      button_7.setContentAreaFilled(false);
      button_7.setBorder(thickBorder_white);
      button_7.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_7.setBorder(thickBorder_red);
            flag[8] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 8));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[8])
               button_7.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[8])
               button_7.setBorder(thickBorder_white);
         }
      });
      button_7.setBounds(32, 503, 60, 61);
      contentPane.add(button_7);
      
      JButton button_8 = new JButton("");
      button_8.setToolTipText("\uAC00\uC871/\uC0AC\uD68C/\uC9D1\uB2E8");
      button_8.setOpaque(false);
      button_8.setContentAreaFilled(false);
      button_8.setBorder(thickBorder_white);
      button_8.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_8.setBorder(thickBorder_red);
            flag[9] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 9));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[9])
               button_8.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[9])
               button_8.setBorder(thickBorder_white);
         }
      });
      button_8.setBounds(91, 25, 60, 61);
      contentPane.add(button_8);
      
      JButton button_9 = new JButton("");
      button_9.setToolTipText("\uB0A8\uC790/\uC218\uCEF7/\uB0A8\uC131\uC801\uC778");
      button_9.setOpaque(false);
      button_9.setContentAreaFilled(false);
      button_9.setBorder(thickBorder_white);
      button_9.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_9.setBorder(thickBorder_red);
            flag[10] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 10));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[10])
               button_9.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[10])
               button_9.setBorder(thickBorder_white);
         }
      });
      button_9.setBounds(91, 85, 60, 61);
      contentPane.add(button_9);
      
      JButton button_10 = new JButton("");
      button_10.setToolTipText("\uC5EC\uAC00/\uC2A4\uD3EC\uCE20/\uD65C\uB3D9");
      button_10.setOpaque(false);
      button_10.setContentAreaFilled(false);
      button_10.setBorder(thickBorder_white);
      button_10.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_10.setBorder(thickBorder_red);
            flag[11] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 11));
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[11])
               button_10.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[11])
               button_10.setBorder(thickBorder_white);
         }
      });
      button_10.setBounds(91, 146, 60, 59);
      contentPane.add(button_10);
      
      JButton button_11 = new JButton("");
      button_11.setToolTipText("\uC2DD\uBB3C");
      button_11.setOpaque(false);
      button_11.setContentAreaFilled(false);
      button_11.setBorder(thickBorder_white);
      button_11.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_11.setBorder(thickBorder_red);
            flag[12] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 12));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[12])
               button_11.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[12])
               button_11.setBorder(thickBorder_white);
         }
      });
      button_11.setBounds(91, 206, 60, 61);
      contentPane.add(button_11);
      
      JButton button_12 = new JButton("");
      button_12.setToolTipText("\uC74C\uC545/\uB178\uB798/\uC545\uBCF4");
      button_12.setOpaque(false);
      button_12.setContentAreaFilled(false);
      button_12.setBorder(thickBorder_white);
      button_12.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_12.setBorder(thickBorder_red);
            flag[13] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 13));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[13])
               button_12.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[13])
               button_12.setBorder(thickBorder_white);
         }
      });
      button_12.setBounds(91, 263, 60, 61);
      contentPane.add(button_12);
      
      JButton button_13 = new JButton("");
      button_13.setToolTipText("\uC608\uC220/\uC870\uAC01/\uADF8\uB9BC");
      button_13.setOpaque(false);
      button_13.setContentAreaFilled(false);
      button_13.setBorder(thickBorder_white);
      button_13.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_13.setBorder(thickBorder_red);
            flag[14] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 14));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[14])
               button_13.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[14])
               button_13.setBorder(thickBorder_white);
         }
      });
      button_13.setBounds(92, 325, 60, 61);
      contentPane.add(button_13);
      
      JButton button_14 = new JButton("");
      button_14.setToolTipText("\uC81C\uBAA9/\uC0C1\uD45C");
      button_14.setOpaque(false);
      button_14.setContentAreaFilled(false);
      button_14.setBorder(thickBorder_white);
      button_14.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_14.setBorder(thickBorder_red);
            flag[15] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 15));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[15])
               button_14.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[15])
               button_14.setBorder(thickBorder_white);
         }
      });
      button_14.setBounds(91, 385, 60, 61);
      contentPane.add(button_14);
      
      JButton button_15 = new JButton("");
      button_15.setToolTipText("\uD45C\uD604/\uC5B8\uC5B4/\uB300\uD654/\uB9CC\uD654");
      button_15.setOpaque(false);
      button_15.setContentAreaFilled(false);
      button_15.setBorder(thickBorder_white);
      button_15.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_15.setBorder(thickBorder_red);
            flag[16] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 16));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[16])
               button_15.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[16])
               button_15.setBorder(thickBorder_white);
         }
      });
      button_15.setBounds(91, 442, 60, 61);
      contentPane.add(button_15);
      
      JButton button_16 = new JButton("");
      button_16.setToolTipText("\uAC74\uCD95\uBB3C/\uAC74\uCD95/\uB3C4\uC2DC");
      button_16.setOpaque(false);
      button_16.setContentAreaFilled(false);
      button_16.setBorder(thickBorder_white);
      button_16.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_16.setBorder(thickBorder_red);
            flag[17] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 17));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[17])
               button_16.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[17])
               button_16.setBorder(thickBorder_white);
         }
      });
      button_16.setBounds(91, 503, 60, 61);
      contentPane.add(button_16);
      
      JButton button_17 = new JButton("");
      button_17.setToolTipText("\uB0A0\uC9DC/\uC0AC\uAC74/\uD558\uB8E8");
      button_17.setOpaque(false);
      button_17.setContentAreaFilled(false);
      button_17.setBorder(thickBorder_white);
      button_17.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_17.setBorder(thickBorder_red);
            flag[18] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 18));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[18])
               button_17.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[18])
               button_17.setBorder(thickBorder_white);
         }
      });
      button_17.setBounds(155, 25, 60, 61);
      contentPane.add(button_17);
      
      JButton button_18 = new JButton("");
      button_18.setToolTipText("\uBC30/\uBC14\uB2E4");
      button_18.setOpaque(false);
      button_18.setContentAreaFilled(false);
      button_18.setBorder(thickBorder_white);
      button_18.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_18.setBorder(thickBorder_red);
            flag[19] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 19));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[19])
               button_18.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[19])
               button_18.setBorder(thickBorder_white);
         }
      });
      button_18.setBounds(155, 86, 60, 61);
      contentPane.add(button_18);
      
      JButton button_19 = new JButton("");
      button_19.setToolTipText("\uCC28\uB7C9/\uC2B9\uC6A9\uCC28/\uD0C0\uB2E4");
      button_19.setOpaque(false);
      button_19.setContentAreaFilled(false);
      button_19.setBorder(thickBorder_white);
      button_19.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_19.setBorder(thickBorder_red);
            flag[20] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 20));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[20])
               button_19.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[20])
               button_19.setBorder(thickBorder_white);
         }
      });
      button_19.setBounds(156, 146, 60, 61);
      contentPane.add(button_19);
      
      JButton button_20 = new JButton("");
      button_20.setToolTipText("\uAC8C\uC784/\uC7A5\uB09C\uAC10");
      button_20.setOpaque(false);
      button_20.setContentAreaFilled(false);
      button_20.setBorder(thickBorder_white);
      button_20.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_20.setBorder(thickBorder_red);
            flag[21] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 21));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[21])
               button_20.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[21])
               button_20.setBorder(thickBorder_white);
         }
      });
      button_20.setBounds(155, 203, 60, 61);
      contentPane.add(button_20);
      
      JButton button_21 = new JButton("");
      button_21.setToolTipText("\uC74C\uC2DD/\uC601\uC591/\uBA39\uC744\uC218\uC788\uB294");
      button_21.setOpaque(false);
      button_21.setContentAreaFilled(false);
      button_21.setBorder(thickBorder_white);
      button_21.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_21.setBorder(thickBorder_red);
            flag[22] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 22));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[22])
               button_21.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[22])
               button_21.setBorder(thickBorder_white);
         }
      });
      button_21.setBounds(154, 264, 60, 61);
      contentPane.add(button_21);
      
      JButton button_22 = new JButton("");
      button_22.setToolTipText("\uACF5\uD734\uC77C/\uAE30\uB150\uC77C/\uC0DD\uC77C");
      button_22.setOpaque(false);
      button_22.setContentAreaFilled(false);
      button_22.setBorder(thickBorder_white);
      button_22.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_22.setBorder(thickBorder_red);
            flag[23] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 23));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[23])
               button_22.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[23])
               button_22.setBorder(thickBorder_white);
         }
      });
      button_22.setBounds(215, 25, 60, 61);
      contentPane.add(button_22);
      
      JButton button_23 = new JButton("");
      button_23.setToolTipText("\uD56D\uACF5\uAE30/\uD56D\uACF5\uC0AC/\uB0A0\uB2E4");
      button_23.setOpaque(false);
      button_23.setContentAreaFilled(false);
      button_23.setBorder(thickBorder_white);
      button_23.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_23.setBorder(thickBorder_red);
            flag[24] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 24));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[24])
               button_23.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[24])
               button_23.setBorder(thickBorder_white);
         }
      });
      button_23.setBounds(215, 87, 60, 61);
      contentPane.add(button_23);
      
      JButton button_24 = new JButton("");
      button_24.setToolTipText("\uB3C4\uAD6C");
      button_24.setOpaque(false);
      button_24.setContentAreaFilled(false);
      button_24.setBorder(thickBorder_white);
      button_24.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_24.setBorder(thickBorder_red);
            flag[25] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 25));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[25])
               button_24.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[25])
               button_24.setBorder(thickBorder_white);
         }
      });
      button_24.setBounds(215, 145, 60, 61);
      contentPane.add(button_24);
      
      JButton button_25 = new JButton("");
      button_25.setToolTipText("\uC637/\uC545\uC138\uC11C\uB9AC");
      button_25.setOpaque(false);
      button_25.setContentAreaFilled(false);
      button_25.setBorder(thickBorder_white);
      button_25.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_25.setBorder(thickBorder_red);
            flag[26] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 26));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[26])
               button_25.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[26])
               button_25.setBorder(thickBorder_white);
         }
      });
      button_25.setBounds(213, 206, 60, 61);
      contentPane.add(button_25);
      
      JButton button_26 = new JButton("");
      button_26.setToolTipText("\uC9D1/\uB0B4\uBD80/\uC778\uD14C\uB9AC\uC5B4");
      button_26.setOpaque(false);
      button_26.setContentAreaFilled(false);
      button_26.setBorder(thickBorder_white);
      button_26.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_26.setBorder(thickBorder_red);
            flag[27] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 27));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[27])
               button_26.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[27])
               button_26.setBorder(thickBorder_white);
         }
      });
      button_26.setBounds(214, 265, 60, 65);
      contentPane.add(button_26);
      
      JButton button_27 = new JButton("");
      button_27.setToolTipText("\uACFC\uD559/\uC218\uD559/\uD654\uD559");
      button_27.setOpaque(false);
      button_27.setContentAreaFilled(false);
      button_27.setBorder(thickBorder_white);
      button_27.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_27.setBorder(thickBorder_red);
            flag[28] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 28));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[28])
               button_27.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[28])
               button_27.setBorder(thickBorder_white);
         }
      });
      button_27.setBounds(300, 25, 60, 61);
      contentPane.add(button_27);
      
      JButton button_28 = new JButton("");
      button_28.setToolTipText("\uBA38\uB9AC/\uC5BC\uAD74");
      button_28.setOpaque(false);
      button_28.setContentAreaFilled(false);
      button_28.setBorder(thickBorder_white);
      button_28.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_28.setBorder(thickBorder_red);
            flag[29] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 29));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[29])
               button_28.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[29])
               button_28.setBorder(thickBorder_white);
         }
      });
      button_28.setBounds(299, 84, 60, 61);
      contentPane.add(button_28);
      
      JButton button_29 = new JButton("");
      button_29.setToolTipText("\uBAB8\uD1B5/\uBC30");
      button_29.setOpaque(false);
      button_29.setContentAreaFilled(false);
      button_29.setBorder(thickBorder_white);
      button_29.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_29.setBorder(thickBorder_red);
            flag[30] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 30));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[30])
               button_29.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[30])
               button_29.setBorder(thickBorder_white);
         }
      });
      button_29.setBounds(301, 144, 60, 61);
      contentPane.add(button_29);
      
      JButton button_30 = new JButton("");
      button_30.setToolTipText("\uADC0/\uC18C\uB9AC/\uB4E3\uB2E4");
      button_30.setOpaque(false);
      button_30.setContentAreaFilled(false);
      button_30.setBorder(thickBorder_white);
      button_30.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_30.setBorder(thickBorder_red);
            flag[31] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 31));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[31])
               button_30.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[31])
               button_30.setBorder(thickBorder_white);
         }
      });
      button_30.setBounds(300, 203, 60, 61);
      contentPane.add(button_30);
      
      JButton button_31 = new JButton("");
      button_31.setToolTipText("\uB208/\uC2DC\uC57C/\uBCF4\uB2E4");
      button_31.setOpaque(false);
      button_31.setContentAreaFilled(false);
      button_31.setBorder(thickBorder_white);
      button_31.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_31.setBorder(thickBorder_red);
            flag[32] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 32));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[32])
               button_31.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[32])
               button_31.setBorder(thickBorder_white);
         }
      });
      button_31.setBounds(299, 265, 60, 61);
      contentPane.add(button_31);
      
      JButton button_32 = new JButton("");
      button_32.setToolTipText("\uC758\uD559/\uCE58\uB8CC/\uC57D\uBB3C");
      button_32.setOpaque(false);
      button_32.setContentAreaFilled(false);
      button_32.setBorder(thickBorder_white);
      button_32.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_32.setBorder(thickBorder_red);
            flag[33] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 33));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[33])
               button_32.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[33])
               button_32.setBorder(thickBorder_white);
         }
      });
      button_32.setBounds(362, 25, 60, 61);
      contentPane.add(button_32);
      
      JButton button_33 = new JButton("");
      button_33.setToolTipText("\uD314/\uC190");
      button_33.setOpaque(false);
      button_33.setContentAreaFilled(false);
      button_33.setBorder(thickBorder_white);
      button_33.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_33.setBorder(thickBorder_red);
            flag[34] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 34));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[34])
               button_33.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[34])
               button_33.setBorder(thickBorder_white);
         }
      });
      button_33.setBounds(361, 83, 60, 61);
      contentPane.add(button_33);
      
      JButton button_34 = new JButton("");
      button_34.setToolTipText("\uB2E4\uB9AC/\uBC1C");
      button_34.setOpaque(false);
      button_34.setContentAreaFilled(false);
      button_34.setBorder(thickBorder_white);
      button_34.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_34.setBorder(thickBorder_red);
            flag[35] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 35));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[35])
               button_34.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[35])
               button_34.setBorder(thickBorder_white);
         }
      });
      button_34.setBounds(361, 143, 60, 61);
      contentPane.add(button_34);
      
      JButton button_35 = new JButton("");
      button_35.setToolTipText("\uCF54/\uB0C4\uC0C8");
      button_35.setOpaque(false);
      button_35.setContentAreaFilled(false);
      button_35.setBorder(thickBorder_white);
      button_35.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_35.setBorder(thickBorder_red);
            flag[36] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 36));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[36])
               button_35.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[36])
               button_35.setBorder(thickBorder_white);
         }
      });
      button_35.setBounds(360, 201, 60, 61);
      contentPane.add(button_35);
      
      JButton button_36 = new JButton("");
      button_36.setToolTipText("\uC785/\uB9DB/\uBA39\uB2E4");
      button_36.setOpaque(false);
      button_36.setContentAreaFilled(false);
      button_36.setBorder(thickBorder_white);
      button_36.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_36.setBorder(thickBorder_red);
            flag[37] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 37));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[37])
               button_36.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[37])
               button_36.setBorder(thickBorder_white);
         }
      });
      button_36.setBounds(360, 264, 60, 61);
      contentPane.add(button_36);
      
      JButton button_37 = new JButton("");
      button_37.setToolTipText("\uC2E4\uC874\uD558\uB294\uC5ED\uC0AC");
      button_37.setOpaque(false);
      button_37.setContentAreaFilled(false);
      button_37.setBorder(thickBorder_white);
      button_37.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            button_37.setBorder(thickBorder_red);
            flag[38] = true;
            client.forwardGame(new GameData("GAME", "BUTTON", 38));

         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
            if(!flag[38])
               button_37.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
            if(!flag[38])
               button_37.setBorder(thickBorder_white);
         }
      });
   }
}