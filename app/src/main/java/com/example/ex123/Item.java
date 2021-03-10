package com.example.ex123;

public class Item {
    //Attributes
    private String name;
    private String password;
    private String email;
    private String id;
    private boolean isDetailsSaved;

    //Constructor
    public Item(String name, String password, String email, String id, boolean isDetailsSaved) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.id = id;
        this.isDetailsSaved = isDetailsSaved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDetailsSaved() {
        return isDetailsSaved;
    }

    public void setDetailsSaved(boolean detailsSaved) {
        isDetailsSaved = detailsSaved;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
