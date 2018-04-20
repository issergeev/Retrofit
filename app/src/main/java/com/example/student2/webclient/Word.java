package com.example.student2.webclient;

import java.util.List;

public class Word {

    private Integer code;
    private String lang;
    private List<String> text = null;
    private String APIKEY;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

}