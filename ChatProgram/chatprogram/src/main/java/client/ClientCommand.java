package client;

import com.mjc813.network.chatpgm.ChatData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCommand {
    private ClientMode clientMode = ClientMode.MENU;
    private ChatData chatData = new ChatData();
}
