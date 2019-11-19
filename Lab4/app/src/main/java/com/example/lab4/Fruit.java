package com.example.lab4;

public class Fruit {

    private String name;
    private String color;
    private String urlPicture;

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public Fruit(String name, String color, String urlPicture) {
        this.name = name;
        this.color = color;
        this.urlPicture = urlPicture;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
