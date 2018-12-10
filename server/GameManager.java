package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import util.Data;
import util.GameData;

public class GameManager {
	private static DAO dao = new DAO();
	private static ArrayList<ObjectOutputStream> userList;
	private static Hashtable<ObjectOutputStream, Integer> rspList;
	private static int rsp_count;
	private static int turn; // 현재 출제자
	private static int opp; // 현재 맞추는 사람
	private static String word; // 현재 단어
	private String[] words;
	public boolean isGameover=false;
	static {
		userList = new ArrayList<>();
		rspList = new Hashtable<>();
		rsp_count = 0;
	}

	public GameManager() {
	}

	public void enterUser(ObjectOutputStream stream) {
		if (userList.size() < 2) {
			userList.add(stream);
		}
	}

	public void exitUser(ObjectOutputStream stream) {
		if (userList.size() > 0) {
			userList.remove(stream);
		}
	}

	public void setRSP(ObjectOutputStream stream, int value) {
		System.out.println("RSP");
		if (rsp_count < 2) {
			rspList.put(stream, value);
			rsp_count++;
			System.out.println(rsp_count);

			if (rsp_count == 2) {
				int first = rspList.get(userList.get(0));
				int second = rspList.get(userList.get(1));

				switch (first - second) {
				case 0:
					broadcast(new GameData("RSP", "DRAW"));
					rsp_count = 0;
					break;
				case 1:
				case -2:
					sendRSPResult(0, 1);
					break;
				case 2:
				case -1:
					sendRSPResult(1, 0);
					break;
				}

				try { // 자신이 위에인지 아래인지! first가 위에사람
					userList.get(0).writeObject(new GameData("FIRST", "FIRST"));
					userList.get(0).flush();
					userList.get(1).writeObject(new GameData("SECOND", "SECOND"));
					userList.get(1).flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void changeTurn() {
		if (turn == 0) {
			turn = 1;
			opp = 0;
		} else {
			turn = 0;
			opp = 1;
		}
		System.out.println("Change turn!");
	}

	public void informNextTurn(int thisturn) {
		words = dao.getWord();
		if(!isGameover) {
			if (thisturn == turn) {
				try {
					userList.get(thisturn).writeObject(new GameData("NEXTTURN", "TURN", words));
					userList.get(thisturn).flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					userList.get(thisturn).writeObject(new GameData("NEXTTURN", "NOTTURN"));
					userList.get(thisturn).flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void informNextTurn2(int thisturn) {
		words = dao.getWord();
		if (thisturn == turn) {
			try {
				userList.get(thisturn).writeObject(new GameData("NEXTTURN", "TURN", words));
				userList.get(thisturn).flush();
				userList.get(opp).writeObject(new GameData("NEXTTURN", "NOTTURN"));
				userList.get(opp).flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				userList.get(thisturn).writeObject(new GameData("NEXTTURN", "NOTTURN"));
				userList.get(thisturn).flush();
				userList.get(opp).writeObject(new GameData("NEXTTURN", "TURN", words));
				userList.get(opp).flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setWORD(GameData data) {
		word = data.getWord();
		System.out.println(word);
	}

	public void setBUTTON(GameData data) {
		broadcast(new GameData("BUTTON", data.getValue()));
	}

	public void addSCORE(GameData data) { // 주사위로 나온 점수 증가 시키기
		broadcast(new GameData("SCORE", opp, data.getValue()));
		System.out.println(data.getValue());
		System.out.println("manager에서 add완료!");
		changeTurn();
	}

	public void checkWORD(GameData data) {
		try {
			if (data.getWord().equals(word)) { // 정답인 경우
				userList.get(opp).writeObject(new GameData("ANSWER", "YES","OPP"));
				userList.get(opp).flush();
				userList.get(turn).writeObject(new GameData("ANSWER","YES","TURN"));
				userList.get(turn).flush();
				broadcast(new GameData("SCORE", turn, 3)); // turn=출제자 점수 올려줘라
				broadcast(new GameData("TIMER","RESET"));
				
				
			} else { // 오답인 경우
				userList.get(opp).writeObject(new GameData("ANSWER", "NO"));
				userList.get(opp).flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void broadcast(GameData data) {
		for (ObjectOutputStream stream : userList) {
			try {
				stream.writeObject(data);
				stream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void sendRSPResult(int winner, int loser) { // 가위바위보 결과를 알려주는 메소드
		String[] word = dao.getWord();
		// winner,loser는 0,1로 표현.
		// 먼저 들어온애가 이겼으면 0 , 1 / 늦게 들어온애가 이겼으면 1,0
		try {
			userList.get(winner).writeObject(new GameData("RSP", "WIN", word));
			userList.get(winner).flush();
			turn = winner; // 턴 정해주기
			userList.get(loser).writeObject(new GameData("RSP", "LOSE"));
			userList.get(loser).flush();
			opp = loser; // 상대방 정해주기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendInitial() {
		String initial = dao.getInitial();

		try {
			userList.get(opp).writeObject(new GameData("INI", initial));
			userList.get(opp).flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getUser() {
		return userList.size();
	}

	public static String getWord() {
		return word;
	}
}
