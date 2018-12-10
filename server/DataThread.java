package server;

import util.Data;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class DataThread extends Thread {
	private static ArrayList<ObjectOutputStream> userList = new ArrayList<>();;
	private final Socket socket;
	private final DAO dao;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private JTextArea textArea;

	DataThread(Socket socket, JTextArea textArea) {
		this.socket = socket;
		this.dao = DAO.getInstance();
		this.textArea = textArea;

		try {
			in = new ObjectInputStream(this.socket.getInputStream());
			out = new ObjectOutputStream(this.socket.getOutputStream());
			userList.add(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendData(Data output) {
		try {
			out.writeObject(output);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean isAlive = true;

		try {
			while (isAlive) {
				Data data = (Data) in.readObject();
				String type = data.getType();
				String action = data.getAction();

				switch (type) {
				case "DATA":
					switch (action) {
					case "LOGIN":
						sendData(dao.login(data.getUserInfo()));
						break;
					case "JOIN":
						sendData(dao.join(data.getUserInfo()));
						break;
					
					case "OUT":
						sendData(new Data("OUT", "OUT"));
						isAlive = false;
						break;
					}
					break;
				case "CHAT":
					String message = data.getAction() + " : " + data.getMessage();
					for (ObjectOutputStream stream : userList) {
						stream.writeObject(new Data("GAME", "CHAT", message));
						stream.flush();
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
					userList.remove(out);
					out.close();
				}
				textArea.append(socket.getInetAddress() + "이 데이터서버에서 연결 해제되었습니다.\n");
				socket.close();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
