package json;



public class JsonProcesser {
    JSONObject jsonObject = new JSONObject();
    JSONParser parser = new JSONParser();

    /**
     * ChatData 자바객체를 json 형식의 문자열로 변환하여 리턴한다.
     * @param
     * @return
     */
    public String chatDataToJsonString(ChatData cd) {
        if(cd == null) {
            return "{}";
        }
        jsonObject.put("command", cd.getCommand().toString());
        jsonObject.put("data", cd.getData());
        jsonObject.put("room", cd.getRoom());
        jsonObject.put("userName", cd.getUserName());
        jsonObject.put("roomName", cd.getRoomName());
        return jsonObject.toJSONString();
    }

    /**
     * str json 형식의 문자열을 ChatData 자바객체로 변환하여 리턴한다.
     * @param str
     * @return
     */
    public ChatData jsonStringToChatData(String str) throws ParseException {
        JSONObject parsedJsonObject = (JSONObject) parser.parse(str);
        ChatData cd = new ChatData();
        ChatCommand cc;
        try {
            cc = ChatCommand.valueOf((String) parsedJsonObject.get("command"));
            cd.setCommand(cc);
            if ( parsedJsonObject.get("room") == null ) {
                cd.setRoom(0);
            } else {
                cd.setRoom(Integer.parseInt(((Long) parsedJsonObject.get("room")).toString()));
            }
            if ( parsedJsonObject.get("roomName") == null ) {
                cd.setRoomName("");
            } else {
                cd.setRoomName((String)parsedJsonObject.get("roomName"));
            }
            if ( parsedJsonObject.get("data") == null ) {
                cd.setData("");
            } else {
                cd.setData((String)parsedJsonObject.get("data"));
            }
            if ( parsedJsonObject.get("userName") == null ) {
                cd.setUserName("");
            } else {
                cd.setUserName((String)parsedJsonObject.get("userName"));
            }
        } catch (Exception ex) {
            throw new ParseException(9999, ex);
        }
        return cd;
    }
}
