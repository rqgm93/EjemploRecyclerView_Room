package com.raquel.garvi.ejemplorecyclerview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Digimon {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String type;
    private String level;

    public Digimon(String name, String type, String level) {
        this.name = name;
        this.type = type;
        this.level = level;
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

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }
}
