package com.example.owner.woodrecognitionapp;

public class TreeClass {

    private int id;
    private String name;
    private String familyName;
    private byte[] image;

    public TreeClass(int id, String name, String familyName, byte[] image) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
