package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends JFrame implements ActionListener {
    private static final int DATAPORT = 1111;
    private static final int GAMEPORT = 1112;
    private static final int THREAD_CNT = 10;
    private DataServer dataServer;
    private GameServer gameServer;
    private ExecutorService dataThreadPool = null, gameThreadPool = null;
    private ServerSocket dataSocket = null, gameSocket = null;
    public JTextArea textArea;
    private JButton dataStart, dataStop, gameStart, gameStop;
    private Thread data, game;

    private Server() {
        JPanel btnPanel = new JPanel(new GridLayout(2, 2));
        JScrollPane scrollPane = new JScrollPane();
        setSize(600, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textArea = new JTextArea(10, 40);
        dataStart = new JButton("데이터서버 시작");
        dataStop = new JButton("데이터서버 중단");
        gameStart = new JButton("게임서버 시작");
        gameStop = new JButton("게임서버 중단");
        dataStart.addActionListener(this);
        dataStop.addActionListener(this);
        gameStart.addActionListener(this);
        gameStop.addActionListener(this);
        dataStop.setEnabled(false);
        gameStop.setEnabled(false);
        scrollPane.setViewportView(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        btnPanel.add(dataStart);
        btnPanel.add(dataStop);
        btnPanel.add(gameStart);
        btnPanel.add(gameStop);
        textArea.setText("");
        add(btnPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Server();
    }

    private void startServer(String type) {
        if (type.equals("DATA")) {
            dataThreadPool = Executors.newFixedThreadPool(THREAD_CNT);
            dataServer = new DataServer();
            new Thread(dataServer).start();
        } else if(type.equals("GAME")) {
            gameThreadPool = Executors.newFixedThreadPool(THREAD_CNT);
            gameServer = new GameServer();
            new Thread(gameServer).start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == dataStart) {
            startServer("DATA");
            dataStart.setEnabled(false);
            dataStop.setEnabled(true);
        } else if (obj == dataStop) {
            dataServer.stopThread();
            dataStop.setEnabled(false);
            dataStart.setEnabled(true);
        } else if (obj == gameStart) {
            startServer("GAME");
            gameStart.setEnabled(false);
            gameStop.setEnabled(true);
        } else if (obj == gameStop) {
            gameServer.stopThread();
            gameStop.setEnabled(false);
            gameStart.setEnabled(true);
        }
    }

    class DataServer implements Runnable {
        // 운체 때 배운 mutex 같은 거. 그냥 아무일도 안하는 애지만 synchronized로 묶으면
        // 한 작업밖에 못 씀.(동시에 접근 못함)
        private final Object lock = new Object();

        @Override
        public void run() {
            try {
                dataSocket = new ServerSocket(DATAPORT);
                textArea.append("데이터베이스 서버 동작 중\n");
                while (true) {
                    Socket socket = dataSocket.accept();
                    synchronized (lock) {
                        dataThreadPool.execute(new DataThread(socket, textArea));
                        textArea.append(socket.getInetAddress() + "이 데이터서버에 연결되었습니다.\n");
                    }
                }
            } catch (IOException e) {
                textArea.append("데이터서버 종료\n");
            } finally {
                dataThreadPool.shutdown();
            }
        }

        void stopThread() {
            try {
                synchronized (lock) {
                    dataSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class GameServer implements Runnable {
        private final Object lock = new Object();

        @Override
        public void run() {
            try {
                gameSocket = new ServerSocket(GAMEPORT);
                textArea.append("게임서버 동작 중\n");

                while (true) {
                    Socket socket = gameSocket.accept();
                    synchronized (lock) {
                        gameThreadPool.execute(new GameThread(socket, textArea));
                        textArea.append(socket.getInetAddress() + "이 게임서버에 연결되었습니다.\n");
                    }
                }
            } catch (IOException e) {
                textArea.append("게임서버 종료\n");
            } finally {
                gameThreadPool.shutdown();
            }
        }

        void stopThread() {
            try {
                synchronized (lock) {
                    gameSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
