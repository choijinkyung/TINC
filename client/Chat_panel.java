package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import util.Data;

public class Chat_panel extends JPanel {
	private JTextField textField;
	Client client;
	BufferedReader in;
	PrintWriter out;
	String name;
	JTextArea messageArea = new JTextArea(10, 35);
	HashSet<String> users = new HashSet<String>();

	public Chat_panel(Client client) {
		this.client = client;
		setLayout(null);
		messageArea.setBackground(new Color(255, 250, 240));
		messageArea.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
		messageArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(messageArea);
		scrollPane.setBounds(0, 0, 900, 103);
		scrollPane.setOpaque(false);
		add(scrollPane);

		textField = new JTextField();
		textField.setBackground(new Color(255, 222, 173));
		textField.setFont(new Font("휴먼모음T", Font.PLAIN, 22));
		textField.setBounds(0, 103, 834, 26);
		textField.setBorder(null);
		add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.forwardData(new Data("CHAT", client.getUserInfo().getId(), textField.getText()));
				textField.setText("");
			}
		});

		Border thickBorder_white = new LineBorder(Color.WHITE, 2); // button border default
		Border thickBorder_orange = new LineBorder(Color.ORANGE, 2);

		JButton OKButton = new JButton("OK");
		OKButton.setBackground(new Color(255, 222, 173));
		OKButton.setForeground(new Color(255, 250, 205));
		OKButton.setFont(new Font("210 골목길 B", Font.BOLD, 17));
		OKButton.setBounds(835, 103, 69, 26);
		OKButton.setBorder(thickBorder_white);
		OKButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				OKButton.setBorder(thickBorder_orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				OKButton.setBorder(thickBorder_white);
			}

			@Override
			public void mouseClicked(MouseEvent e1) {
				client.forwardData(new Data("CHAT", client.getUserInfo().getId(), textField.getText()));
				textField.setText("");
			}
		});
		add(OKButton);
	}

	void appendMessage(String message) {
		messageArea.append(message + "\n");
	}
}