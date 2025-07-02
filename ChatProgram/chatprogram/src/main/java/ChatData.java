
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatData {
    /**
     * 명령어
     */
    private ChatCommand command;
    /**
     * 대화방 고유번호
     */
    private Integer room;
    /**
     * 보낼 데이터 (명령어의 정보, 채팅메세지)
     */
    private String data;
    /**
     * 대화방 이름 (출력용도)
     */
    private String roomName;
    /**
     * 대화자 명 (출력용도)
     */
    private String userName;
}
