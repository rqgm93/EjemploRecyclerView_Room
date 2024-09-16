package com.raquel.garvi.ejemplorecyclerview;

public class Digimon {
    private String name;
    private String type;
    private String level;

    public Digimon(String name, String type, String level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }
}
