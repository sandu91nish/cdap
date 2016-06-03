package com.teachme_module;

/**
 * Created by PC PAL on 5/29/2016.
 */
public class Questions {

    private int quzId;
    private String quz;

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    private String ans;

    public Questions(int quzId, String quz,String ans) {
        this.quzId = quzId;
        this.quz = quz;
        this.ans=ans;
    }

    public int getQuzId() {
        return quzId;
    }

    public void setQuzId(int quzId) {
        this.quzId = quzId;
    }

    public String getQuz() {
        return quz;
    }

    public void setQuz(String quz) {
        this.quz = quz;
    }
}
