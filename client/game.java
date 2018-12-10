package client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.Data;
import util.GameData;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class game extends JFrame {
	private Chat_panel chatPanel;
	private JPanel contentPane;
	static boolean[] flag = new boolean[200]; // 버튼 클릭되면 더이상안되게 고정시키는 용도
	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	private JTextField textField;
	int score1=0,score2=0;
	JLabel scoreP1,scoreP2;
	Timer timer;
	Client thisclient;
	Border thickBorder_white = new LineBorder(Color.WHITE, 4);
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					game frame = new game(null); // 확인
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public ArrayList<JButton> getButtonList() {
		return buttonList;
	}
	public void resetBoard() {
		//?
	}
	public game(Client client) {
		thisclient=client;
		setTitle("TINC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 770);

		contentPane = new JPanel();

		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 버튼 초기화
		for (int i = 0; i < 200; i++) {
			flag[i] = false;
		}

		Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);
		Border thickBorder_red = new LineBorder(Color.RED, 4);
		// box 1번 button 물체 포장 상자
		JButton box = new JButton("");
		box.setToolTipText("\uBB3C\uCCB4/\uD3EC\uC7A5/\uC0C1\uC790");
		// 버튼 투명화(배경이 보이게)
		box.setOpaque(false);
		// 버튼 내용 투명처리(필수)
		box.setContentAreaFilled(false);
		box.setBorder(thickBorder_white);
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				box.setBorder(thickBorder_red);
				flag[0] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 0));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[0])
					box.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[0])
					box.setBorder(thickBorder_white);
			}
		});
		box.setBounds(30, 25, 60, 61);
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
				if (!flag[1])
					button.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[1])
					button.setBorder(thickBorder_white);
			}
		});
		button.setBounds(30, 85, 60, 61);
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
				if (!flag[2])
					button_1.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[2])
					button_1.setBorder(thickBorder_white);
			}
		});
		button_1.setBounds(30, 146, 60, 61);
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
				// client.forwardData(new Data("GAME", "BUTTON", 3)); //server에 눌린거 보내기
				client.forwardGame(new GameData("GAME", "BUTTON", 3));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[3])
					button_2.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[3])
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
				if (!flag[4])
					button_3.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[4])
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
				if (!flag[5])
					button_4.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[5])
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
				if (!flag[6])
					button_5.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[6])
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
				if (!flag[7])
					button_6.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[7])
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
				if (!flag[8])
					button_7.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[8])
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
				if (!flag[9])
					button_8.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[9])
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
				if (!flag[10])
					button_9.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[10])
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
				if (!flag[11])
					button_10.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[11])
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
				if (!flag[12])
					button_11.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[12])
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
				if (!flag[13])
					button_12.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[13])
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
				if (!flag[14])
					button_13.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[14])
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
				if (!flag[15])
					button_14.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[15])
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
				if (!flag[16])
					button_15.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[16])
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
				if (!flag[17])
					button_16.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[17])
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
				if (!flag[18])
					button_17.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[18])
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
				if (!flag[19])
					button_18.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[19])
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
				if (!flag[20])
					button_19.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[20])
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
				if (!flag[21])
					button_20.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[21])
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
				if (!flag[22])
					button_21.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[22])
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
				if (!flag[23])
					button_22.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[23])
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
				if (!flag[24])
					button_23.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[24])
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
				if (!flag[25])
					button_24.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[25])
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
				if (!flag[26])
					button_25.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[26])
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
				if (!flag[27])
					button_26.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[27])
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
				if (!flag[28])
					button_27.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[28])
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
				if (!flag[29])
					button_28.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[29])
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
				if (!flag[30])
					button_29.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[30])
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
				if (!flag[31])
					button_30.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[31])
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
				if (!flag[32])
					button_31.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[32])
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
				if (!flag[33])
					button_32.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[33])
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
				if (!flag[34])
					button_33.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[34])
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
				if (!flag[35])
					button_34.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[35])
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
				if (!flag[36])
					button_35.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[36])
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
				if (!flag[37])
					button_36.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[37])
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
				if (!flag[38])
					button_37.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[38])
					button_37.setBorder(thickBorder_white);
			}
		});
		button_37.setBounds(428, 25, 60, 61);
		contentPane.add(button_37);

		JButton button_38 = new JButton("");
		button_38.setToolTipText("\uC0C8\uB85C\uC6B4/\uC544\uC774");
		button_38.setOpaque(false);
		button_38.setContentAreaFilled(false);
		button_38.setBorder(thickBorder_white);
		button_38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_38.setBorder(thickBorder_red);
				flag[39] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 39));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[39])
					button_38.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[39])
					button_38.setBorder(thickBorder_white);
			}
		});
		button_38.setBounds(428, 84, 60, 61);
		contentPane.add(button_38);

		JButton button_39 = new JButton("");
		button_39.setToolTipText("\uB290\uB9B0/\uAC70\uBD81");
		button_39.setOpaque(false);
		button_39.setContentAreaFilled(false);
		button_39.setBorder(thickBorder_white);
		button_39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_39.setBorder(thickBorder_red);
				flag[40] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 40));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[40])
					button_39.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[40])
					button_39.setBorder(thickBorder_white);
			}
		});
		button_39.setBounds(428, 144, 60, 61);
		contentPane.add(button_39);

		JButton button_40 = new JButton("");
		button_40.setToolTipText("\uBC29\uC5B4/\uBCF4\uD638/\uCC45");
		button_40.setOpaque(false);
		button_40.setContentAreaFilled(false);
		button_40.setBorder(thickBorder_white);
		button_40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_40.setBorder(thickBorder_red);
				flag[41] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 41));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[41])
					button_40.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[41])
					button_40.setBorder(thickBorder_white);
			}
		});
		button_40.setBounds(429, 203, 60, 61);
		contentPane.add(button_40);

		JButton button_41 = new JButton("");
		button_41.setToolTipText("\uC0DD\uBA85/\uC2EC\uC7A5/\uC0AC\uB791");
		button_41.setOpaque(false);
		button_41.setContentAreaFilled(false);
		button_41.setBorder(thickBorder_white);
		button_41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_41.setBorder(thickBorder_red);
				flag[42] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 42));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[42])
					button_41.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[42])
					button_41.setBorder(thickBorder_white);
			}
		});
		button_41.setBounds(428, 266, 63, 57);
		contentPane.add(button_41);

		JButton button_42 = new JButton("");
		button_42.setToolTipText("\uC990\uAC81\uB2E4/\uAE0D\uC815\uC801\uC778");
		button_42.setOpaque(false);
		button_42.setContentAreaFilled(false);
		button_42.setBorder(thickBorder_white);
		button_42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_42.setBorder(thickBorder_red);
				flag[43] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 43));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[43])
					button_42.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[43])
					button_42.setBorder(thickBorder_white);
			}
		});
		button_42.setBounds(427, 325, 64, 61);
		contentPane.add(button_42);

		JButton button_43 = new JButton("");
		button_43.setToolTipText("\uC804\uC790/\uCEF4\uD4E8\uD130");
		button_43.setOpaque(false);
		button_43.setContentAreaFilled(false);
		button_43.setBorder(thickBorder_white);
		button_43.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_43.setBorder(thickBorder_red);
				flag[44] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 44));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[44])
					button_43.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[44])
					button_43.setBorder(thickBorder_white);
			}
		});
		button_43.setBounds(429, 384, 60, 61);
		contentPane.add(button_43);

		JButton button_44 = new JButton("");
		button_44.setToolTipText("\uB3C8/\uBD80\uC790/\uBE44\uC2FC");
		button_44.setOpaque(false);
		button_44.setContentAreaFilled(false);
		button_44.setBorder(thickBorder_white);
		button_44.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_44.setBorder(thickBorder_red);
				flag[45] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 45));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[45])
					button_44.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[45])
					button_44.setBorder(thickBorder_white);
			}
		});
		button_44.setBounds(429, 442, 60, 61);
		contentPane.add(button_44);

		JButton button_45 = new JButton("");
		button_45.setToolTipText("\uC885\uAD50/\uC2E0\uD654/\uBBFF\uC74C");
		button_45.setOpaque(false);
		button_45.setContentAreaFilled(false);
		button_45.setBorder(thickBorder_white);
		button_45.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_45.setBorder(thickBorder_red);
				flag[46] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 46));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[46])
					button_45.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[46])
					button_45.setBorder(thickBorder_white);
			}
		});
		button_45.setBounds(426, 504, 66, 61);
		contentPane.add(button_45);

		JButton button_46 = new JButton("");
		button_46.setToolTipText("\uD5C8\uAD6C\uC758/\uACF5\uC0C1");
		button_46.setOpaque(false);
		button_46.setContentAreaFilled(false);
		button_46.setBorder(thickBorder_white);
		button_46.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_46.setBorder(thickBorder_red);
				flag[47] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 47));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[47])
					button_46.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[47])
					button_46.setBorder(thickBorder_white);
			}
		});
		button_46.setBounds(493, 25, 60, 61);
		contentPane.add(button_46);

		JButton button_47 = new JButton("");
		button_47.setToolTipText("\uB299\uC740/\uC624\uB798\uB41C/\uACFC\uAC70");
		button_47.setOpaque(false);
		button_47.setContentAreaFilled(false);
		button_47.setBorder(thickBorder_white);
		button_47.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_47.setBorder(thickBorder_red);
				flag[48] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 48));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[48])
					button_47.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[48])
					button_47.setBorder(thickBorder_white);
			}
		});
		button_47.setBounds(492, 83, 61, 61);
		contentPane.add(button_47);

		JButton button_48 = new JButton("");
		button_48.setToolTipText("\uBE60\uB978/\uD1A0\uB07C/\uC2E0\uC18D\uD55C");
		button_48.setOpaque(false);
		button_48.setContentAreaFilled(false);
		button_48.setBorder(thickBorder_white);
		button_48.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_48.setBorder(thickBorder_red);
				flag[49] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 49));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[49])
					button_48.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[49])
					button_48.setBorder(thickBorder_white);
			}
		});
		button_48.setBounds(492, 147, 65, 56);
		contentPane.add(button_48);

		JButton button_49 = new JButton("");
		button_49.setToolTipText("\uB300\uB9BD/\uBB34\uAE30/\uC2F8\uC6C0");
		button_49.setOpaque(false);
		button_49.setContentAreaFilled(false);
		button_49.setBorder(thickBorder_white);
		button_49.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_49.setBorder(thickBorder_red);
				flag[50] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 50));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[50])
					button_49.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[50])
					button_49.setBorder(thickBorder_white);
			}
		});
		button_49.setBounds(491, 204, 62, 61);
		contentPane.add(button_49);

		JButton button_50 = new JButton("");
		button_50.setToolTipText("\uC8FD\uC74C/\uC9C8\uBCD1/\uC545");
		button_50.setOpaque(false);
		button_50.setContentAreaFilled(false);
		button_50.setBorder(thickBorder_white);
		button_50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_50.setBorder(thickBorder_red);
				flag[51] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 51));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[51])
					button_50.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[51])
					button_50.setBorder(thickBorder_white);
			}
		});
		button_50.setBounds(492, 263, 61, 61);
		contentPane.add(button_50);

		JButton button_51 = new JButton("");
		button_51.setToolTipText("\uC2AC\uD504\uB2E4/\uBD80\uC815\uC801\uC778");
		button_51.setOpaque(false);
		button_51.setContentAreaFilled(false);
		button_51.setBorder(thickBorder_white);
		button_51.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_51.setBorder(thickBorder_red);
				flag[52] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 52));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[52])
					button_51.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[52])
					button_51.setBorder(thickBorder_white);
			}
		});
		button_51.setBounds(491, 325, 65, 61);
		contentPane.add(button_51);

		JButton button_52 = new JButton("");
		button_52.setToolTipText("\uAE30\uACC4");
		button_52.setOpaque(false);
		button_52.setContentAreaFilled(false);
		button_52.setBorder(thickBorder_white);
		button_52.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_52.setBorder(thickBorder_red);
				flag[53] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 53));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[53])
					button_52.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[53])
					button_52.setBorder(thickBorder_white);
			}
		});
		button_52.setBounds(492, 387, 61, 55);
		contentPane.add(button_52);

		JButton button_53 = new JButton("");
		button_53.setToolTipText("\uC2DC\uAC04/\uAE30\uAC04");
		button_53.setOpaque(false);
		button_53.setContentAreaFilled(false);
		button_53.setBorder(thickBorder_white);
		button_53.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_53.setBorder(thickBorder_red);
				flag[54] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 54));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[54])
					button_53.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[54])
					button_53.setBorder(thickBorder_white);
			}
		});
		button_53.setBounds(493, 443, 60, 61);
		contentPane.add(button_53);

		JButton button_54 = new JButton("");
		button_54.setToolTipText("\uD798/\uAD8C\uB825/\uC815\uCE58");
		button_54.setOpaque(false);
		button_54.setContentAreaFilled(false);
		button_54.setBorder(thickBorder_white);
		button_54.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_54.setBorder(thickBorder_red);
				flag[55] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 55));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[55])
					button_54.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[55])
					button_54.setBorder(thickBorder_white);
			}
		});
		button_54.setBounds(493, 503, 60, 61);
		contentPane.add(button_54);

		JButton button_55 = new JButton("");
		button_55.setToolTipText("\uAD6C\uB984/\uBE44/\uCC28\uAC11\uB2E4");
		button_55.setOpaque(false);
		button_55.setContentAreaFilled(false);
		button_55.setBorder(thickBorder_white);
		button_55.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_55.setBorder(thickBorder_red);
				flag[56] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 56));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[56])
					button_55.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[56])
					button_55.setBorder(thickBorder_white);
			}
		});
		button_55.setBounds(587, 25, 60, 53);
		contentPane.add(button_55);

		JButton button_56 = new JButton(" ");
		button_56.setToolTipText("\uBC24/\uC800\uB141/\uB2EC");
		button_56.setOpaque(false);
		button_56.setContentAreaFilled(false);
		button_56.setBorder(thickBorder_white);
		button_56.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_56.setBorder(thickBorder_red);
				flag[57] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 57));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[57])
					button_56.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[57])
					button_56.setBorder(thickBorder_white);
			}
		});
		button_56.setBounds(587, 84, 60, 55);
		contentPane.add(button_56);

		JButton button_57 = new JButton(" ");
		button_57.setToolTipText("\uBD88/\uD0C0\uB2E4");
		button_57.setOpaque(false);
		button_57.setContentAreaFilled(false);
		button_57.setBorder(thickBorder_white);
		button_57.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_57.setBorder(thickBorder_red);
				flag[58] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 58));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[58])
					button_57.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[58])
					button_57.setBorder(thickBorder_white);
			}
		});
		button_57.setBounds(587, 140, 60, 61);
		contentPane.add(button_57);

		JButton button_58 = new JButton(" ");
		button_58.setToolTipText("\uACF5\uAE30/\uBC14\uB78C");
		button_58.setOpaque(false);
		button_58.setContentAreaFilled(false);
		button_58.setBorder(thickBorder_white);
		button_58.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_58.setBorder(thickBorder_red);
				flag[59] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 59));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[59])
					button_58.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[59])
					button_58.setBorder(thickBorder_white);
			}
		});
		button_58.setBounds(586, 201, 60, 59);
		contentPane.add(button_58);

		JButton button_59 = new JButton(" ");
		button_59.setToolTipText("\uB3CC/\uAD11\uBB3C/\uB2E8\uB2E8\uD558\uB2E4");
		button_59.setOpaque(false);
		button_59.setContentAreaFilled(false);
		button_59.setBorder(thickBorder_white);
		button_59.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_59.setBorder(thickBorder_red);
				flag[60] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 60));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[60])
					button_59.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[60])
					button_59.setBorder(thickBorder_white);
			}
		});
		button_59.setBounds(586, 261, 60, 61);
		contentPane.add(button_59);

		JButton button_60 = new JButton(" ");
		button_60.setToolTipText("\uAE08\uC18D");
		button_60.setOpaque(false);
		button_60.setContentAreaFilled(false);
		button_60.setBorder(thickBorder_white);
		button_60.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_60.setBorder(thickBorder_red);
				flag[61] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 61));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[61])
					button_60.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[61])
					button_60.setBorder(thickBorder_white);
			}
		});
		button_60.setBounds(586, 320, 60, 61);
		contentPane.add(button_60);

		JButton button_61 = new JButton(" ");
		button_61.setToolTipText("\uD50C\uB77C\uC2A4\uD2F1/\uACE0\uBB34");
		button_61.setOpaque(false);
		button_61.setContentAreaFilled(false);
		button_61.setBorder(thickBorder_white);
		button_61.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_61.setBorder(thickBorder_red);
				flag[62] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 62));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[62])
					button_61.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[62])
					button_61.setBorder(thickBorder_white);
			}
		});
		button_61.setBounds(586, 379, 60, 61);
		contentPane.add(button_61);

		JButton button_62 = new JButton(" ");
		button_62.setToolTipText("\uBC18\uB300/\uB4A4\uC9D1\uB2E4");
		button_62.setOpaque(false);
		button_62.setContentAreaFilled(false);
		button_62.setBorder(thickBorder_white);
		button_62.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_62.setBorder(thickBorder_red);
				flag[63] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 63));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[63])
					button_62.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[63])
					button_62.setBorder(thickBorder_white);
			}
		});
		button_62.setBounds(586, 443, 60, 56);
		contentPane.add(button_62);

		JButton button_63 = new JButton("");
		button_63.setToolTipText("\uC870\uAC01/\uB2E4\uC218\uC758/\uAC00\uB8E8");
		button_63.setOpaque(false);
		button_63.setContentAreaFilled(false);
		button_63.setBorder(thickBorder_white);
		button_63.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_63.setBorder(thickBorder_red);
				flag[64] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 64));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[64])
					button_63.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[64])
					button_63.setBorder(thickBorder_white);
			}
		});
		button_63.setBounds(586, 497, 60, 61);
		contentPane.add(button_63);

		JButton button_64 = new JButton(" ");
		button_64.setToolTipText("\uBC88\uAC1C/\uC804\uAE30/\uBD84\uB178");
		button_64.setOpaque(false);
		button_64.setContentAreaFilled(false);
		button_64.setBorder(thickBorder_white);
		button_64.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_64.setBorder(thickBorder_red);
				flag[65] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 65));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[65])
					button_64.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[65])
					button_64.setBorder(thickBorder_white);
			}
		});
		button_64.setBounds(650, 25, 60, 57);
		contentPane.add(button_64);

		JButton button_65 = new JButton(" ");
		button_65.setToolTipText("\uD0DC\uC591/\uB530\uB73B\uD558\uB2E4/\uBE5B");
		button_65.setOpaque(false);
		button_65.setContentAreaFilled(false);
		button_65.setBorder(thickBorder_white);
		button_65.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_65.setBorder(thickBorder_red);
				flag[66] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 66));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[66])
					button_65.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[66])
					button_65.setBorder(thickBorder_white);
			}
		});
		button_65.setBounds(650, 80, 60, 61);
		contentPane.add(button_65);

		JButton button_66 = new JButton(" ");
		button_66.setToolTipText("\uBB3C/\uC561\uCCB4/\uBB3C\uC5D0\uC0AC\uB294");
		button_66.setOpaque(false);
		button_66.setContentAreaFilled(false);
		button_66.setBorder(thickBorder_white);
		button_66.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_66.setBorder(thickBorder_red);
				flag[67] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 67));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[67])
					button_66.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[67])
					button_66.setBorder(thickBorder_white);
			}
		});
		button_66.setBounds(649, 139, 62, 61);
		contentPane.add(button_66);

		JButton button_67 = new JButton(" ");
		button_67.setToolTipText("\uB545/\uD759");
		button_67.setOpaque(false);
		button_67.setContentAreaFilled(false);
		button_67.setBorder(thickBorder_white);
		button_67.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_67.setBorder(thickBorder_red);
				flag[68] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 68));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[68])
					button_67.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[68])
					button_67.setBorder(thickBorder_white);
			}
		});
		button_67.setBounds(649, 199, 62, 61);
		contentPane.add(button_67);

		JButton button_68 = new JButton(" ");
		button_68.setToolTipText("\uB098\uBB34");
		button_68.setOpaque(false);
		button_68.setContentAreaFilled(false);
		button_68.setBorder(thickBorder_white);
		button_68.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_68.setBorder(thickBorder_red);
				flag[69] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 69));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[69])
					button_68.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[69])
					button_68.setBorder(thickBorder_white);
			}
		});
		button_68.setBounds(650, 261, 60, 61);
		contentPane.add(button_68);

		JButton button_69 = new JButton(" ");
		button_69.setToolTipText("\uCC9C/\uC12C\uC720");
		button_69.setOpaque(false);
		button_69.setContentAreaFilled(false);
		button_69.setBorder(thickBorder_white);
		button_69.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_69.setBorder(thickBorder_red);
				flag[70] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 70));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[70])
					button_69.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[70])
					button_69.setBorder(thickBorder_white);
			}
		});
		button_69.setBounds(651, 319, 60, 61);
		contentPane.add(button_69);

		JButton button_70 = new JButton(" ");
		button_70.setToolTipText("\uC885\uC774");
		button_70.setOpaque(false);
		button_70.setContentAreaFilled(false);
		button_70.setBorder(thickBorder_white);
		button_70.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_70.setBorder(thickBorder_red);
				flag[71] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 71));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[71])
					button_70.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[71])
					button_70.setBorder(thickBorder_white);
			}
		});
		button_70.setBounds(651, 378, 60, 61);
		contentPane.add(button_70);

		JButton button_71 = new JButton(" ");
		button_71.setToolTipText("\uC790\uB974\uB2E4/\uB098\uB204\uB2E4/\uC808\uBC18");
		button_71.setOpaque(false);
		button_71.setContentAreaFilled(false);
		button_71.setBorder(thickBorder_white);
		button_71.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_71.setBorder(thickBorder_red);
				flag[72] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 72));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[72])
					button_71.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[72])
					button_71.setBorder(thickBorder_white);
			}
		});
		button_71.setBounds(650, 443, 60, 54);
		contentPane.add(button_71);

		JButton button_72 = new JButton(" ");
		button_72.setToolTipText("\uC77C\uBD80/\uC870\uAE08");
		button_72.setOpaque(false);
		button_72.setContentAreaFilled(false);
		button_72.setBorder(thickBorder_white);
		button_72.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_72.setBorder(thickBorder_red);
				flag[73] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 73));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[73])
					button_72.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[73])
					button_72.setBorder(thickBorder_white);
			}
		});
		button_72.setBounds(649, 500, 60, 55);
		contentPane.add(button_72);

		JButton button_73 = new JButton(" ");
		button_73.setToolTipText("\uB192\uB2E4/\uD06C\uB2E4/\uB354\uD06C\uB2E4");
		button_73.setOpaque(false);
		button_73.setContentAreaFilled(false);
		button_73.setBorder(thickBorder_white);
		button_73.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_73.setBorder(thickBorder_red);
				flag[74] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 74));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[74])
					button_73.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[74])
					button_73.setBorder(thickBorder_white);
			}
		});
		button_73.setBounds(740, 21, 60, 65);
		contentPane.add(button_73);

		JButton button_74 = new JButton(" ");
		button_74.setToolTipText("\uAC70\uB300\uD55C/\uB354\uB113\uB2E4/\uB354\uAE38\uB2E4");
		button_74.setOpaque(false);
		button_74.setContentAreaFilled(false);
		button_74.setBorder(thickBorder_white);
		button_74.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_74.setBorder(thickBorder_red);
				flag[75] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 75));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[75])
					button_74.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[75])
					button_74.setBorder(thickBorder_white);
			}
		});
		button_74.setBounds(741, 85, 60, 65);
		contentPane.add(button_74);

		JButton button_75 = new JButton(" ");
		button_75.setToolTipText("\uAF2D\uB300\uAE30/\uC0C1\uC2B9/\uC624\uB974\uB2E4");
		button_75.setOpaque(false);
		button_75.setContentAreaFilled(false);
		button_75.setBorder(thickBorder_white);
		button_75.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_75.setBorder(thickBorder_red);
				flag[76] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 76));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[76])
					button_75.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[76])
					button_75.setBorder(thickBorder_white);
			}
		});
		button_75.setBounds(741, 151, 60, 65);
		contentPane.add(button_75);

		JButton button_76 = new JButton(" ");
		button_76.setToolTipText("\uC67C\uCABD/\uBA3C\uC800/\uC774\uC804");
		button_76.setOpaque(false);
		button_76.setContentAreaFilled(false);
		button_76.setBorder(thickBorder_white);
		button_76.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_76.setBorder(thickBorder_red);
				flag[77] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 77));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[77])
					button_76.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[77])
					button_76.setBorder(thickBorder_white);
			}
		});
		button_76.setBounds(741, 219, 60, 65);
		contentPane.add(button_76);

		JButton button_77 = new JButton(" ");
		button_77.setToolTipText("\uB3CC\uB2E4/\uB458\uB7EC\uC2F8\uB2E4/\uC21C\uD658");
		button_77.setOpaque(false);
		button_77.setContentAreaFilled(false);
		button_77.setBorder(thickBorder_white);
		button_77.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_77.setBorder(thickBorder_red);
				flag[78] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 78));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[78])
					button_77.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[78])
					button_77.setBorder(thickBorder_white);
			}
		});
		button_77.setBounds(741, 286, 60, 65);
		contentPane.add(button_77);

		JButton button_78 = new JButton(" ");
		button_78.setToolTipText("\uC791\uB2E4/\uB354\uB0AE\uB2E4");
		button_78.setOpaque(false);
		button_78.setContentAreaFilled(false);
		button_78.setBorder(thickBorder_white);
		button_78.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_78.setBorder(thickBorder_red);
				flag[79] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 79));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[79])
					button_78.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[79])
					button_78.setBorder(thickBorder_white);
			}
		});
		button_78.setBounds(809, 21, 60, 65);
		contentPane.add(button_78);

		JButton button_79 = new JButton(" ");
		button_79.setToolTipText("\uB9C8\uB978/\uB354\uAC00\uAE5D\uB2E4/\uC9E7\uC740");
		button_79.setOpaque(false);
		button_79.setContentAreaFilled(false);
		button_79.setBorder(thickBorder_white);
		button_79.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_79.setBorder(thickBorder_red);
				flag[80] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 80));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[80])
					button_79.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[80])
					button_79.setBorder(thickBorder_white);
			}
		});
		button_79.setBounds(809, 86, 60, 65);
		contentPane.add(button_79);

		JButton button_80 = new JButton(" ");
		button_80.setToolTipText("\uB0AE\uB2E4/\uD558\uB77D/\uB5A8\uC5B4\uC9C0\uB2E4");
		button_80.setOpaque(false);
		button_80.setContentAreaFilled(false);
		button_80.setBorder(thickBorder_white);
		button_80.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_80.setBorder(thickBorder_red);
				flag[81] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 81));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[81])
					button_80.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[81])
					button_80.setBorder(thickBorder_white);
			}
		});
		button_80.setBounds(809, 152, 60, 65);
		contentPane.add(button_80);

		JButton button_81 = new JButton(" ");
		button_81.setToolTipText("\uC624\uB978\uCABD/\uB098\uC911/\uB9C8\uC9C0\uB9C9");
		button_81.setOpaque(false);
		button_81.setContentAreaFilled(false);
		button_81.setBorder(thickBorder_white);
		button_81.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_81.setBorder(thickBorder_red);
				flag[82] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 82));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[82])
					button_81.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[82])
					button_81.setBorder(thickBorder_white);
			}
		});
		button_81.setBounds(810, 220, 60, 65);
		contentPane.add(button_81);

		JButton button_82 = new JButton(" ");
		button_82.setToolTipText("\uC0AC\uC6A9\uD558\uB2E4/\uC791\uB3D9\uD558\uB2E4");
		button_82.setOpaque(false);
		button_82.setContentAreaFilled(false);
		button_82.setBorder(thickBorder_white);
		button_82.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_82.setBorder(thickBorder_red);
				flag[83] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 83));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[83])
					button_82.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[83])
					button_82.setBorder(thickBorder_white);
			}
		});
		button_82.setBounds(809, 287, 60, 65);
		contentPane.add(button_82);

		JButton button_83 = new JButton(" ");
		button_83.setToolTipText("\uC548\uCABD/\uB0B4\uBD80");
		button_83.setOpaque(false);
		button_83.setContentAreaFilled(false);
		button_83.setBorder(thickBorder_white);
		button_83.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_83.setBorder(thickBorder_red);
				flag[84] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 84));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[84])
					button_83.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[84])
					button_83.setBorder(thickBorder_white);
			}
		});
		button_83.setBounds(736, 439, 60, 61);
		contentPane.add(button_83);

		JButton button_84 = new JButton(" ");
		button_84.setToolTipText("\uC601/\uC5C6\uB2E4/\uAC00\uCE58\uC5C6\uB294");
		button_84.setOpaque(false);
		button_84.setContentAreaFilled(false);
		button_84.setBorder(thickBorder_white);
		button_84.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_84.setBorder(thickBorder_red);
				flag[85] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 85));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[85])
					button_84.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[85])
					button_84.setBorder(thickBorder_white);
			}
		});
		button_84.setBounds(736, 494, 60, 61);
		contentPane.add(button_84);

		JButton button_85 = new JButton(" ");
		button_85.setToolTipText("\uACA9\uC790/\uB124\uD2B8\uC6CC\uD06C/\uAC10\uC625");
		button_85.setOpaque(false);
		button_85.setContentAreaFilled(false);
		button_85.setBorder(thickBorder_white);
		button_85.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_85.setBorder(thickBorder_red);
				flag[86] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 86));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[86])
					button_85.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[86])
					button_85.setBorder(thickBorder_white);
			}
		});
		button_85.setBounds(800, 436, 60, 61);
		contentPane.add(button_85);

		JButton button_86 = new JButton("");
		button_86.setToolTipText("\uD558\uB098");
		button_86.setOpaque(false);
		button_86.setContentAreaFilled(false);
		button_86.setBorder(thickBorder_white);
		button_86.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_86.setBorder(thickBorder_red);
				flag[87] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 87));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[87])
					button_86.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[87])
					button_86.setBorder(thickBorder_white);
			}
		});
		button_86.setBounds(802, 495, 60, 61);
		contentPane.add(button_86);

		JButton button_87 = new JButton(" ");
		button_87.setToolTipText("\uC9C1\uC120/\uB9E4\uB044\uB7EC\uC6B4");
		button_87.setOpaque(false);
		button_87.setContentAreaFilled(false);
		button_87.setBorder(thickBorder_white);
		button_87.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_87.setBorder(thickBorder_red);
				flag[88] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 88));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[88])
					button_87.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[88])
					button_87.setBorder(thickBorder_white);
			}
		});
		button_87.setBounds(875, 21, 67, 59);
		contentPane.add(button_87);

		JButton button_88 = new JButton(" ");
		button_88.setToolTipText("\uC2ED\uC790/\uAD50\uCC28");
		button_88.setOpaque(false);
		button_88.setContentAreaFilled(false);
		button_88.setBorder(thickBorder_white);
		button_88.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_88.setBorder(thickBorder_red);
				flag[89] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 89));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[89])
					button_88.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[89])
					button_88.setBorder(thickBorder_white);
			}
		});
		button_88.setBounds(875, 84, 67, 57);
		contentPane.add(button_88);

		JButton button_89 = new JButton(" ");
		button_89.setToolTipText("\uB098\uC120/\uB3CC\uB2E4/\uAC10\uB2E4");
		button_89.setOpaque(false);
		button_89.setContentAreaFilled(false);
		button_89.setBorder(thickBorder_white);
		button_89.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_89.setBorder(thickBorder_red);
				flag[90] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 90));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[90])
					button_89.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[90])
					button_89.setBorder(thickBorder_white);
			}
		});
		button_89.setBounds(875, 144, 67, 57);
		contentPane.add(button_89);

		JButton button_90 = new JButton(" ");
		button_90.setToolTipText("\uACE0\uB9AC");
		button_90.setOpaque(false);
		button_90.setContentAreaFilled(false);
		button_90.setBorder(thickBorder_white);
		button_90.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_90.setBorder(thickBorder_red);
				flag[91] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 91));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[91])
					button_90.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[91])
					button_90.setBorder(thickBorder_white);
			}
		});
		button_90.setBounds(875, 204, 67, 57);
		contentPane.add(button_90);

		JButton button_91 = new JButton(" ");
		button_91.setToolTipText("\uC0BC\uAC01\uD615");
		button_91.setOpaque(false);
		button_91.setContentAreaFilled(false);
		button_91.setBorder(thickBorder_white);
		button_91.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_91.setBorder(thickBorder_red);
				flag[92] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 92));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[92])
					button_91.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[92])
					button_91.setBorder(thickBorder_white);
			}
		});
		button_91.setBounds(875, 263, 67, 57);
		contentPane.add(button_91);

		JButton button_92 = new JButton(" ");
		button_92.setToolTipText("\uC0AC\uAC01\uD615");
		button_92.setOpaque(false);
		button_92.setContentAreaFilled(false);
		button_92.setBorder(thickBorder_white);
		button_92.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_92.setBorder(thickBorder_red);
				flag[93] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 93));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[93])
					button_92.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[93])
					button_92.setBorder(thickBorder_white);
			}
		});
		button_92.setBounds(875, 324, 67, 57);
		contentPane.add(button_92);

		JButton button_93 = new JButton(" ");
		button_93.setToolTipText("\uC721\uBA74\uCCB4/\uBCBD\uB3CC");
		button_93.setOpaque(false);
		button_93.setContentAreaFilled(false);
		button_93.setBorder(thickBorder_white);
		button_93.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_93.setBorder(thickBorder_red);
				flag[94] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 94));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[94])
					button_93.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[94])
					button_93.setBorder(thickBorder_white);
			}
		});
		button_93.setBounds(875, 384, 67, 57);
		contentPane.add(button_93);

		JButton button_94 = new JButton(" ");
		button_94.setToolTipText("\uD53C\uB77C\uBBF8\uB4DC/\uAC01\uBFD4");
		button_94.setOpaque(false);
		button_94.setContentAreaFilled(false);
		button_94.setBorder(thickBorder_white);
		button_94.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_94.setBorder(thickBorder_red);
				flag[95] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 95));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[95])
					button_94.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[95])
					button_94.setBorder(thickBorder_white);
			}
		});
		button_94.setBounds(875, 445, 67, 57);
		contentPane.add(button_94);

		JButton button_95 = new JButton(" ");
		button_95.setToolTipText("\uC6D0\uBFD4");
		button_95.setOpaque(false);
		button_95.setContentAreaFilled(false);
		button_95.setBorder(thickBorder_white);
		button_95.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_95.setBorder(thickBorder_red);
				flag[96] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 96));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[96])
					button_95.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[96])
					button_95.setBorder(thickBorder_white);
			}
		});
		button_95.setBounds(875, 506, 67, 57);
		contentPane.add(button_95);

		JButton button_96 = new JButton(" ");
		button_96.setToolTipText("\uD3EC\uBB3C\uC120/\uB465\uADFC");
		button_96.setOpaque(false);
		button_96.setContentAreaFilled(false);
		button_96.setBorder(thickBorder_white);
		button_96.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_96.setBorder(thickBorder_red);
				flag[97] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 97));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[97])
					button_96.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[97])
					button_96.setBorder(thickBorder_white);
			}
		});
		button_96.setBounds(946, 23, 67, 57);
		contentPane.add(button_96);

		JButton button_97 = new JButton(" ");
		button_97.setToolTipText("\uAE4D\uC740\uC120/\uB0A0\uCE74\uB85C\uC6B4");
		button_97.setOpaque(false);
		button_97.setContentAreaFilled(false);
		button_97.setBorder(thickBorder_white);
		button_97.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_97.setBorder(thickBorder_red);
				flag[98] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 98));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[98])
					button_97.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[98])
					button_97.setBorder(thickBorder_white);
			}
		});
		button_97.setBounds(947, 84, 67, 57);
		contentPane.add(button_97);

		JButton button_98 = new JButton(" ");
		button_98.setToolTipText("\uD30C\uB3D9/\uBB3C\uACB0");
		button_98.setOpaque(false);
		button_98.setContentAreaFilled(false);
		button_98.setBorder(thickBorder_white);
		button_98.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_98.setBorder(thickBorder_red);
				flag[99] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 99));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[99])
					button_98.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[99])
					button_98.setBorder(thickBorder_white);
			}
		});
		button_98.setBounds(946, 145, 67, 57);
		contentPane.add(button_98);

		JButton button_99 = new JButton(" ");
		button_99.setToolTipText("\uC6D0");
		button_99.setOpaque(false);
		button_99.setContentAreaFilled(false);
		button_99.setBorder(thickBorder_white);
		button_99.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_99.setBorder(thickBorder_red);
				flag[100] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 100));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[100])
					button_99.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[100])
					button_99.setBorder(thickBorder_white);
			}
		});
		button_99.setBounds(946, 206, 67, 57);
		contentPane.add(button_99);

		JButton button_100 = new JButton(" ");
		button_100.setToolTipText("\uBCC4");
		button_100.setOpaque(false);
		button_100.setContentAreaFilled(false);
		button_100.setBorder(thickBorder_white);
		button_100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_100.setBorder(thickBorder_red);
				flag[101] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 101));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[101])
					button_100.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[101])
					button_100.setBorder(thickBorder_white);
			}
		});
		button_100.setBounds(946, 265, 67, 57);
		contentPane.add(button_100);

		JButton button_101 = new JButton(" ");
		button_101.setToolTipText("\uD3C9\uD3C9\uD55C");
		button_101.setOpaque(false);
		button_101.setContentAreaFilled(false);
		button_101.setBorder(thickBorder_white);
		button_101.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_101.setBorder(thickBorder_red);
				flag[102] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 102));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[102])
					button_101.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[102])
					button_101.setBorder(thickBorder_white);
			}
		});
		button_101.setBounds(947, 325, 67, 57);
		contentPane.add(button_101);

		JButton button_102 = new JButton(" ");
		button_102.setToolTipText("\uAD6C/\uACF5");
		button_102.setOpaque(false);
		button_102.setContentAreaFilled(false);
		button_102.setBorder(thickBorder_white);
		button_102.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_102.setBorder(thickBorder_red);
				flag[103] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 103));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[103])
					button_102.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[103])
					button_102.setBorder(thickBorder_white);
			}
		});
		button_102.setBounds(946, 384, 67, 57);
		contentPane.add(button_102);

		JButton button_103 = new JButton(" ");
		button_103.setToolTipText("\uC6D0\uAE30\uB465");
		button_103.setOpaque(false);
		button_103.setContentAreaFilled(false);
		button_103.setBorder(thickBorder_white);
		button_103.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_103.setBorder(thickBorder_red);
				flag[104] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 104));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[104])
					button_103.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[104])
					button_103.setBorder(thickBorder_white);
			}
		});
		button_103.setBounds(946, 445, 67, 57);
		contentPane.add(button_103);

		JButton button_104 = new JButton(" ");
		button_104.setToolTipText("\uBE48/\uB6A4\uB9B0");
		button_104.setOpaque(false);
		button_104.setContentAreaFilled(false);
		button_104.setBorder(thickBorder_white);
		button_104.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_104.setBorder(thickBorder_red);
				flag[105] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 105));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[105])
					button_104.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[105])
					button_104.setBorder(thickBorder_white);
			}
		});
		button_104.setBounds(946, 505, 67, 57);
		contentPane.add(button_104);

		JButton button_105 = new JButton(" ");
		button_105.setToolTipText("\uD30C\uB780\uC0C9");
		button_105.setOpaque(false);
		button_105.setContentAreaFilled(false);
		button_105.setBorder(thickBorder_white);
		button_105.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_105.setBorder(thickBorder_red);
				flag[106] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 106));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[106])
					button_105.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[106])
					button_105.setBorder(thickBorder_white);
			}
		});
		button_105.setBounds(168, 377, 56, 55);
		contentPane.add(button_105);

		JButton button_106 = new JButton(" ");
		button_106.setToolTipText("\uBD84\uD64D\uC0C9");
		button_106.setOpaque(false);
		button_106.setContentAreaFilled(false);
		button_106.setBorder(thickBorder_white);
		button_106.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_106.setBorder(thickBorder_red);
				flag[107] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 107));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[107])
					button_106.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[107])
					button_106.setBorder(thickBorder_white);
			}
		});
		button_106.setBounds(169, 433, 56, 55);
		contentPane.add(button_106);

		JButton button_107 = new JButton(" ");
		button_107.setToolTipText("\uAC80\uC815\uC0C9");
		button_107.setOpaque(false);
		button_107.setContentAreaFilled(false);
		button_107.setBorder(thickBorder_white);
		button_107.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_107.setBorder(thickBorder_red);
				flag[108] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 108));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[108])
					button_107.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[108])
					button_107.setBorder(thickBorder_white);
			}
		});
		button_107.setBounds(169, 490, 56, 55);
		contentPane.add(button_107);

		JButton button_108 = new JButton(" ");
		button_108.setToolTipText("\uBCF4\uB77C\uC0C9");
		button_108.setOpaque(false);
		button_108.setContentAreaFilled(false);
		button_108.setBorder(thickBorder_white);
		button_108.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_108.setBorder(thickBorder_red);
				flag[109] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 109));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[109])
					button_108.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[109])
					button_108.setBorder(thickBorder_white);
			}
		});
		button_108.setBounds(227, 376, 56, 55);
		contentPane.add(button_108);

		JButton button_109 = new JButton(" ");
		button_109.setToolTipText("\uAC08\uC0C9");
		button_109.setOpaque(false);
		button_109.setContentAreaFilled(false);
		button_109.setBorder(thickBorder_white);
		button_109.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_109.setBorder(thickBorder_red);
				flag[110] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 110));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[110])
					button_109.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[110])
					button_109.setBorder(thickBorder_white);
			}
		});
		button_109.setBounds(227, 433, 56, 55);
		contentPane.add(button_109);

		JButton button_110 = new JButton(" ");
		button_110.setToolTipText("\uD68C\uC0C9");
		button_110.setOpaque(false);
		button_110.setContentAreaFilled(false);
		button_110.setBorder(thickBorder_white);
		button_110.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_110.setBorder(thickBorder_red);
				flag[111] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 111));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[111])
					button_110.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[111])
					button_110.setBorder(thickBorder_white);
			}
		});
		button_110.setBounds(229, 490, 56, 55);
		contentPane.add(button_110);

		JButton button_111 = new JButton(" ");
		button_111.setToolTipText("\uD770\uC0C9");
		button_111.setOpaque(false);
		button_111.setContentAreaFilled(false);
		button_111.setBorder(thickBorder_white);
		button_111.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_111.setBorder(thickBorder_red);
				flag[112] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 112));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[112])
					button_111.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[112])
					button_111.setBorder(thickBorder_white);
			}
		});
		button_111.setBounds(289, 375, 56, 55);
		contentPane.add(button_111);

		JButton button_112 = new JButton(" ");
		button_112.setToolTipText("\uBE68\uAC04\uC0C9");
		button_112.setOpaque(false);
		button_112.setContentAreaFilled(false);
		button_112.setBorder(thickBorder_white);
		button_112.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_112.setBorder(thickBorder_red);
				flag[113] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 113));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[113])
					button_112.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[113])
					button_112.setBorder(thickBorder_white);
			}
		});
		button_112.setBounds(289, 434, 56, 55);
		contentPane.add(button_112);

		JButton button_113 = new JButton(" ");
		button_113.setToolTipText("\uB178\uB780\uC0C9");
		button_113.setOpaque(false);
		button_113.setContentAreaFilled(false);
		button_113.setBorder(thickBorder_white);
		button_113.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_113.setBorder(thickBorder_red);
				flag[114] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 114));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[114])
					button_113.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[114])
					button_113.setBorder(thickBorder_white);
			}
		});
		button_113.setBounds(288, 493, 56, 55);
		contentPane.add(button_113);

		JButton button_114 = new JButton(" ");
		button_114.setToolTipText("\uD22C\uBA85\uC0C9");
		button_114.setOpaque(false);
		button_114.setContentAreaFilled(false);
		button_114.setBorder(thickBorder_white);
		button_114.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_114.setBorder(thickBorder_red);
				flag[115] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 115));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[115])
					button_114.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[115])
					button_114.setBorder(thickBorder_white);
			}
		});
		button_114.setBounds(349, 376, 56, 55);
		contentPane.add(button_114);

		JButton button_115 = new JButton(" ");
		button_115.setToolTipText("\uC8FC\uD669\uC0C9");
		button_115.setOpaque(false);
		button_115.setContentAreaFilled(false);
		button_115.setBorder(thickBorder_white);
		button_115.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_115.setBorder(thickBorder_red);
				flag[116] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 116));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[116])
					button_115.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[116])
					button_115.setBorder(thickBorder_white);
			}
		});
		button_115.setBounds(349, 433, 56, 55);
		contentPane.add(button_115);

		JButton button_116 = new JButton(" ");
		button_116.setToolTipText("\uCD08\uB85D\uC0C9");
		button_116.setOpaque(false);
		button_116.setContentAreaFilled(false);
		button_116.setBorder(thickBorder_white);
		button_116.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				button_116.setBorder(thickBorder_red);
				flag[117] = true;
				client.forwardGame(new GameData("GAME", "BUTTON", 117));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!flag[117])
					button_116.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!flag[117])
					button_116.setBorder(thickBorder_white);
			}
		});
		button_116.setBounds(349, 492, 56, 55);
		contentPane.add(button_116);

		JButton initial = new JButton();
		initial.setBounds(950, 585, 80, 55);
		contentPane.add(initial);
		initial.setBorder(thickBorder_white);
		initial.setContentAreaFilled(false); // 버튼 영역 투명
		initial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				initial.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				initial.setBorder(thickBorder_white);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				client.forwardGame(new GameData("DATA","INI"));
			}
		});

		buttonList.add(box); // button에 정보넣기
		buttonList.add(button); // button에 정보넣기
		buttonList.add(button_1);
		buttonList.add(button_2);
		buttonList.add(button_3);
		buttonList.add(button_4);
		buttonList.add(button_5);
		buttonList.add(button_6);
		buttonList.add(button_7);
		buttonList.add(button_8);
		buttonList.add(button_9);
		buttonList.add(button_10);
		buttonList.add(button_11);
		buttonList.add(button_12);
		buttonList.add(button_13);
		buttonList.add(button_14);
		buttonList.add(button_15);
		buttonList.add(button_16);
		buttonList.add(button_17);
		buttonList.add(button_18);
		buttonList.add(button_19);
		buttonList.add(button_20);
		buttonList.add(button_21);
		buttonList.add(button_22);
		buttonList.add(button_23);
		buttonList.add(button_24);
		buttonList.add(button_25);
		buttonList.add(button_26);
		buttonList.add(button_27);
		buttonList.add(button_28);
		buttonList.add(button_29);
		buttonList.add(button_30);
		buttonList.add(button_31);
		buttonList.add(button_32);
		buttonList.add(button_33);
		buttonList.add(button_34);
		buttonList.add(button_35);
		buttonList.add(button_36);
		buttonList.add(button_37);
		buttonList.add(button_38);
		buttonList.add(button_39);
		buttonList.add(button_40);
		buttonList.add(button_41);
		buttonList.add(button_42);
		buttonList.add(button_43);
		buttonList.add(button_44);
		buttonList.add(button_45);
		buttonList.add(button_46);
		buttonList.add(button_47);
		buttonList.add(button_48);
		buttonList.add(button_49);
		buttonList.add(button_50);
		buttonList.add(button_51);
		buttonList.add(button_52);
		buttonList.add(button_53);
		buttonList.add(button_54);
		buttonList.add(button_55);
		buttonList.add(button_56);
		buttonList.add(button_57);
		buttonList.add(button_58);
		buttonList.add(button_59);
		buttonList.add(button_60);
		buttonList.add(button_61);
		buttonList.add(button_62);
		buttonList.add(button_63);
		buttonList.add(button_64);
		buttonList.add(button_65);
		buttonList.add(button_66);
		buttonList.add(button_67);
		buttonList.add(button_68);
		buttonList.add(button_69);
		buttonList.add(button_70);
		buttonList.add(button_71);
		buttonList.add(button_72);
		buttonList.add(button_73);
		buttonList.add(button_74);
		buttonList.add(button_75);
		buttonList.add(button_76);
		buttonList.add(button_77);
		buttonList.add(button_78);
		buttonList.add(button_79);
		buttonList.add(button_80);
		buttonList.add(button_81);
		buttonList.add(button_82);
		buttonList.add(button_83);
		buttonList.add(button_84);
		buttonList.add(button_85);
		buttonList.add(button_86);
		buttonList.add(button_87);
		buttonList.add(button_88);
		buttonList.add(button_89);
		buttonList.add(button_90);
		buttonList.add(button_91);
		buttonList.add(button_92);
		buttonList.add(button_93);
		buttonList.add(button_94);
		buttonList.add(button_95);
		buttonList.add(button_96);
		buttonList.add(button_97);
		buttonList.add(button_98);
		buttonList.add(button_99);
		buttonList.add(button_100);
		buttonList.add(button_101);
		buttonList.add(button_102);
		buttonList.add(button_103);
		buttonList.add(button_104);
		buttonList.add(button_105);
		buttonList.add(button_106);
		buttonList.add(button_107);
		buttonList.add(button_108);
		buttonList.add(button_109);
		buttonList.add(button_110);
		buttonList.add(button_111);
		buttonList.add(button_112);
		buttonList.add(button_113);
		buttonList.add(button_114);
		buttonList.add(button_115);
		buttonList.add(button_116);

		JButton dice = new JButton();
		dice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Dice dice = new Dice(client);
			}
		});
		dice.setBounds(1110, 585, 55, 55);
		contentPane.add(dice);
		dice.setBorder(thickBorder_white);
		dice.setContentAreaFilled(false); // 버튼 영역 투명
		dice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				dice.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				dice.setBorder(thickBorder_white);
			}
		});

		JButton help = new JButton();
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Help help = new Help();
			}
		});
		help.setBounds(1182, 585, 55, 55);
		contentPane.add(help);
		help.setBorder(thickBorder_white);
		help.setContentAreaFilled(false); // 버튼 영역 투명
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				help.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				help.setBorder(thickBorder_white);
			}
		});

		chatPanel = new Chat_panel(client);
		chatPanel.setBounds(21, 578, 901, 128);
		getContentPane().add(chatPanel);

		timer = new Timer(client);
		timer.setBounds(1052, 22, 197, 36);
		getContentPane().add(timer);

		JButton addTime = new JButton();
		addTime.setBounds(1044, 585, 52, 55);
		contentPane.add(addTime);
		addTime.setBorder(thickBorder_white);
		addTime.setContentAreaFilled(false); // 버튼 영역 투명
		addTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				addTime.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				addTime.setBorder(thickBorder_white);
			}
		});

		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textField.setBounds(996, 665, 197, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setOpaque(false);
		textField.setBorder(null);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.forwardGame(new GameData("GAME","ANSWER",textField.getText()));
				textField.setText("");
			}
		});

		JButton smallOK = new JButton();
		smallOK.setBounds(1198, 659, 55, 52);
		contentPane.add(smallOK);
		smallOK.setBorder(thickBorder_white);
		smallOK.setContentAreaFilled(false); // 버튼 영역 투명
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

		scoreP1 = new JLabel();
		scoreP1.setVerticalAlignment(SwingConstants.TOP);
		scoreP1.setForeground(Color.PINK);
		scoreP1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		scoreP1.setText(Integer.toString(score1));	//점수 넣어주기
		scoreP1.setBounds(1164, 275, 50, 30);
		contentPane.add(scoreP1);

		scoreP2 = new JLabel();
		scoreP2.setVerticalAlignment(SwingConstants.TOP);
		scoreP2.setForeground(Color.PINK);
		scoreP2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		scoreP2.setText(Integer.toString(score2));	//점수 넣어주기
		scoreP2.setBounds(1164, 530, 50, 30);
		contentPane.add(scoreP2);

		JLabel Label = new JLabel();
		Label.setIcon(new ImageIcon("img/game_screen.png"));

		Label.setBounds(0, -22, 1300, 770);
		contentPane.add(Label);
		setVisible(true);
	}

	void setData(Data data) {
		switch (data.getAction()) {
		case "CHAT":
			chatPanel.appendMessage(data.getMessage());
			break;
		}
	}
	void setData(GameData data) {
		switch(data.getTurn()) {
		case 0:	//첫번째 사람 점수 올려주기
			score1=score1+data.getValue();
			scoreP1.setText(Integer.toString(score1));
			break;
		case 1:	//두번째 사람 점수 올려주기
			score2=score2+data.getValue();
			scoreP2.setText(Integer.toString(score2));
			break;
		}
		
		if(score1>=20) {
			thisclient.forwardGame(new GameData("GAME", "OVER", 0));
			
		}else if(score2>=20) {
			thisclient.forwardGame(new GameData("GAME", "OVER", 1));
		}
	
	}
	void setBoard(GameData data) {
		if(data.getAction().equals("RESTART")) {
			for(int i=0;i<118;i++) {
				getButtonList().get(i).setBorder(thickBorder_white);
			}
		}
	}
	Timer getTimer() {
	      return timer;
	   }
}
