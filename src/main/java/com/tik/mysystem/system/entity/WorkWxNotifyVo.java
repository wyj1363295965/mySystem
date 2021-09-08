package com.tik.mysystem.system.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "xml")
public class WorkWxNotifyVo {

    @JacksonXmlProperty(localName = "ToUserName")
    //@JacksonXmlCData
    private String toUserName;

    @JacksonXmlProperty(localName = "AgentID")
    //@JacksonXmlCData
    private String agentId;

    @JacksonXmlProperty(localName = "Encrypt")
    //@JacksonXmlCData
    private String encrypt;
}
