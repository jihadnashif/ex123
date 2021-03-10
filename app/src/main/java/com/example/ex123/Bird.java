package com.example.ex123;

import java.io.Serializable;

public class Bird implements Serializable {
    private String name,scientificName,type,image,length, food, localFrequencyLocation, description, localSeason;

    public Bird(String name, String scientificName, String type, String image, String length, String food, String localFrequencyLocation, String description, String localSeason) {
        this.name = name;
        this.scientificName = scientificName;
        this.type = type;
        this.image = image;
        this.length = length;
        this.food = food;
        this.localFrequencyLocation = localFrequencyLocation;
        this.description = description;
        this.localSeason = localSeason;
    }

    public Bird() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocalFrequencyLocation() {
        return localFrequencyLocation;
    }

    public void setLocalFrequencyLocation(String localFrequencyLocation) {
        this.localFrequencyLocation = localFrequencyLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalSeason() {
        return localSeason;
    }

    public void setLocalSeason(String localSeason) {
        this.localSeason = localSeason;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
