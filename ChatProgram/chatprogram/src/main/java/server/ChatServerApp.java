package server;

import com.mjc813.network.chatpgm.ChatCommand;
import com.mjc813.network.chatpgm.ChatData;
import com.mjc813.network.chatpgm.json.JsonProcesser;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ChatServerApp extends Thread implements IClientProccess {
    private Integer uniqRoomId = 1;
    private JsonProcesser jsonProcesser = new JsonProcesser();
    private ServerSocket serverSocket;  // 클라이언트 접속 대기

    /**
     * serverSocket 에서 accept 된 클라이언트 소켓과 버퍼읽기, 버퍼쓰기, read 스레드, write 등이 있는 클래스
     * 클래스를 객체들의 컬렉션이다.
     */
    private List<ChatClientInfo> clientInfoList = new LinkedList<>();

    /**
     * ChatRoomInfo 클래스의 대화방이 여러개 있는 컬렉션이다.
     */
    private List<ChatRoomInfo> roomInfoList = new LinkedList<>();

    public void init(int port) throws IOException {
        this.serverSocket = new ServerSocket();
        this.serverSocket.bind(new InetSocketAddress(port));
    }

    public void accept() throws IOException {
        Socket socket = this.serverSocket.accept();
        System.out.printf("accept Client : %s\n", socket);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );
        ChatClientInfo client = new ChatClientInfo(
                socket, br, bw, "", 0, ""
                , this, jsonProcesser
        );
        client.start();
        synchronized (this.clientInfoList) {
            this.clientInfoList.add(client);
        }
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }

    public void write(String str) throws IOException {
//        if(exitWord.equals(str)) {
//            str = exitCommand;
//        }
//        this.sendAllTargets(str);
    }

    // @Override

    /**
     * roomId 대화방에 있는 ChatClientInfo(서버에접속했고 대화방에있는) 데이터형 객체들에게 str 문자열을 전송한다.
     * @param roomId 대화방의 고유번호
     * @param str 대화방의 메세지
     * @return
     */
    public int sendRoomTarget(Integer roomId, String str) {
        Optional<ChatRoomInfo> roomInfo;
        int size = 0;
        synchronized (this.roomInfoList) {
            roomInfo = this.roomInfoList.parallelStream()
                    .filter(x -> x.getRoomId().equals(roomId))
                    .findFirst();
            // roomInfo 는 roomId 값과 같은 대화방이다.
            if ( roomInfo.isPresent() ) {
                // roomInfo 를 찾았으면
                size = roomInfo.get().getClients().size();  // roomInfo 의 클라이언트 갯수
                for (ChatClientInfo cci : roomInfo.get().getClients()) {
                    // roomInfo 에 있는 클라이언트 각각마다 write 를 실행하고 혹시 예외가 발생하더라도
                    // 다음 클라이언트에게 전송해야 한다.
                    try {
                        cci.write(str);
                    } catch (IOException ex) {
                        System.out.printf("해당 클라이언트[%s] 접속 끊겼음\n", cci.getSocket().getRemoteSocketAddress());
                    }
                }
            }
        }
        return size;
    }

    @Override
    public void deleteClient(ChatClientInfo clientInfo, Integer roomId) {
        this.exitRoom(clientInfo, roomId);
    }

    @Override
    public String processCommand(ChatClientInfo clientInfo, ChatData cd) {
        String result = "";
        ChatRoomInfo cri;
        switch(cd.getCommand()) {
            case ChatCommand.ROOMLIST:
//                result = "방목록 문자열 만든다";
                result = this.getStringRoomList();
                break;
            case ChatCommand.CREATEROOM:
                this.createRoom(clientInfo, cd);
                result = this.jsonProcesser.chatDataToJsonString(cd);
//result = "새로운방을 이름으로 만들고 방번호를 클라이언트에게 응답해야 한다.";
                break;
            case ChatCommand.ENTERROOM:
//                result = "방번호로 입장 시키고 출력할 문자열을 처리한다.";
                this.enterRoom(clientInfo, cd);
                result = this.getStringFromCommandData(clientInfo, cd);
                break;
            case ChatCommand.CHAT:
                result = this.getStringFromCommandData(clientInfo, cd);
                break;
            case ChatCommand.EXITROOM:
                this.exitRoom(clientInfo, cd.getRoom());
                result = this.getStringFromCommandData(clientInfo, cd);
                break;
        }
        return result;
    }

    private void createRoom(ChatClientInfo clientInfo, ChatData cd) {
        ChatRoomInfo cri = new ChatRoomInfo();
        cri.setRoomId(this.uniqRoomId++);
        cri.setRoomName(cd.getRoomName());
        cd.setRoom(cri.getRoomId());
        cd.setCommand(ChatCommand.SERVERCREATEDROOM);

        synchronized (this.roomInfoList) {
            this.roomInfoList.add(cri); // 대화방 목록에 대화방을 생성
            cri.getClients().add(clientInfo);   // 해당대화방에 대화할 클라이언트정보를 추가
        }
    }

    private void enterRoom(ChatClientInfo clientInfo, ChatData cd) {
        Optional<ChatRoomInfo> any;
        synchronized (this.roomInfoList) {
            any = this.roomInfoList.parallelStream()
                    .filter(x -> x.getRoomId().equals(cd.getRoom()))
                    .findFirst();
        }
        if ( any.isPresent() ) {
            // cd.room 번호로 대화방을 찾았을때
            synchronized (this.roomInfoList) {
                cd.setRoomName(any.get().getRoomName());
                any.get().getClients().add(clientInfo);   // 해당대화방에 대화할 클라이언트정보를 추가
            }
//          대화방의 클라이언트에게 입장했다는 메세지를 전송해야 한다.
        } else {
            // cd.room 번호로 대화방이 없을경우
            cd.setCommand(ChatCommand.EMPTYROOM);
//          방이 사라져버렸다는거를 클라이언트에게 알려줘야 한다.
        }
    }

    private void exitRoom(ChatClientInfo clientInfo, Integer roomId) {
        if ( roomId <= 0 ) {
            return;
        }
        Optional<ChatRoomInfo> any;
        synchronized (this.roomInfoList) {
            any = this.roomInfoList.parallelStream()
                    .filter(x -> x.getRoomId().equals(roomId))
                    .findFirst();
        }
        if ( any.isPresent() ) {
            // roomId 번호로 대화방을 찾았을때
            synchronized (this.roomInfoList) {
                // 해당대화방에서 클라이언트를 제거해야 한다.
                any.get().getClients().remove(clientInfo);
                if (any.get().getClients().size() <= 0 ) {
                    // 해당 대화방의 유저가 0 이하 일때 대화방 목록에서 대화방을 삭제해야 한다.
                    this.roomInfoList.remove(any.get());
                }
            }
        }
    }

    private String getStringRoomList() {
        String result;
        if ( this.roomInfoList.size() <= 0 ) {
            result = "방이 없습니다.";
        } else {
            result = this.roomInfoList.stream().map((x) -> {
//                return x.getRoomId();
                return String.format("[%d]\t%s(%d)\n"
                        , x.getRoomId()
                        , x.getRoomName()
                        , x.getClients().size());
            }).reduce("", (a, b) -> (a += b));
        }
        return result;
    }

    private String getStringFromCommandData(ChatClientInfo clientInfo, ChatData cd) {
        String result = "";
        if ( cd.getCommand() == ChatCommand.EXITROOM ) {
            result = String.format("(%s):\t%s", clientInfo.getUserName(), "퇴장 했습니다.");
        } else if ( cd.getCommand() == ChatCommand.CREATEROOM || cd.getCommand() == ChatCommand.ENTERROOM ) {
            result = String.format("(%s):\t%s", clientInfo.getUserName(), "입장 했습니다.");
            cd.setCommand(ChatCommand.SERVERCREATEDROOM);
        } else if ( cd.getCommand() == ChatCommand.CHAT ) {
            result = String.format("(%s):\t%s", clientInfo.getUserName(), cd.getData());
        } else {
            result = "";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Chat Server App start");

        ChatServerApp csa = new ChatServerApp();
        try {
            csa.init(58989);
            csa.start();

            Scanner scan = new Scanner(System.in);
            while( true ) {
                String str = scan.nextLine();   // 키보드 입력 대기, 블로킹상태
                csa.write(str);
                if( "exit".equals(str) ) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                this.accept();
            }
        } catch (Exception ex) {
            System.out.println("서버 종료");
        } finally {
            try {
                this.close();
            } catch (IOException e) {
            }
        }
    }
}
