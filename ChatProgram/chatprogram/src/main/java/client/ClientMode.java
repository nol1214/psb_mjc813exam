package client;

public enum ClientMode {
    /**
     * 클라이언트가 메뉴에 있는 상황
     */
    MENU,
    /**
     * 클라이언트가 서브메뉴에 있는 상황
     */
    SUBMENU,
    /**
     * 클라이언트가 대화방에서 대화 중인 상황
     */
    CHATTING,
}
