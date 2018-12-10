package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Opp_correct extends JFrame {

	private JPanel contentPane;

	public Opp_correct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel win = new JLabel("win");
		win.setBounds(0, 0, 470, 361);
		contentPane.add(win);
		win.setIcon(new ImageIcon("img/opp_correct.PNG"));
		 setLocationRelativeTo(null);
		setVisible(true);
	}

}