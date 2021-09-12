package com.tik.mysystem.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class WorkWxNotifyDto {

    @JsonProperty("ToUserName")
    private String toUserName;
    @JsonProperty("FromUserName")
    private String fromUserName;
    @JsonProperty("CreateTime")
    private String createTime;
    @JsonProperty("MsgType")
    private String msgType;
    @JsonProperty("Event")
    private String event;
    @JsonProperty("ChangeType")
    private String changeType;
    @JsonIgnore
    private String data;
}
