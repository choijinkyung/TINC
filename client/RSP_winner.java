package client;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import server.DAO;
import util.Data;
import util.GameData;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RSP_winner extends JFrame {
	private Client client;
	private JPanel contentPane;
	private String choose;
	private boolean clicked = false;

	public RSP_winner(String[] words, Client client) {
		this.client = client;

		setBounds(100, 100, 566, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel low = new JLabel(words[0]);
		low.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		low.setHorizontalAlignment(SwingConstants.CENTER);
		low.setBounds(242, 208, 118, 40);
		contentPane.add(low);

		JLabel medium = new JLabel(words[1]);
		medium.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		medium.setHorizontalAlignment(SwingConstants.CENTER);
		medium.setBounds(242, 293, 118, 46);
		contentPane.add(medium);

		JLabel high = new JLabel(words[2]);
		high.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		high.setHorizontalAlignment(SwingConstants.CENTER);
		high.setBounds(242, 381, 118, 40);
		contentPane.add(high);

		Border thickBorder_white = new LineBorder(Color.WHITE, 4); // button border default
		Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);
		Border thickBorder_red = new LineBorder(Color.RED, 4);

		JButton lowB = new JButton();
		lowB.setBounds(180, 205, 206, 46);
		contentPane.add(lowB);
		lowB.setContentAreaFilled(false); // 버튼 영역 투명
		lowB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!clicked)
					lowB.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!clicked)
					lowB.setBorder(thickBorder_white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 선택한 단어랑 클라이언트 정보를 서버에 보내주기
				if (!clicked) {
					lowB.setBorder(thickBorder_red);
					clicked = true;
				}
				choose = words[0];
			}
		});
		lowB.setBorder(thickBorder_white);

		JButton mediumB = new JButton();
		mediumB.setBounds(180, 293, 206, 46);
		contentPane.add(mediumB);
		mediumB.setContentAreaFilled(false); // 버튼 영역 투명
		mediumB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!clicked)
					mediumB.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!clicked)
					mediumB.setBorder(thickBorder_white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 선택한 단어랑 클라이언트 정보를 서버에 보내주기
				if (!clicked) {
					mediumB.setBorder(thickBorder_red);
					clicked = true;
				}
				choose = words[1];
			}
		});
		mediumB.setBorder(thickBorder_white);

		JButton highB = new JButton();
		highB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		highB.setBounds(180, 381, 206, 40);
		contentPane.add(highB);
		highB.setContentAreaFilled(false); // 버튼 영역 투명
		highB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (!clicked)
					highB.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!clicked)
					highB.setBorder(thickBorder_white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 선택한 단어랑 클라이언트 정보를 서버에 보내주기
				if (!clicked) {
					highB.setBorder(thickBorder_red);
					clicked = true;
				}
				choose = words[2];
			}
		});
		highB.setBorder(thickBorder_white);

		JButton okB = new JButton();
		okB.setBounds(224, 490, 118, 68);
		contentPane.add(okB);
		okB.setContentAreaFilled(false); // 버튼 영역 투명
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
				// 선택한 단어랑 클라이언트 정보를 서버에 보내주기
				dispose();
				client.showFrame("GAME");

				client.forwardGame(new GameData("DATA", "SETWORD", choose));
				client.forwardGame(new GameData("GAME", "START"));
			}
		});
		okB.setBorder(thickBorder_white);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 558, 601);
		label.setIcon(new ImageIcon("img/rsp_winner.png"));
		contentPane.add(label);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
