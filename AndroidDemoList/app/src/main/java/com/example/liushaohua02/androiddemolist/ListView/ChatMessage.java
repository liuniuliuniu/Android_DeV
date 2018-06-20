package com.example.liushaohua02.androiddemolist.ListView;

public class ChatMessage {

    public ChatMessage(int mID, int mFriendID, String mName, String mDate, String mContent, boolean mISComming) {
        this.mID = mID;
        this.mFriendID = mFriendID;
        this.mName = mName;
        this.mDate = mDate;
        this.mContent = mContent;
        this.mISComming = mISComming;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public int getmFriendID() {
        return mFriendID;
    }

    public void setmFriendID(int mFriendID) {
        this.mFriendID = mFriendID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public boolean ismISComming() {
        return mISComming;
    }

    public void setmISComming(boolean mISComming) {
        this.mISComming = mISComming;
    }

    private int mID;
    private int mFriendID;
    private String mName;
    private String mDate;
    private String mContent;
    boolean mISComming;


}
