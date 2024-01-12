package com.example.ss3_thu_dien_tu.model;

public class Email {
    private int id;
    private String[] languages;
    private String[] pageSize;
    private String spamsFillter;
    private String[] signature;

    public Email(int id, String[] languages, String[] pageSize, String spamsFillter, String[] signaturte) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signaturte;
    }
    public Email(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getPageSize() {
        return pageSize;
    }

    public void setPageSize(String[] pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(String spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String[] getSignature() {
        return signature;
    }

    public void setSignature(String[] signaturt) {
        this.signature = signaturt;
    }
}
