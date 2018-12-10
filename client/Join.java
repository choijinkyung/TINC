package client;

import util.Data;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

class Join extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    Join(Client client) {
        setBounds(700, 200, 490, 574);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1300, 770);
        contentPane.add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("210 골목길 L", Font.BOLD, 22));
        textField.setBounds(202, 239, 206, 37);
        textField.setBorder(null);
        panel.add(textField);
        textField.setColumns(10);


        passwordField = new JPasswordField();
        passwordField.setFont(new Font("굴림", Font.PLAIN, 23));
        passwordField.setBounds(202, 313, 206, 38);
        passwordField.setBorder(null);
        panel.add(passwordField);

        Border thickBorder_white = new LineBorder(Color.WHITE, 4); //button border default
        Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);

        JButton btnNewButton = new JButton("");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                String id, pw;
                id=textField.getText();
                pw=passwordField.getText();
                Data data = new Data("DATA", "JOIN", new UserInfo(id,pw));

                client.forwardData(data);
            }
        });
        btnNewButton.setBounds(162, 396, 133, 94);
        btnNewButton.setOpaque(false);
        btnNewButton.setContentAreaFilled(false);
        //OKButton.setBounds(782, 545, 86, 94);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                btnNewButton.setBorder(thickBorder_orange);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnNewButton.setBorder(thickBorder_white);
            }
        });
        btnNewButton.setBorder(thickBorder_white);
        panel.add(btnNewButton);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("img/join.PNG"));
        label.setBounds(0, 0, 474, 545);
        panel.add(label);

        setVisible(true);
    }

    void setData(Data result) {	//회원가입 결과를 알려주는 메소드
        switch (result.getAction()) {
            case "COMPLETE":
                JOptionPane.showMessageDialog(null, "가입에 성공했습니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                break;
            case "FAIL":
                JOptionPane.showMessageDialog(null, "가입에 실패했습니다.", "회원가입", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }
}
