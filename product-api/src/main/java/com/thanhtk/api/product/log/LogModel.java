package com.thanhtk.api.product.log;

import lombok.Data;

import java.util.Date;

@Data
public class LogModel {
    private Date startTime;
    private Date endTime;
    private String action;
    private Long duration;
    private String response;
    private String request;

    public LogModel(String action, String request){
        this.startTime = new Date();
        this.action = action;
        this.request = request;
    }

    public void end(){
        this.endTime = new Date();
        duration = endTime.getTime() - startTime.getTime();

    }

}
