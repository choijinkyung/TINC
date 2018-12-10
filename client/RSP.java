package client;

import util.Data;
import util.GameData;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RSP extends JFrame {
	private Client client;
	private int rivalHandtemp;
	private int selected;
	private boolean clicked = false;
	private JButton ok;
	private JButton[] hand = new JButton[3];
	private ButtonGroup btnGroup = new ButtonGroup();

//	public static void main(String[] args) {
//		new RSP(null);
//	}

	public RSP(Client client) {
		this.client = client;
		final ActionListener buttonListener = e -> {
			Object source = e.getSource();

			if (source == ok) {
				if (selected < 0 || selected > 2) {
					JOptionPane.showMessageDialog(null, "Error! Exit. Sorry...");
				}
				System.out.println(selected);
				client.forwardGame(new GameData("DATA", "RSP", selected));
				ok.setEnabled(false);
			}
		};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(832, 624);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Border thickBorder_white = new LineBorder(Color.WHITE, 4); // button border default
		Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);
		Border thickBorder_red = new LineBorder(Color.RED, 4);

		hand[0] = new JButton("");
		hand[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!clicked) {
					hand[0].setBorder(thickBorder_red);
					selected=0;
					clicked=true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!clicked) {
					hand[0].setBorder(thickBorder_orange);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!clicked) {
					hand[0].setBorder(thickBorder_white);
				}
			}
		});
		hand[0].setBounds(93, 183, 215, 214);
		hand[0].setContentAreaFilled(false);
		hand[0].setActionCommand("Scissor");
		hand[0].setBorder(thickBorder_white);
		contentPane.add(hand[0]);

		hand[1] = new JButton("");
		hand[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!clicked) {
					hand[1].setBorder(thickBorder_red);
					selected = 1;
					clicked = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!clicked) {
					hand[1].setBorder(thickBorder_orange);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!clicked) {
					hand[1].setBorder(thickBorder_white);
				}
			}
		});
		hand[1].setBounds(311, 183, 215, 214);
		hand[1].setContentAreaFilled(false);
		hand[1].setActionCommand("Rock");
		hand[1].setBorder(thickBorder_white);
		contentPane.add(hand[1]);

		hand[2] = new JButton("");
		hand[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!clicked) {
					hand[2].setBorder(thickBorder_red);
					selected = 2;
					clicked = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!clicked) {
					hand[2].setBorder(thickBorder_orange);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!clicked) {
					hand[2].setBorder(thickBorder_white);
				}
			}
		});
		hand[2].setBounds(525, 183, 215, 214);
		hand[2].setContentAreaFilled(false);
		hand[2].setActionCommand("Paper");
		hand[2].setBorder(thickBorder_white);
		contentPane.add(hand[2]);

//        for (JRadioButton i : hand)
//            btnGroup.add(i);

		ok = new JButton();
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ok.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ok.setBorder(thickBorder_white);
			}
		});
		ok.setBounds(356, 477, 123, 68);
		ok.setOpaque(false);
		ok.setContentAreaFilled(false);
		ok.setBorder(thickBorder_white);
		ok.addActionListener(buttonListener);
		contentPane.add(ok);

		JLabel label = new JLabel("");
		label.setBounds(5, 5, 804, 567);
		label.setIcon(new ImageIcon("img/rsp.png"));
		contentPane.add(label);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void setData(GameData result) { // 가위바위보 결과 보여주기
		switch (result.getAction()) {
		case "DRAW":
			System.out.println("DRAW");
			RSP_draw draw = new RSP_draw();
			clicked=false;
			ok.setEnabled(true);
			break;
		case "WIN":
			System.out.println("WIN");
			RSP_winner winner = new RSP_winner(result.getData(), this.client);
			break;
		case "LOSE":
			System.out.println("LOSE");
			RSP_loser loser = new RSP_loser(this.client);
			break;
		}
	}
}
