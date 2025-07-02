package server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomInfo {
    /**
     * 대화방 id (고유한 값)
     */
    private Integer roomId;
    /**
     * 대화방 명
     */
    private String roomName;
    /**
     * 대화방에 입장한 클라이언트 정보들의 컬렉션
     */
    private List<ChatClientInfo> clients = new LinkedList<>();

    public Boolean add(ChatClientInfo cri) {
        return this.clients.add(cri);
    }

    public Boolean remove(ChatClientInfo cri) {
        return this.clients.remove(cri);
    }
}
