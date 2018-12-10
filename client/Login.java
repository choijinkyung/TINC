package client;

        import util.Data;

        import javax.swing.*;
        import javax.swing.border.Border;
        import javax.swing.border.EmptyBorder;
        import javax.swing.border.LineBorder;
        import java.awt.*;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;

public class Login extends JFrame {
    private final Client client;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    Login(Client client) {
        this.client = client;

        setName("TINC");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new ExitListener(client));
        setBounds(300, 100, 1300, 770);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Border thickBorder_white = new LineBorder(Color.WHITE, 4); //button border default
        Border thickBorder_orange = new LineBorder(Color.ORANGE, 4);

        JButton joinbutton = new JButton("");
        joinbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                joinbutton.setBorder(thickBorder_orange);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                joinbutton.setBorder(thickBorder_white);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                client.showFrame("JOIN");
            }
        });
        joinbutton.setBorder(thickBorder_white);
        joinbutton.setOpaque(false);
        joinbutton.setContentAreaFilled(false);
        joinbutton.setBounds(410, 473, 211, 47);
        contentPane.add(joinbutton);

        JButton ruleButton = new JButton("");
        ruleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                ruleButton.setBorder(thickBorder_orange);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ruleButton.setBorder(thickBorder_white);
            }
            @Override
            public void mouseClicked(MouseEvent arg0) {
                client.showFrame("RULE");
            }
        });
        ruleButton.setOpaque(false);
        ruleButton.setContentAreaFilled(false);
        ruleButton.setBounds(660, 473, 211, 48);
        contentPane.add(ruleButton);
        ruleButton.setBorder(thickBorder_white);

        JButton OKButton = new JButton("");
        OKButton.setOpaque(false);
        OKButton.setContentAreaFilled(false);
        OKButton.setBounds(782, 545, 86, 94);
        contentPane.add(OKButton);
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
            public void mouseClicked(MouseEvent e) {
                String id, pw;
                id=textField.getText();
                pw=passwordField.getText();

                client.forwardData(new Data("DATA", "LOGIN", new UserInfo(id,pw)));
            }
        });
        OKButton.setBorder(thickBorder_white);



        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 22));
        lblNewLabel.setIcon(new ImageIcon("img/login_screen.png"));
        lblNewLabel.setBounds(0, -26, 1300, 770);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBorder(null);
        textField.setFont(new Font("경기천년제목L Light", Font.BOLD, 23));
        textField.setBounds(567, 545, 201, 38);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(567, 598, 201, 38);
        passwordField.setBorder(null);
        contentPane.add(passwordField);

        setVisible(true);
    }

    void setData(Data result) {	//로그인 결과를 알려주는 메소드
        switch (result.getAction()) {
            case "SUCCESS":
                client.setUserInfo(result.getUserInfo());
                client.showFrame("RSP");
                break;
            case "NOID":
                JOptionPane.showMessageDialog(null, "존재하지 않는 ID입니다.", "경고", JOptionPane.WARNING_MESSAGE);
                break;
            case "NOPW":
                JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "경고", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }
}
