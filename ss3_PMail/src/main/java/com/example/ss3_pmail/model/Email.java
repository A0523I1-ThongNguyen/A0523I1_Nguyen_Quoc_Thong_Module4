package com.example.ss3_pmail.model;

public class Email {
    int id;
    private String[] langueges ;
    private String[] size;
    private String Spam;
    private String signature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Email(int id, String[] langueges, String[] size, String spam, String signature) {
        this.id = id;
        this.langueges = langueges;
        this.size = size;
        Spam = spam;
        this.signature = signature;
    }

    public Email() {
    }

    public Email(String[] langueges, String[] size, String spam, String signature) {
        this.langueges = langueges;
        this.size = size;
        Spam = spam;
        this.signature = signature;
    }

    public String[] getLangueges() {
        return langueges;
    }

    public void setLangueges(String[] langueges) {
        this.langueges = langueges;
    }

    public String[] getSize() {
        return size;
    }

    public void setSize(String[] size) {
        this.size = size;
    }

    public String getSpam() {
        return Spam;
    }

    public void setSpam(String spam) {
        Spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
