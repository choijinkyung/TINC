package client;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import util.GameData;

public class Timer extends JPanel {
	private static final Container Timer = null;
	Thread t = null; // 스레드
	static Display t_display;
	JLabel mm, colon, ss; // 분 : 초
	String min, sec;
//	int n1 = 0, n2 = 10, count = 10; // n1=분을 저장 , n2= 초를 저장
   int n1 = 5, n2 = 0, count = 300; // n1=분을 저장 , n2= 초를 저장
	boolean stopped = false;
	Client thisclient;

	class Display extends Thread {

		public void run() {
			System.out.println("이거는 " + thisclient.getWho() + "의 타이머 스레드~");
			n1 = Integer.parseInt(mm.getText());
			n2 = Integer.parseInt(ss.getText());
			while (true) {
				while (!stopped) {
					if (count < 0) {
						stopped = true;
						System.out.println("타임오버 전송완료!1");
						if(thisclient.getWho()==0) {
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						thisclient.forwardGame(new GameData("GAME", "TIMEOVER"));
						System.out.println("타임오버 전송완료!2");
						time_over to = new time_over();
						to.setVisible(true);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						to.setVisible(false); // Game over 3초 보여준 뒤 단어고르기 or 기다리기
						thisclient.forwardGame(new GameData("GAME", "TURNEND", thisclient.getWho()));
						System.out.println("턴 엔드 오케이!");
					}
					n2 = count % 60;
					n1 = count / 60;
					min = String.format("%02d", n1);
					sec = String.format("%02d", n2);

					mm.setText(min);
					ss.setText(sec);

					count--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						return;
					}
				}
			}
		}
	}

	public void resetTimer() {

      count=300;  n1 = 5; n2 = 0;
//		count = 10;
//		n1 = 0;
//		n2 = 10;
	}

	public void _stop() {
		stopped = true;
	}

	public void _restart() {
		stopped = false;
	}

	Timer(Client client) {
		thisclient = client;
		setOpaque(false);
		setBounds(1052, 25, 197, 36);
		setLayout(null);

		mm = new JLabel();
		mm.setHorizontalAlignment(SwingConstants.CENTER);
		mm.setBounds(28, 3, 49, 31);
		mm.setFont(new Font("Serif", Font.BOLD, 30));

		colon = new JLabel();
		colon.setHorizontalAlignment(SwingConstants.CENTER);
		colon.setBounds(77, 0, 37, 36);
		colon.setFont(new Font("Serif", Font.BOLD, 30));

		ss = new JLabel();
		ss.setHorizontalAlignment(SwingConstants.CENTER);
		ss.setBounds(112, 3, 49, 31);
		ss.setFont(new Font("Serif", Font.BOLD, 30));

		min = String.format("%02d", n1);
		sec = String.format("%02d", n2);

		mm.setText(min);
		colon.setText(":");
		ss.setText(sec);

		add(mm);
		add(colon);
		add(ss);

		t_display = new Display();
		t = t_display;
	}

}