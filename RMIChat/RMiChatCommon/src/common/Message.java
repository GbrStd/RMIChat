package common;

import java.io.Serializable;

public class Message implements Serializable {

    private String owner;

    private String content;

    public Message(String owner, String content) {
        this.owner = owner;
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "owner='" + owner + '\'' +
                ", message='" + content + '\'' +
                '}';
    }

}
