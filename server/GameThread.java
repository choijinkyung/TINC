package server;

import util.Data;
import util.GameData;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class GameThread extends Thread {
	private final Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private JTextArea textArea;
	private static ArrayList<ObjectOutputStream> users = new ArrayList<>();
	private static final GameManager manager = new GameManager();
	private static volatile int flag1 = 0;

	GameThread(Socket socket, JTextArea textArea) {
		this.socket = socket;
		this.textArea = textArea;

		try {
			in = new ObjectInputStream(this.socket.getInputStream());
			out = new ObjectOutputStream(this.socket.getOutputStream());
			manager.enterUser(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendData(GameData output) {
		try {
			out.writeObject(output);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendOther(ObjectOutputStream stream, GameData output) {
		try {
			stream.writeObject(output);
			stream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean isAlive = true;

		try {
			while (isAlive) {
				GameData data = (GameData) in.readObject();
				String type = data.getType();
				String action = data.getAction();

				switch (type) {
				case "DATA":
					switch (action) {
					case "RSP":
						manager.setRSP(out, data.getValue());
						break;
					case "SETWORD":
						manager.setWORD(data);
						break;
					case "INI":
						manager.sendInitial();
						break;
					case "OUT":
						sendData(new GameData("OUT", "OUT"));
						isAlive = false;
						break;
					}
					break;
				case "GAME":
					switch (action) {
					case "START":
						manager.broadcast(new GameData("TIMER", "START"));
						break;
					case "BUTTON":
						manager.setBUTTON(data);
						break;
					case "ANSWER":
						manager.checkWORD(data);
						break;
					case "DICE":
						manager.addSCORE(data);
						System.out.println("score추가 완료!"+data.getValue());
						int who = data.getTurn();
						manager.informNextTurn2(who);
						break;
					case "RESTART":
						manager.broadcast(new GameData("TIMER", "RESTART"));
						manager.broadcast(new GameData("BOARD", "RESTART"));
						break;
					case "TIMEOVER": // timeover되면,
						if (flag1 == 0) {
							manager.changeTurn(); // 턴 바꿔주고
						}
						flag1++;
						sendData(new GameData("TIMER", "RESET"));// 타이머리셋
						if (flag1 == 2) {
							flag1 = 0;
						}
						break;
					case "TURNEND":
						who = data.getValue();
						manager.informNextTurn(who);
						System.out.println("Timer OVER and 턴주기 완료!!!");
						break;
					case "OVER":
						manager.broadcast(new GameData("OVER", data.getValue()));
						manager.isGameover = true;
						// value는 이긴사람
						break;
					}
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				Thread.sleep(2000);
				if (in != null)
					in.close();
				if (out != null) {
					manager.exitUser(out);
					out.close();
				}
				textArea.append(socket.getInetAddress() + "이 게임서버에서 연결 해제되었습니다.\n");
				socket.close();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
