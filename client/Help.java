package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Help extends JFrame {

	private JPanel contentPane;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Help frame = new Help();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public Help() {
		CardLayout cards=new CardLayout();
		
		setSize(1300,770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cards);
		
		JPanel help1Panel = new JPanel();
		contentPane.add(help1Panel, "name_561317523937909");
		help1Panel.setLayout(null);
		
		JButton btnNewButton = new JButton();
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cards.next(contentPane);
			}
		});
		btnNewButton.setBounds(1207, 650, 63, 63);
		help1Panel.add(btnNewButton);
		btnNewButton.setBorderPainted(false);	//버튼 테두리 투명
		btnNewButton.setContentAreaFilled(false);	//버튼 영역 투명
		
		JLabel help1 = new JLabel();
		help1.setBounds(0, -27, 1300, 770);
		help1.setIcon(new ImageIcon("img/help1.png"));
		help1Panel.add(help1);
		
		JPanel help2Panel = new JPanel();
		contentPane.add(help2Panel, "name_561320674182539");
		help2Panel.setLayout(null);
		
		contentPane.add("one",help1Panel);
		contentPane.add("two", help2Panel);
		
		JButton button = new JButton();
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cards.next(contentPane);
			}
		});
		button.setBounds(0, 649, 77, 64);
		help2Panel.add(button);
		button.setBorderPainted(false);	//버튼 테두리 투명
		button.setContentAreaFilled(false);	//버튼 영역 투명
		
		JLabel help2 = new JLabel();
		help2.setBounds(0, 0, 1280, 720);
		help2.setIcon(new ImageIcon("img/help2.png"));
		help2Panel.add(help2);

		setLocationRelativeTo(null);
		setVisible(true);
	}

}
