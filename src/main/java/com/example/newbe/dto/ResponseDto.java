package com.example.newbe.dto;

import lombok.Data;

public class ResponseDto {
    private String msg;
    private String code;

    public ResponseDto() {
    }

    public ResponseDto(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
