package client;

import util.Data;
import util.GameData;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import server.DAO;

import java.awt.Color;
import java.io.IOException;

public class Client {
	private final SocketInfo socketInfo;
	private UserInfo userInfo;
	private Thread dataThread, gameThread;
	private JFrame mainFrame, subFrame;
	private final Object dataLock = new Object();
	private final Object gameLock = new Object();
	private int who; // 자기가 위에면 0, 아래면 1
	private static DAO dao = new DAO();
	WordScreen ws;
	Waiting wait;

	public Client() { // 클라이언트가 접속하면 데이터,게임 쓰레드 실행
		socketInfo = new SocketInfo();
		dataThread = new Thread(new ConnectData());
		gameThread = new Thread(new ConnectGame());
		dataThread.start();
		gameThread.start();
		showFrame("LOGIN");
	}

	public static void main(String[] args) {
		new Client();
	}

	public int getWho() {
		return who;
	}

	void showFrame(String param) { // 클라이언트에게 창 띄워주기
		switch (param) {
		case "LOGIN":
			mainFrame = new Login(this);
			break;
		case "JOIN":
			subFrame = new Join(this);
			break;
		case "RULE":
			subFrame = new Rule();
			break;
		case "RSP":
			subFrame = new RSP(this);
			break;
		case "GAME":
			subFrame.dispose();
			mainFrame.dispose();
			mainFrame = new game(this);
			break;

		}
	}

	void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
		this.userInfo.hidePassword();
	}

	UserInfo getUserInfo() {
		return userInfo;
	}

	void forwardData(Data data) { // 서버한테 정보 넘기기
		try {
			synchronized (dataLock) {
				this.socketInfo.getDataOutputStream().writeObject(data);
				this.socketInfo.getDataOutputStream().flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void forwardGame(GameData data) { // 서버한테 게임 정보 넘기기
		try {
			synchronized (gameLock) {
				this.socketInfo.getGameOutputStream().writeObject(data);
				this.socketInfo.getGameOutputStream().flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void terminate() { // 클라이언트가 나가는 경우
		if (subFrame != null)
			subFrame.dispose();
		if (mainFrame != null)
			mainFrame.dispose();

		forwardData(new Data("DATA", "OUT"));
		forwardGame(new GameData("DATA", "OUT"));
	}

	class ConnectData implements Runnable { // 클라이언트에서 데이터를 받는 쓰레드
		private boolean isAlive = true;

		@Override
		public void run() {
			try {
				while (isAlive) {
					Data data = (Data) socketInfo.getDataInputStream().readObject();
					synchronized (dataLock) {
						String type = data.getType();

						switch (type) {
						case "LOGIN":
							((Login) mainFrame).setData(data);
							break;
						case "JOIN":
							((Join) subFrame).setData(data);
							break;
						case "GAME":
							((game) mainFrame).setData(data);
							break;

						case "OUT":
							isAlive = false;
							break;
						}
					}
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			} finally {
				socketInfo.closeSocket();
			}
		}
	}

	Client getClient() {
		return this;
	}

	class ConnectGame implements Runnable { // 클라이언트에서 게임 데이터를 받는 쓰레드
		private boolean isAlive = true;

		@Override
		public void run() {
			try {
				while (isAlive) {
					GameData data = (GameData) socketInfo.getGameInputStream().readObject();
					synchronized (gameLock) {
						String type = data.getType();

						switch (type) {
						case "FIRST":
							who = 0;
							break;
						case "SECOND":
							who = 1;
							break;
						case "TIMER":
							String action = data.getAction();

							switch (action) {
							case "START": // 처음시작
								((game) mainFrame).getTimer().t.start();
								System.out.println("Timer Start!!!");
								break;
							case "RESTART": // 재시작
								((game) mainFrame).getTimer()._restart();
								wait.setVisible(false);
								System.out.println("Timer Restart!!!");
								break;
							case "RESET": // 일시정지 후 리셋
								((game) mainFrame).getTimer()._stop();
								((game) mainFrame).getTimer().resetTimer();
								System.out.println("Timer Reset!!!");
								break;
							}
							break;
						case "RSP":
							((RSP) subFrame).setData(data);
							break;
						case "BUTTON":
							Border thickBorder_red = new LineBorder(Color.RED, 4);
							((game) mainFrame).getButtonList().get(data.getValue()).setBorder(thickBorder_red);

							break;
						case "BOARD":
							((game) mainFrame).setBoard(data);
							break;

						case "ANSWER":
							if (data.getAction().equals("YES")) {
								if (data.getWord().equals("TURN")) { // 상대방이 정답 맞춘경우
									subFrame=new Opp_correct();

								} else { // 내가 정답 맞춘 경우
									JOptionPane.showMessageDialog(null, "정답입니다!", "경고", JOptionPane.WARNING_MESSAGE);
									Dice dice = new Dice(Client.this); // 주사위 창
								}

							} else if (data.getAction().equals("NO")) {
								JOptionPane.showMessageDialog(null, "오답입니다!", "경고", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case "SCORE": // 점수 올려주기
							((game) mainFrame).setData(data);
							break;
						case "INI":
							subFrame = new Initial();
							((Initial) subFrame).setData(data);
							break;
						case "OVER":
							switch (data.getValue()) { // value는 이긴사람!(0 or 1)
							case 0:
								if (who == 0) {
									subFrame=new final_win();
						
								} else {
									subFrame=new final_lose();
								}
								break;
							case 1:
								if (who == 1) {
									subFrame=new final_win();
								} else {
									subFrame=new final_lose();
								}
								break;
							}

							break;
						case "NEXTTURN":
							switch (data.getAction()) { // value는 이긴사람!(0 or 1)
							case "TURN":
								ws = new WordScreen(data.getData(), Client.this);
								subFrame = ws;
								subFrame.setVisible(true);
								System.out.println("내턴!");
								break;
							case "NOTTURN":
								wait = new Waiting();
								subFrame = wait;
								subFrame.setVisible(true);
								System.out.println("내턴아님!");
								break;
							}
							break;
						case "OUT":
							isAlive = false;
							break;
						}
					}
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			} finally {
				socketInfo.closeSocket();
			}
		}
	}
}
