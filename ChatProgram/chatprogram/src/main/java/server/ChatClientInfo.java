package server;

import com.mjc813.network.chatpgm.ChatCommand;
import com.mjc813.network.chatpgm.ChatData;
import com.mjc813.network.chatpgm.json.JsonProcesser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

/**
 * ChatServerApp 는 접속하는 클라이언트들을 컬렉션 형태로 저장해야 한다.
 * 이 객체 1개는 클라이어트 1개 접속한 정보를 가지고 있다.
 */
@Getter
@Setter
@AllArgsConstructor
public class ChatClientInfo extends Thread {
    /**
     * 서버가 클라이언트와 통신할 클라이언트소켓
     */
    private Socket socket;
    /**
     * 서버가 클라이언트로부터 데이터를 읽을때 사용할 버퍼스트림리더
     */
    private BufferedReader br;
    /**
     * 서버가 클라이언트에게 데이터를 보낼때 사용할 버퍼스트림Writer
     */
    private BufferedWriter bw;

    /**
     * 클라이언트의 대화명
     */
    private String userName;
    /**
     * 클라이언트가 입장한 대화방 id, 0이거나 null 이면 대화방 퇴장
     */
    private Integer chattingRoomId;
    private String chattingRoomName;

    private IClientProccess iClientProccess;
    private JsonProcesser jsonProcesser;

    @Override
    public void run() {
        while(true) {
            try {
                String str = this.br.readLine();
                // 클라이언트가 전달한 데이터는 서버의 이 문장에서 읽을 수 있다.
                // 서버는 클라이언트가 연결될때마다 이 객체를 하나씩 생성해서 컬렉션에 보관한다.
                // 클라이언트 연결이 해제되면 이 객체도 사라져야 합니다.
                this.parseCommand(str);
            } catch (ParseException e) {
                // parseCommand 에서 발생하는 예외
                System.out.println("JSON 명령어해석 예외");
            } catch (IOException e) {
                // read 중에 예외가 발생하는 경우는 99.9%가 소켓이 끊어졌습니다.
                try {
                    if (this.chattingRoomId > 0) {
                        ChatData cd = new ChatData(ChatCommand.EXITROOM
                                , this.chattingRoomId, ""
                                , this.chattingRoomName, this.userName);
                        String result = this.iClientProccess.processCommand(this, cd);
                        this.iClientProccess.sendRoomTarget(this.chattingRoomId, result);
                        // chattingRoomId 번호에 해당하는 대화방에 있었을경우에 소켓이 끊어지면
                        // 다른 대화자에게 이 사람 퇴장했다고 출력하는 용도
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("socket 종료");
                break;
            }
        }
        this.close();
        this.iClientProccess.deleteClient(this, this.chattingRoomId);
    }

    public void close() {
        try {
            this.bw.close();
            this.br.close();
            this.socket.close();
        } catch (IOException e) {
        }
    }

    public void write(String str) throws IOException {
        if ( str == null || "".equals(str) ) {
            return;
        }
        this.bw.write(str);
        this.bw.newLine();
        this.bw.flush();
    }

    /**
     * 클라이언트로부터 받은 str 문자열을 파싱해서 명령어를 해석하고
     * 채팅모드일때는 문자를 해당 대화방의 사용자에게 다시 전달해야 한다.
     * @param str
     * @throws ParseException
     * @throws IOException
     */
    private void parseCommand(String str) throws ParseException, IOException {
        ChatData cd = this.jsonProcesser.jsonStringToChatData(str);
        String result;
        switch(cd.getCommand()) {
            case ChatCommand.CHANGENAME:
                this.setUserName(cd.getData());
                break;
            case ChatCommand.ROOMLIST:
                result = this.iClientProccess.processCommand(this, cd);
                this.write(result);
                break;
            case ChatCommand.CREATEROOM:
                this.setChattingRoomName(cd.getRoomName());
                this.setUserName(cd.getUserName());
                result = this.iClientProccess.processCommand(this, cd);
                this.setChattingRoomId(cd.getRoom());
                this.write(result);
                break;
            case ChatCommand.ENTERROOM:
                this.setChattingRoomId(cd.getRoom());
                this.setUserName(cd.getUserName());
                result = this.iClientProccess.processCommand(this, cd);
                if (cd.getCommand() == ChatCommand.EMPTYROOM) {
                    this.write(this.jsonProcesser.chatDataToJsonString(cd));
                } else {
                    this.setChattingRoomName(cd.getRoomName());
                    this.iClientProccess.sendRoomTarget(this.getChattingRoomId(), result);
                }
                break;
            case ChatCommand.CHAT:
                result = this.iClientProccess.processCommand(this, cd);
                this.iClientProccess.sendRoomTarget(this.getChattingRoomId(), result);
                break;
            case ChatCommand.EXITROOM:
                result = this.iClientProccess.processCommand(this, cd);
                this.iClientProccess.sendRoomTarget(this.getChattingRoomId(), result);
//                this.chattingRoomId = 0;
                this.setChattingRoomId(0);
                break;
        }
    }
}
