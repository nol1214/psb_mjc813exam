
public enum ChatCommand {
    /**
     * 대화명 변경
     */
    CHANGENAME,
    /**
     * 대화방 목록
     */
    ROOMLIST,
    /**
     * 대화방 생성
     */
    CREATEROOM,
    /**
     * 서버에서 대화방을 새로 만들고 대화방 번호를 클라이언트에게 리턴하는 명령어
     */
    SERVERCREATEDROOM,
    /**
     * 대화방 입장
     */
    ENTERROOM,
    /**
     * 대화방 스스로 퇴장
     */
    EXITROOM,
    /**
     * 모든 대화자가 없으면 대화방을 삭제 하게 되므로
     * 대화방 없음을 클라이언트에게 전달해야 한다.
     */
    EMPTYROOM,
    /**
     * 대화메세지
     */
    CHAT,
    /**
     * 클라이언트 프로그램을 중지
     */
    EXITPGM,
}
