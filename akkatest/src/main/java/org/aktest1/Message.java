package org.aktest1;

/**
 * Created by zgl on 17-10-11.
 */
public class Message {
    private int totalpage;
    private int totalbytes;

    public Message() {

    }

    public Message(int totalpage, int totalbytes) {
        this.totalpage = totalpage;
        this.totalbytes = totalbytes;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getTotalbytes() {
        return totalbytes;
    }

    public void setTotalbytes(int totalbytes) {
        this.totalbytes = totalbytes;
    }

    @Override
    public String toString() {
        return "Message{" +
                "totalpage=" + totalpage +
                ", totalbytes=" + totalbytes +
                '}';
    }
}
