package server;

import com.mjc813.network.chatpgm.ChatData;

public interface IClientProccess {
    /**
     * 서버에서 실행한다. 대화방에 str 메세지를 전송한다.
     * @param roomId 대화방의 고유번호
     * @param str 대화방의 메세지
     * @return
     */
    public int sendRoomTarget(Integer roomId, String str);

    /**
     * 서버에서 실행한다. 클라이언트 접속이 끊어지면 대화방에도 있다면 대화방에서도 삭제한다.
     * 클라이언트 접속되어 있는 clientInfo 를 삭제한다.
     * @param clientInfo
     * @param roomId
     */
    public void deleteClient(ChatClientInfo clientInfo, Integer roomId);

    /**
     * 서버에서 실행한다. 클라이언트로부터 받은 명령어를 해석하고 그 명령에 대한 실행을 서버에서 실행한다.
     * @param clientInfo
     * @param cd
     */
    public String processCommand(ChatClientInfo clientInfo, ChatData cd);
}
