package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RSP_draw extends JFrame {

	private JPanel contentPane;

//	public static void main(String[] args) {
//		new RSP_draw();
//	}
	
	public RSP_draw() {
		setBounds(100, 100, 508, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        Border thickBorder_white = new LineBorder(Color.WHITE, 4); //button border default
        Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);
        
		JButton okB = new JButton();
		okB.setBounds(192, 242, 122, 66);
		contentPane.add(okB);
		okB.setContentAreaFilled(false);	//버튼 영역 투명
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
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("img/RSP_draw.png"));
		label.setBounds(5, 5, 480, 356);
		contentPane.add(label);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
