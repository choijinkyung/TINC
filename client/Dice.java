package client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//import util.GameData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.GameData;

public class Dice extends JFrame {

	private JPanel contentPane;
	int result;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Dice frame = new Dice(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/*
	 * private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int
	 * resizedHeight) { Image img = icon.getImage(); Image resizedImage =
	 * img.getScaledInstance(resizedWidth, resizedHeight,
	 * java.awt.Image.SCALE_SMOOTH); return new ImageIcon(resizedImage); }
	 */

	public Dice(Client client) {
      setBounds(100, 100, 410, 552);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      Border thickBorder_white = new LineBorder(Color.WHITE,4);
      Border thickBorder_orange = new LineBorder(Color.ORANGE,4);
      
      JLabel display = new JLabel("");
      display.setIcon(new ImageIcon("img/1.png"));
      
      display.setBounds(130, 81, 157, 202);
      contentPane.add(display);
      
      JButton play = new JButton("");
      play.setContentAreaFilled(false);
      play.setBorder(thickBorder_white);
      play.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            int newRoll;
            newRoll= (int)(6*Math.random()+1);
          
            if(newRoll==1) {
                display.setIcon(new ImageIcon("img/1.png"));
	
               JOptionPane.showMessageDialog(null, "1점입니다!", "경고", JOptionPane.WARNING_MESSAGE);
            }
            else if(newRoll==2) {
               display.setIcon(new ImageIcon("img/2.png"));
               
               JOptionPane.showMessageDialog(null, "2점입니다!", "경고", JOptionPane.WARNING_MESSAGE);
            }
            else if(newRoll==3) {
               display.setIcon(new ImageIcon("img/3.png"));
               
               JOptionPane.showMessageDialog(null, "3점입니다!", "경고", JOptionPane.WARNING_MESSAGE);
            }
            else if(newRoll==4) {
               display.setIcon(new ImageIcon("img/4.png"));
               
               JOptionPane.showMessageDialog(null, "4점입니다!", "경고", JOptionPane.WARNING_MESSAGE);
            }
            else if(newRoll==5) {
               display.setIcon(new ImageIcon("img/5.png"));
               
               JOptionPane.showMessageDialog(null, "5점입니다!", "경고", JOptionPane.WARNING_MESSAGE);
            }
            else if(newRoll==6) {
               display.setIcon(new ImageIcon("img/6.png"));
               
               JOptionPane.showMessageDialog(null, "6점입니다!", "경고", JOptionPane.WARNING_MESSAGE);
            }
            result=newRoll;
            client.forwardGame(new GameData("GAME", "DICE", result,client.getWho()));
            dispose();
         }
         @Override
         public void mouseEntered(MouseEvent arg0) {
               play.setBorder(thickBorder_orange);
         }
         @Override
         public void mouseExited(MouseEvent e) {
               play.setBorder(thickBorder_white);
         }
      });
      play.setBounds(101, 403, 208, 75);
      contentPane.add(play);
      JLabel dicelabel = new JLabel("");
      dicelabel.setIcon(new ImageIcon("img/diePlay.png"));
      dicelabel.setBounds(0, 0, 400, 510);
      contentPane.add(dicelabel);
      
      setLocationRelativeTo(null);
      setVisible(true);
   }

}