package com.test.publisher;

public class TerminateMessage {
	
private String msg;
    
    public TerminateMessage(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String str) {
        this.msg=str;
    }

}
