package jako.jocantaro.android.androidchat.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jocantaro on 14/06/16.
 */
@JsonIgnoreProperties({"sentByMe"}) //para que el parser, json, lo ignore. Le digo que sentByMe no me interesa
public class ChatMessage {

    private String msg;
    private String sender;
    private boolean sentByMe;

    //Firebase puede dar problemas si no hay constructor, hay que crearlo aunque est'e vac'io
    public ChatMessage(){}

    public ChatMessage(String sender, String msg){
        this.msg = msg;
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean isSentByMe() {
        return sentByMe;
    }

    public void setSentByMe(boolean sentByMe) {
        this.sentByMe = sentByMe;
    }



}
