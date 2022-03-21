package com.tik.mysystem.system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class InvoicingCallbackResponseDto implements Serializable {
    private static final long serialVersionUID = 6829288419206565249L;
    public static final String SUCCESS_CODE = "SUCCESS";
    private String code;
    private String msg;
}
