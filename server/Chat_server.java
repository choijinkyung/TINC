package server;
import java.io.*;
import java.net.*;
import java.util.*;

public class Chat_server {

   // The port that the server listens on.
   private static final int PORT = 9001;   // 포트번호 9001

   private static HashSet<String> names = new HashSet<String>(); // names라는 이름의 집합을 만드는 hash set 생성!

   private static HashSet<String> whisper = new HashSet<String>();   // 귓속말을 하는 이름의 집합을 만드는 hash set 생성!

   private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();// write를 하는 이름의 집합을 만드는 hash set 생성!

   public static void main(String[] args) throws Exception {
      System.out.println("The chat server is running.");
      ServerSocket listener = new ServerSocket(PORT); //누가 접속을 하는지 보는 소켓! 서버에서 클라이언트가 오나안오나 listen!
      try {
         while (true) {
            new Handler(listener.accept()).start();   // 어떤 클라이언트가 들어오면 Handler class객체(스레드객체!thread를 extends) 생성 후 스레드 실행
         }
      } finally {
         listener.close();
      }
   }

   private static class Handler extends Thread {   // extends Thread
      private String name;
      private Socket socket;
      private BufferedReader in;
      private PrintWriter out;
      private boolean check = false;
      private String s, tmp;

      public Handler(Socket socket) {
         this.socket = socket;
      }

      public void run() {
         try {

            // Create character streams for the socket.
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Request a name from this client. Keep requesting until
            // a name is submitted that is not already used. Note that
            // checking for the existence of a name and adding the name
            // must be done while locking the set of names.
            // And adding the whisper
            while (true) {
               out.println("SUBMITNAME");
               name = in.readLine();
               if (name == null) {
                  return;
               }
               synchronized (names) {   // 다른 쓰레드가 사용하고 있을 땐 막는다.
                  if (!names.contains(name)) {
                     names.add(name);
                     whisper.add("<" + name + "/>");
                     System.out.println("[ENTER] The client <"+name+"> enter!");
                     break;
                  }
               }
            }

            // Now that a successful name has been chosen, add the
            // socket's print writer to the set of all writers so
            // this client can receive broadcast messages.
            out.println("NAMEACCEPTED");
            writers.add(out);
            // this client can receive broadcast message about entering
            for (PrintWriter writer : writers) {
               writer.println("ENTRANCE " + "<" + name + ">" + " Enter");
            }
            
            while (true) {
               String input = in.readLine();
               
               if(input.startsWith("GIVETOME")) {
                  int tmp=names.size();
                  for(String i : names) {
                     out.println("CLIENTS "+i);
                  }
                     continue;
               }
               if (input == null) {
                  return;
               }
               Iterator<String> iter = whisper.iterator(); // iterator : 집합의 요소를 하나씩 보여줌
               while (iter.hasNext()) {   // 괄호 -> 다음 것이 있으면 true, 아니면 false
                  s = iter.next();
                  if (input.startsWith(s)) {
                     tmp = s;
                     check = true;
                  }
               }
               // if format is whisper
               if (check == true) {
                  out.println("OWN " + name + ": " + input.substring(tmp.length()));
                  // this client can receive broadcast message about
                  // whispering.
                  for (PrintWriter writer : writers) {
                     writer.println("WHISPER " + tmp + name + ": " + input.substring(tmp.length()));
                  }
                  check = false;
               } 
               else {
                  if (input.substring(0, 1).equals("<") && input.contains("/>")) {
                     out.println("ERROR " + "Not in this room");
                  }
                  // if format is default message
                  else {
                     for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                     }
                  }
               }
            }
         } catch (IOException e) {
            //System.out.println(e);
         } finally {
            // This client is going down!
            // This client can receive broadcast message about exiting
            // Remove its name and its print
            // writer from the sets, and close its socket.
            for (PrintWriter writer : writers) {
               writer.println("EXIT " + "<" + name + ">" + "Exit");
            }
            System.out.println("[EXIT] The client <"+name+"> exit!");
            if (name != null) {
               names.remove(name);
            }
            if (out != null) {
               writers.remove(out);
            }
            try {
               socket.close();
            } catch (IOException e) {
               
            }
         }
      }
   }
}