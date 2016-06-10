package jako.jocantaro.android.androidchat.entities;

import java.util.Map;

/**
 * Created by jocantaro on 10/06/16.
 */
public class User {
    String email;
    boolean online;
    Map<String,Boolean> contacts;

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Map<String, Boolean> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, Boolean> contacts) {
        this.contacts = contacts;
    }

    public final static boolean ONLINE = true;
    public final static boolean OFFLINE = false;



}
