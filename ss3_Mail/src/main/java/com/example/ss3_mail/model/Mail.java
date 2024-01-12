package com.example.ss3_mail.model;

public class Mail {
    int id;
    private String[] languages;
    private String [] size;
    private String Spams_Fillter;
    private String [] signature;

    public Mail() {
    }

    public Mail(String[] languages, String[] size, String spams_Fillter, String[] signature) {
        this.languages = languages;
        this.size = size;
        this.Spams_Fillter = spams_Fillter;
        this.signature = signature;
    }

    public Mail(int id, String[] languages, String[] size, String spams_Fillter, String[] signature) {
        this.id = id;
        this.languages = languages;
        this.size = size;
        this.Spams_Fillter = spams_Fillter;
        this.signature = signature;
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

    public String[] getSize() {
        return size;
    }

    public void setSize(String[] size) {
        this.size = size;
    }

    public String getSpams_Fillter() {
        return Spams_Fillter;
    }

    public String[] getSignature() {
        return signature;
    }

    public void setSignature(String[] signature) {
        this.signature = signature;
    }



}
