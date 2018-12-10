package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.Data;
import util.GameData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Initial extends JFrame {

	private JPanel contentPane;
	JLabel initial = new JLabel();
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Initial frame = new Initial();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public Initial() {
		setBounds(100, 100, 570, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        Border thickBorder_white = new LineBorder(Color.WHITE, 4); //button border default
        Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);
        
		JButton okB = new JButton("");
		okB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
            	okB.setBorder(thickBorder_orange);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	okB.setBorder(thickBorder_white);
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
        });
		okB.setBorder(thickBorder_white);
		
		okB.setBounds(230, 257, 100, 64);
		contentPane.add(okB);
		okB.setContentAreaFilled(false);	//버튼 영역 투명
		initial.setHorizontalAlignment(SwingConstants.CENTER);
		
		initial.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		initial.setBounds(154, 145, 254, 81);
		contentPane.add(initial);
		
		JLabel label = new JLabel();
		label.setBounds(5, 5, 542, 373);
		label.setIcon(new ImageIcon("img/initial.png"));
		contentPane.add(label);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void setData(GameData data) {	//로그인 결과를 알려주는 메소드
        initial.setText(data.getAction());
    }
}
