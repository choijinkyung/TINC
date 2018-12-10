package client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Rule extends JFrame {
    public Rule() {
        setBounds(630, 100, 1154, 770);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("img/game_rule.png"));
        label.setBounds(0, 0, 1154, 721);
        contentPane.add(label);
		setLocationRelativeTo(null);
        setVisible(true);
    }
}
