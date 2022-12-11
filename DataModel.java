package com.example.matala2_java_the8;

public class DataModel {

    String name;
    String description;
    String morDescription;
    int image;

    public DataModel(String name,String description,int image,String morDescription){
        this.description=description;
        this.image=image;
        this.name=name;
        this.morDescription=morDescription;
    }

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}

    public int getImage() {
        return image;
    }

    public String getMorDescription() {
        return morDescription;
    }
}